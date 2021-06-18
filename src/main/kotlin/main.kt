import kotlin.math.roundToInt

fun main() {
    var cardType = "Maestro"
    var sumOfTransactions = 80000.0 //в руб
    var currentTransaction = 1009.0 //в руб

    if(cardType=="Vk Pay" && currentTransaction<35) {
        println("Сумма должна быть больше 35 руб")
    }else if (cardType=="Vk Pay" && (currentTransaction>15000 || sumOfTransactions>40000)) {
        print("Вы превысили лимит по переводам")
    }else if(currentTransaction>150000 || sumOfTransactions>600000){
        print("Вы превысили лимит по переводам")
    }else{
        var result = Math.round(transactions(cardType, sumOfTransactions, currentTransaction)*100.0)
        println("Комиссия: $result коп.") //в коп
    }
}

fun transactions(cardType: String = "Vk Pay", sumOfTransactions: Double = 0.0, currentTransaction: Double): Double {
    var commission = 0.0
    when (cardType) {
        "Mastercard", "Maestro" -> commission = if (sumOfTransactions > 300 && sumOfTransactions < 75000) 0.0 else (currentTransaction * 0.006 + 20)
        "Visa", "Мир" -> commission = currentTransaction * 0.0075
        "Vk Pay" -> commission = 0.0
    }
    return commission
}

