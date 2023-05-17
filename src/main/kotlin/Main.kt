fun main(args: Array<String>) {
    val purchase: Int = 30000
    val regularClient: Boolean = true
    val minimumDiscount: Int = 100
    val discountPercentFull: Double = 0.01
    val discountPercent: Double = 0.05

    val discount = if (purchase <= 1_000) {
        0
    } else if (purchase > 1_000 && purchase < 10_001) {
        if (regularClient) {
            (purchase * discountPercentFull) + minimumDiscount // скидка для постоянного клиента
        } else {
            minimumDiscount // Скидка для не постоянного клиента в 100р с суммы до 10_001р.
        }
    }
    else {
        if (regularClient) {
            (purchase * discountPercent) + ((purchase - (purchase * discountPercent)) * discountPercentFull)
        // Скидка для постоянного клиента от 10_001р через две операции. Уверен можно проще.
        } else {
            (purchase * discountPercent)
        }
    }
    println("Размер скидки $discount рублей")
}