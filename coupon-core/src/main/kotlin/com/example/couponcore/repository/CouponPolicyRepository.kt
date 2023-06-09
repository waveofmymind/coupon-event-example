package com.example.couponcore.repository

import com.example.couponcore.domain.CouponPolicy
import com.example.couponcore.domain.QCouponPolicy.couponPolicy
import com.example.couponcore.dto.CouponPolicyDto
import com.example.couponcore.dto.QCouponPolicyDto
import jakarta.persistence.EntityManager
import jakarta.persistence.PersistenceContext
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport
import org.springframework.stereotype.Repository


@Repository
class CouponPolicyRepository(
    private val couponPolicyJpaRepository: CouponPolicyJpaRepository
) : QuerydslRepositorySupport(CouponPolicy::class.java), CouponPolicyJpaRepository by couponPolicyJpaRepository {

    @PersistenceContext
    override fun setEntityManager(entityManager: EntityManager) {
        super.setEntityManager(entityManager)
    }

    fun findCouponPolicyDto(title: String): CouponPolicyDto {
        return from(couponPolicy)
            .where(couponPolicy.title.eq(title))
            .select(
                QCouponPolicyDto(
                    couponPolicy.id,
                    couponPolicy.title,
                    couponPolicy.quantity,
                    couponPolicy.issuedQuantity,
                    couponPolicy.dateIssueStart,
                    couponPolicy.dateIssueEnd,
                    couponPolicy.dateExpire
                )
            ).fetchOne()
    }

    fun getProxy(id: Long): CouponPolicy {
        return couponPolicyJpaRepository.getReferenceById(id)
    }
}

interface CouponPolicyJpaRepository : JpaRepository<CouponPolicy, Long>