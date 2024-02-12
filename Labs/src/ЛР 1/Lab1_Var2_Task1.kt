/*
№1 Ввести с консоли n целых чисел и поместить их в массив. На консоль вывести: Четные и нечетные числа
*/
import java.util.Scanner //Этот оператор импортирует класс Scanner из пакета java.util, который мы используем для считывания ввода с консоли

fun main() {
    val scanner = Scanner(System.`in`) //Здесь создается объект scanner, который будет использоваться для считывания ввода с консоли.

    // Ввод количества чисел
    println("Введите количество целых чисел:")
    val n = scanner.nextInt() //Cчитывается введенное число с помощью метода nextInt() объекта scanner и сохраняется в переменной n.

    // Создание массива для хранения чисел
    val numbers = IntArray(n)

    // Ввод чисел и помещение их в массив
    println("Введите целые числа:")
    for (i in 0 until n) {
        numbers[i] = scanner.nextInt()
    }

    // Вывод четных и нечетных чисел
    println("Четные числа:")
    for (number in numbers) {
        if (number % 2 == 0) {
            println(number)
        }
    }

    println("Нечетные числа:")
    for (number in numbers) {
        if (number % 2 != 0) {
            println(number)
        }
    }
}