// №4 Ввести с консоли n целых чисел и поместить их в массив. На консоль вывести: Числа, которые делятся на 5  на 7

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
    // Вывод чисел, которые делятся на 3 или на 9
    println("Числа, которые делятся на 5 и на 7:")
    for (number in numbers ) {
        if (number % 5 == 0 && number % 7 == 0){
            print(" $number ")
        }
    }
}