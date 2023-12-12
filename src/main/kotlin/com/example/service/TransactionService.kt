package com.example.service

import com.example.model.Transaction
import com.example.repository.TransactionRepository
import org.springframework.stereotype.Service

@Service
class TransactionService(private val transactionRepository: TransactionRepository) {
    fun saveTransaction(transaction: Transaction) {
        transactionRepository.saveTransaction(transaction)
    }

    fun getTransactionsByCustomerAndTenancy(customerId: Long, tenancyId: Long, listLength: Int): List<Transaction> {
        return transactionRepository.getRecentListOfTransactionsByCustomerIdAndTenancyId(customerId, tenancyId, listLength)
    }

    fun voidTransactionByCustomerAndTenancy(customerId: Long, tenancyId: Long, transactionId: Long, voidType: String) {
        transactionRepository.voidTransaction(customerId, tenancyId, transactionId, voidType)
    }
}