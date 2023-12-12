package com.example.service

import com.example.model.Transaction
import com.example.repository.TransactionRepository
import org.springframework.stereotype.Service

@Service
class TransactionService(private val transactionRepository: TransactionRepository) {
    fun saveTransaction(transaction: Transaction): Transaction {
        return transactionRepository.saveTransaction(transaction)
    }

    fun getTransactionsByCustomerAndTenancy(customerId: Long, tenancyId: Long, listLength: Int): List<Transaction> {
        return transactionRepository.getRecentListOfTransactionsByCustomerIdAndTenancyId(customerId, tenancyId, listLength)
    }
}