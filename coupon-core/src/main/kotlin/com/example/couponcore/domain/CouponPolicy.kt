package com.example.couponcore.domain

import jakarta.persistence.*
import java.time.OffsetDateTime

@Entity
@Table(name = "coupon_policies", schema = "coupon")
class CouponPolicy(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    val title: String,

    @Column(nullable = false)
    val quantity: Long,

    @Column(nullable = false)
    val issuedQuantity: Long,

    @Column(nullable = false)
    val dateIssueStart: OffsetDateTime,

    @Column(nullable = false)
    val dateIssueEnd: OffsetDateTime,

    @Column(nullable = false)
    val dateExpire: OffsetDateTime,

)
