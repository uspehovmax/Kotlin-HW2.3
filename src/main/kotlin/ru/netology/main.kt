/**
 * Users total purchases define discount of next purchase
 */

var totalDiscount = 0
var discount = 0
const val noDiscount = 0
const val standardDiscount = 100_00
const val advancedDiscount = 0.05
const val maxDiscount = 0.01

fun main() {

    // данные по 3 пользователям
    val isMusicLover1 = false
    val isMusicLover2 = false
    val isMusicLover3 = true

    val purchases1 = 15005_00         // предыдущие покупки юзера 1
    val purchases2 = 3500_00          // предыдущие покупки юзера 2
    val purchases3 = 12_000_00        // предыдущие покупки юзера 3

    val currentPurchases1 = 500_00    // текущая покупка юзера 1
    val currentPurchases2 = 950_00    // текущая покупка юзера 2
    val currentPurchases3 = 2450_00   // текущая покупка юзера 3

    checkUserDiscount(purchases1, currentPurchases1, isMusicLover1)
    checkUserDiscount(purchases2, currentPurchases2, isMusicLover2)
    checkUserDiscount(purchases3, currentPurchases3, isMusicLover3)
}

fun checkUserDiscount(purchases: Int, currentPurchases: Int, isMusicLover: Boolean) {

    if ((purchases) <= 1000_00) {
        totalDiscount = noDiscount * currentPurchases
        discount = 0
    } else if ((purchases) > 1000_00 && (purchases) <= 10000_00) {
        totalDiscount = standardDiscount
        discount = 1
    } else {
        totalDiscount = (advancedDiscount * currentPurchases).toInt()
        discount = 5
    }

    println("-------------*------------------")
    println("Сумма предыдущей покупки: ${purchases / 100} руб -> скидка на текущую покупку: ${discount}% ")
    if (isMusicLover) {
        println(
            "Скидка МЕЛОМАНА ${(maxDiscount * 100).toInt()}% на текущую покупку: " +
                    "${(totalDiscount * maxDiscount).toInt() / 100} руб " +
                    "${(totalDiscount * maxDiscount).toInt() % 100} цент"
        )
        totalDiscount += (totalDiscount * maxDiscount).toInt()
    }
    println("Сумма покупки: ${currentPurchases / 100} руб -> скидка на текущую покупку: ${totalDiscount / 100} руб ${totalDiscount % 100} цент")
    println("К ОПЛАТЕ: ${(currentPurchases - totalDiscount) / 100} руб ${(currentPurchases - totalDiscount) % 100} цент")
}
