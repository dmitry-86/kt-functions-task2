import kotlin.math.roundToInt

fun main() {
    val cardType = "Mastercard"
    val sumOfTransactions = 100000.0 //в руб
    val currentTransaction = 1000.0 //в руб

print(transactions(cardType, sumOfTransactions, currentTransaction))

}

fun transactions(cardType: String = "Vk Pay",
                 sumOfTransactions: Double = 0.0,
                 currentTransaction: Double): Any =
    when (cardType) {
        "Mastercard", "Maestro" -> commissionMastercard(sumOfTransactions, currentTransaction)
        "Visa", "Мир" -> commissionVisa(currentTransaction, sumOfTransactions)
        "Vk Pay" -> commissionVkPay(currentTransaction, sumOfTransactions)
        else -> "Такая карта не принимается"
    }

fun commissionMastercard(sumOfTransactions: Double, currentTransaction: Double): Any =
    when{
        currentTransaction>150000 || sumOfTransactions>600000 -> "Вы превысили лимит по переводам"
        sumOfTransactions > 300 && sumOfTransactions < 75000 -> printCommission(0.0)
        else -> printCommission(currentTransaction * 0.006 + 20)
    }

fun commissionVisa(currentTransaction: Double, sumOfTransactions: Double): Any =
    when {
        currentTransaction>150000 || sumOfTransactions>600000 -> "Вы превысили лимит по переводам"
        else -> printCommission(currentTransaction * 0.0075)
    }

fun commissionVkPay(currentTransaction: Double, sumOfTransactions: Double): String =
    when {
        currentTransaction<35 -> "Сумма должна быть больше 35 руб"
        currentTransaction>15000 || sumOfTransactions>40000 -> "Вы превысили лимит по переводам"
        else -> printCommission(currentTransaction * 0.0)
    }

fun printCommission(commission: Double): String{
    val result = Math.round(commission*100.0)
    return "Комиссия: $result коп."
}