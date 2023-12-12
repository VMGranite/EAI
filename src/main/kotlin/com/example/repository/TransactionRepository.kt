package com.example.repository

import com.example.model.Transaction
import org.springframework.data.jpa.repository.JpaRepository

interface TransactionRepository : JpaRepository<Transaction, Long> {
    fun saveTransaction(transaction: Transaction): Transaction
    fun getRecentListOfTransactionsByCustomerIdAndTenancyId(customerId: Long, tenancyId: Long, listLength: Int): List<Transaction>
}