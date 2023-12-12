import com.example.constant.TransactionType
import com.example.controller.TransactionController
import com.example.model.Transaction
import com.example.service.TransactionService
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

@ExtendWith(MockitoExtension::class)
class TransactionControllerTest {

    @Mock
    private lateinit var transactionService: TransactionService

    @InjectMocks
    private lateinit var transactionController: TransactionController

    //TODO: create thorough tests.
    // 1. Test negative amount
    // 2. Test zero amount
    // 3. Test null amount
    // 4. Test very large numbers
    // 5. Test very small numbers
    // 6. Verify void is accurate
    // 7. Verify duplicate entry isn't made with void

    @Test
    fun `test depositDeposit`() {
        val request = Transaction(
            id = 10,
            customerId = "c1",
            tenantId = "t1",
            amount = 100.0,
            transactionType = TransactionType.DEPOSIT
        )

        val response: ResponseEntity<String> = transactionController.depositMoney(request)

        assertEquals(HttpStatus.OK, response.statusCode)
        assertNotNull(response.body)
    }

    @Test
    fun `test voidDeposit`() {
        val customerId = "1c"
        val tenancyId = "1t"
        val transactionId = "123"

        val response: ResponseEntity<String> = transactionController.voidDeposit(customerId, tenancyId, transactionId)

        assertEquals(HttpStatus.OK, response.statusCode)
        assertNotNull(response.body)
    }

    //TODO: withdraw money test
    //TODO: withdraw void test

    @Test
    fun `test getTransactions`() {
        val customerId = 1L
        val tenancyId = 2L
        val listLength = 10

        val transactions: List<Transaction> = transactionController.getTransactions(customerId, tenancyId, listLength)

        assertTrue(transactions.isNotEmpty())
    }
}
