package com.example.couponcore.repository

import com.example.couponcore.domain.CouponPolicy
import com.example.couponcore.domain.UserCouponPolicyMapping
import jakarta.persistence.EntityManager
import jakarta.persistence.PersistenceContext
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport
import org.springframework.stereotype.Repository

@Repository
class UserCouponPolicyMappingRepository(
    private val userCouponPolicyMappingJpaRepository: UserCouponPolicyMappingJpaRepository
) : QuerydslRepositorySupport(CouponPolicy::class.java),
    UserCouponPolicyMappingJpaRepository by userCouponPolicyMappingJpaRepository {

    @PersistenceContext
    override fun setEntityManager(entityManager: EntityManager) {
        super.setEntityManager(entityManager)
    }
}

interface UserCouponPolicyMappingJpaRepository : JpaRepository<UserCouponPolicyMapping, Long>