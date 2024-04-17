/*
10.	На прямой гоночной трассе стоит N автомобилей, для каждого из которых известны начальное положение и скорость. Определить, сколько произойдет обгонов.
 */

data class Automobiles(val position: Int, val speed: Int)

fun countOvertakes(automobiles: List<Automobiles>): Int {
    var overtakes = 0
    for (i in 0 until automobiles.size) {
        for (j in i + 1 until automobiles.size) {
            if (automobiles[i].position < automobiles[j].position && automobiles[i].speed > automobiles[j].speed) {
                overtakes++
            }
        }
    }
    return overtakes
}

fun main() {
    val automobiles = listOf(
        Automobiles(10, 5),
        Automobiles(15, 7),
        Automobiles(20, 6)
    )

    val overtakes = countOvertakes(automobiles)
    println("Количество обгонов: $overtakes")
}
