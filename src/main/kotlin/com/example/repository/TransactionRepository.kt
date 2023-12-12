package com.example.repository

import com.example.model.Transaction
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.transaction.annotation.Transactional

interface TransactionRepository : JpaRepository<Transaction, Long> {
    fun saveTransaction(transaction: Transaction): Transaction
    fun getRecentListOfTransactionsByCustomerIdAndTenancyId(customerId: String, tenancyId: String, listLength: Int): List<Transaction>

    // TODO: Look into custom AccountTransaction query which:
    //  1. checks for and finds requested transaction,
    //  2. duplicates transaction with new ID
    //  3. modifies transaction for void
    @Query("")
    @Modifying
    @Transactional
    fun voidTransaction(customerId: String, tenancyId: String, transactionId: String, voidType: String)
}