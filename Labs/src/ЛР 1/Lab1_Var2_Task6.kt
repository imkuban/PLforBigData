// №6 Ввести с консоли n целых чисел и поместить их в массив. На консоль вывести: Все трехзначные числа, в десятичной записи которых нет одинаковых цифр

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
        if (isDistinctDigits(number) && number in 100..999){
            print(" $number ")
        }
    }
}

// Функция для проверки, содержит ли число одинаковые цифры
fun isDistinctDigits(number: Int): Boolean {
    val digit1 = number / 100
    val digit2 = number / 10 % 10
    val digit3 = number % 10
    return digit1 != digit2 && digit1 != digit3 && digit2 != digit3
}