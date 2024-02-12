// №2 Ввести с консоли n целых чисел и поместить их в массив. На консоль вывести: Числа, которые делятся на 3 или на 9

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
    println("Числа, которые делятся на 3 или на 9:")
    for (number in numbers ) {
        if (number % 3 == 0 || number % 9 == 0){
            print(" $number ")
        }
    }
}