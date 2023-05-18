fun main(args: Array<String>) {
    val purchase: Int = 30000
    val regularClient: Boolean = true
    val minimumDiscount: Int = 100
    val discountPercentFull: Double = 0.01
    val discountPercent: Double = 0.05
    val noDiscountValue: Int = 1_000
    val firstDiscountLevel: Int = 1_001
    val noDiscountResult: Int = 0

    val discount = if (purchase <= noDiscountValue) {
        noDiscountResult
    } else if (purchase > noDiscountValue && purchase < firstDiscountLevel) {
        if (regularClient) {
            (purchase * discountPercentFull) + minimumDiscount // скидка для постоянного клиента
        } else {
            minimumDiscount // Скидка для не постоянного клиента в 100р с суммы до 10_001р.
        }
    }
    else {
        if (regularClient) {
            (purchase * discountPercent) + ((purchase - (purchase * discountPercent)) * discountPercentFull)
/*
Скидка для постоянного клиента от 10_001р через две операции.
Сначала я вычисли значение обычной скидки((purchase * discountPercent))
Затем вычел это значение из суммы следующей скидки (((purchase - (purchase * discountPercent)) * discountPercentFull))
Возможно я неправильно понял условие.
*/
} else {
    (purchase * discountPercent) // Скидка не для постоянного клиента
}
}
println("Размер скидки $discount рублей")
}