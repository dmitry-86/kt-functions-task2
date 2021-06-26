import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun transactions_for_Mastercard_withCommission() {

        val cardType = "Mastercard"
        val sumOfTransactions = 100000.0
        val currentTransaction = 1000.0

        val massage = transactions(
            cardType = cardType,
            sumOfTransactions = sumOfTransactions,
            currentTransaction = currentTransaction)

        assertEquals("Комиссия: 2600 коп.", massage)
    }

    @Test
    fun transactions_for_Mastercard_commissionZero() {

        val cardType = "Mastercard"
        val sumOfTransactions = 5000.0
        val currentTransaction = 1000.0

        val massage = transactions(
            cardType = cardType,
            sumOfTransactions = sumOfTransactions,
            currentTransaction = currentTransaction)

        assertEquals("Комиссия: 300 коп.", massage)
    }

    @Test
    fun transactions_for_Mastercard_sumOfTransactionsTooBig() {

        val cardType = "Mastercard"
        val sumOfTransactions = 800000.0
        val currentTransaction = 10000.0

        val massage = transactions(
            cardType = cardType,
            sumOfTransactions = sumOfTransactions,
            currentTransaction = currentTransaction)

        assertEquals("Вы превысили лимит по переводам", massage)
    }

    @Test
    fun transactions_for_Mastercard_withCommission_2() {

        val cardType = "Mastercard"
        val sumOfTransactions = 100.0
        val currentTransaction = 100000.0

        val massage = transactions(
            cardType = cardType,
            sumOfTransactions = sumOfTransactions,
            currentTransaction = currentTransaction)

        assertEquals("Комиссия: 62000 коп.", massage)
    }

    @Test
    fun transactions_for_Maestro_withCommission() {

        val cardType = "Maestro"
        val sumOfTransactions = 100000.0
        val currentTransaction = 100000.0

        val massage = transactions(
            cardType = cardType,
            sumOfTransactions = sumOfTransactions,
            currentTransaction = currentTransaction
        )

        assertEquals("Комиссия: 62000 коп.", massage)
    }

    @Test
    fun transactions_for_Maestro_commissionZero() {

        val cardType = "Maestro"
        val sumOfTransactions = 7000.0
        val currentTransaction = 5000.0

        val massage = transactions(
            cardType = cardType,
            sumOfTransactions = sumOfTransactions,
            currentTransaction = currentTransaction)

        assertEquals("Комиссия: 0 коп.", massage)
    }

    @Test
    fun transactions_for_Maestro_currentTransactionTooBig() {

        val cardType = "Maestro"
        val sumOfTransactions = 100000.0
        val currentTransaction = 160000.0

        val massage = transactions(
            cardType = cardType,
            sumOfTransactions = sumOfTransactions,
            currentTransaction = currentTransaction)

        assertEquals("Вы превысили лимит по переводам", massage)
    }

    @Test
    fun transactions_for_Visa_withCommission() {

        val cardType = "Visa"
        val sumOfTransactions = 100000.0
        val currentTransaction = 1000.0

        val massage = transactions(
            cardType = cardType,
            sumOfTransactions = sumOfTransactions,
            currentTransaction = currentTransaction
        )

        assertEquals("Комиссия: 750 коп.", massage)
    }

    @Test
    fun transactions_for_Visa_sumOfTransactionsTooBig() {

        val cardType = "Visa"
        val sumOfTransactions = 800000.0
        val currentTransaction = 1000.0

        val massage = transactions(
            cardType = cardType,
            sumOfTransactions = sumOfTransactions,
            currentTransaction = currentTransaction
        )

        assertEquals("Вы превысили лимит по переводам", massage)
    }


    @Test
    fun transactions_for_Mir_withCommission() {

        val cardType = "Мир"
        val sumOfTransactions = 100000.0
        val currentTransaction = 1000.0

        val massage = transactions(
            cardType = cardType,
            sumOfTransactions = sumOfTransactions,
            currentTransaction = currentTransaction
        )

        assertEquals("Комиссия: 750 коп.", massage)
    }


    @Test
    fun transactions_for_mir_currentTransactionTooBig() {

        val cardType = "Мир"
        val sumOfTransactions = 80000.0
        val currentTransaction = 200000.0

        val massage = transactions(
            cardType = cardType,
            sumOfTransactions = sumOfTransactions,
            currentTransaction = currentTransaction)

        assertEquals("Вы превысили лимит по переводам", massage)

    }

    @Test
    fun transactions_for_VkPay_commissionZero() {

        val cardType = "Vk Pay"
        val sumOfTransactions = 10000.0
        val currentTransaction = 1000.0

        val massage = transactions(
            cardType = cardType,
            sumOfTransactions = sumOfTransactions,
            currentTransaction = currentTransaction)

        assertEquals("Комиссия: 0 коп.", massage)
    }

    @Test
    fun transactions_for_VkPay_sumOfTransactionsTooBig() {

        val cardType = "Vk Pay"
        val sumOfTransactions = 50000.0
        val currentTransaction = 2000.0

        val massage = transactions(
            cardType = cardType,
            sumOfTransactions = sumOfTransactions,
            currentTransaction = currentTransaction)

        assertEquals("Вы превысили лимит по переводам", massage)
    }

    @Test
    fun transactions_for_VkPay_CurrentTransaction_tooBig() {

        val cardType = "Vk Pay"
        val sumOfTransactions = 5000.0
        val currentTransaction = 2000000.0

        val massage = transactions(
            cardType = cardType,
            sumOfTransactions = sumOfTransactions,
            currentTransaction = currentTransaction)

        assertEquals("Вы превысили лимит по переводам", massage)
    }

    @Test
    fun transactions_for_VkPay_transactionTooSmall() {

        val cardType = "Vk Pay"
        val sumOfTransactions = 10000.0
        val currentTransaction = 30.0

        val massage = transactions(
            cardType = cardType,
            sumOfTransactions = sumOfTransactions,
            currentTransaction = currentTransaction)

        assertEquals("Сумма должна быть больше 35 руб", massage)
    }

    @Test
    fun transactions_for_cardIsNotFound() {

        val cardType = "Jandex Pay"
        val sumOfTransactions = 80000.0
        val currentTransaction = 300.0

        val massage = transactions(
            cardType = cardType,
            sumOfTransactions = sumOfTransactions,
            currentTransaction = currentTransaction)

        assertEquals("Такая карта не принимается", massage)
    }

    @Test
    fun transactions_for_VKPay_default() {


        val currentTransaction = 1000.0

        val massage = transactions(currentTransaction = currentTransaction)

        assertEquals("Комиссия: 0 коп.", massage)
    }

    @Test
    fun transactions_for_VKPay_defaultVisa() {

        val cardType = "Visa"
        val currentTransaction = 100.0

        val massage = transactions(
            cardType = cardType,
            currentTransaction = currentTransaction)

        assertEquals("Комиссия: 75 коп.", massage)
    }

}