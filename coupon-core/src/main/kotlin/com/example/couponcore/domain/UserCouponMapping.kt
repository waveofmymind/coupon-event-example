package com.example.couponcore.domain

import jakarta.persistence.*
import java.time.OffsetDateTime

@Entity
@Table(name = "user_coupon_mappings", schema = "coupon")
class UserCouponMapping(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @ManyToOne(fetch = FetchType.LAZY)
    val coupon: Coupon,

    @Column(nullable = false)
    val userId: String,

    @Column(nullable = false)
    val dateIssued: OffsetDateTime,

    @Column(nullable = false)
    val dateExpire: OffsetDateTime,

    @Column
    val dateUsed: OffsetDateTime? = null,
)
