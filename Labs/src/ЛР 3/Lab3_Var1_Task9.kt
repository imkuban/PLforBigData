package `ЛР 3`

/*
9.Определить класс Квадратное уравнение. Класс должен содержать несколько конструкторов.
Реализовать методы для поиска корней, экстремумов, а также интервалов убывания/возрастания.
Создать массив объектов и определить наибольшие и наименьшие по значению корни
 */

import kotlin.math.sqrt

class QuadraticEquation(private val a: Double, private val b: Double, private val c: Double) {

    // Метод для вычисления дискриминанта
    private fun discriminant(): Double {
        return b * b - 4 * a * c
    }

    // Метод для нахождения корней уравнения
    fun findRoots(): Pair<Double?, Double?> {
        val disc = discriminant()
        if (disc < 0) {
            return Pair(null, null)
        } else {
            val root1 = (-b + sqrt(disc)) / (2 * a)
            val root2 = (-b - sqrt(disc)) / (2 * a)
            return Pair(root1, root2)
        }
    }

    // Метод для нахождения экстремумов
    fun findExtremes(): Double {
        return -b / (2 * a)
    }

    // Метод для определения интервалов убывания/возрастания
    fun decreasingIncreasingIntervals(): String {
        val extreme = findExtremes()
        return if (a > 0) {
            "Убывает на (-∞, $extreme] и возрастает на [$extreme, +∞)"
        } else {
            "Убывает на [$extreme, +∞) и возрастает на (-∞, $extreme]"
        }
    }
}

fun main() {
    val equations = arrayOf(
        QuadraticEquation(1.0, -3.0, 2.0),
        QuadraticEquation(2.0, 4.0, -6.0),
        QuadraticEquation(1.0, -2.0, 1.0)
    )

    var maxRoot: Double? = null
    var minRoot: Double? = null

    for (equation in equations) {
        val (root1, root2) = equation.findRoots()
        println("Корни уравнения: $root1, $root2")

        if (root1 != null && root2 != null) {
            if (maxRoot == null || root1 > maxRoot) {
                maxRoot = root1
            }
            if (maxRoot == null || root2 > maxRoot) {
                maxRoot = root2
            }

            if (minRoot == null || root1 < minRoot) {
                minRoot = root1
            }
            if (minRoot == null || root2 < minRoot) {
                minRoot = root2
            }
        }
    }

    println("Наибольший корень: $maxRoot")
    println("Наименьший корень: $minRoot")
}
