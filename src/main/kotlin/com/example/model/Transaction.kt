package com.example.model

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
data class Transaction(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    var customerId: Long,
    val tenantId: Long,
    val amount: Double,
    val transactionType: String
) {
}

// TODO: look into Audit Log data class

