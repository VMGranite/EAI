package com.example.service

import com.example.model.Transaction
import com.example.repository.TransactionRepository
import org.springframework.stereotype.Service

@Service
class TransactionService(private val transactionRepository: TransactionRepository) {
    fun saveTransaction(transaction: Transaction) {
        transactionRepository.saveTransaction(transaction)
    }

    fun getTransactionsByCustomerAndTenancy(customerId: String, tenancyId: String, listLength: Int): List<Transaction> {
        return transactionRepository.getRecentListOfTransactionsByCustomerIdAndTenancyId(customerId, tenancyId, listLength)
    }

    fun voidTransactionByCustomerAndTenancy(customerId: String, tenancyId: String, transactionId: String, voidType: String) {
        transactionRepository.voidTransaction(customerId, tenancyId, transactionId, voidType)
    }
}