// №2 Ввести с консоли n целых чисел и поместить их в массив. На консоль вывести: Наибольшее и наименьшее число

import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)

    // Ввод количества чисел
    println("Введите количество целых чисел:")
    val n = scanner.nextInt()

    // Создание массива для хранения чисел
    val numbers = IntArray(n)

    // Ввод чисел и помещение их в массив
    println("Введите целые числа:")
    for (i in 0 until n) {
        numbers[i] = scanner.nextInt()
    }

    // Нахождение наибольшего и наименьшего чисел
    val maxNumber = numbers.maxOrNull()
    val minNumber = numbers.minOrNull()

    // Вывод наибольшего и наименьшего чисел
    println("Наибольшее число: $maxNumber")
    println("Наименьшее число: $minNumber")
}