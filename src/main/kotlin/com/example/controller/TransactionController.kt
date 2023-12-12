package com.example.controller

import com.example.constant.TransactionType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import com.example.model.Transaction
import com.example.service.TransactionService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/transaction")
class TransactionController(private val transactionService: TransactionService) {

    @PostMapping("/deposit")
    fun depositMoney(@RequestBody request: Transaction): ResponseEntity<String> {
        val transaction = Transaction(
            customerId = request.customerId,
            tenantId = request.tenantId,
            amount = request.amount,
            transactionType = TransactionType.DEPOSIT
        )
        transactionService.saveTransaction(transaction)
        val responseMessage = "Deposit successful for transaction ID: ${transaction.id}"
        return ResponseEntity.status(HttpStatus.OK).body(responseMessage)
    }

    @PostMapping("/void-deposit")
    fun voidDeposit(@PathVariable customerId: String,
                     @PathVariable tenancyId: String,
                     @PathVariable transactionId: String
    ): ResponseEntity<String> {
        transactionService.voidTransactionByCustomerAndTenancy(customerId, tenancyId, transactionId, TransactionType.VOID_DEPOSIT)
        val responseMessage = "Voided Deposit successful for transaction ID: $transactionId"
        return ResponseEntity.status(HttpStatus.OK).body(responseMessage)
    }

    @PostMapping("/withdraw")
    fun withdrawMoney(@RequestBody request: Transaction): ResponseEntity<String> {
        val transaction = Transaction(
            customerId = request.customerId,
            tenantId = request.tenantId,
            amount = request.amount,
            transactionType = TransactionType.WITHDRAWAL
        )
        transactionService.saveTransaction(transaction)
        val responseMessage = "Withdrawal successful for transaction ID: ${transaction.id}"
        return ResponseEntity.status(HttpStatus.OK).body(responseMessage)
    }

    @PostMapping("/void-withdraw")
    fun voidWithdrawal(@PathVariable customerId: String,
                       @PathVariable tenancyId: String,
                       @PathVariable transactionId: String
                       ): ResponseEntity<String> {
        transactionService.voidTransactionByCustomerAndTenancy(customerId, tenancyId, transactionId, TransactionType.VOID_WITHDRAWAL)
        val responseMessage = "Voided Withdrawal successful for transaction ID: $transactionId"
        return ResponseEntity.status(HttpStatus.OK).body(responseMessage)
    }

    @GetMapping("/customer/{customerId}/tenancy/{tenancyId}/list-length/{listLength}")
    fun getTransactions(
        @PathVariable customerId: String,
        @PathVariable tenancyId: String,
        @PathVariable listLength: Int,
    ): List<Transaction> {
        return transactionService.getTransactionsByCustomerAndTenancy(customerId, tenancyId, listLength)
    }
}