/*
№5 Создать программу ввода целых чисел как аргументов командной строки, подсчета их суммы (произведения) и вывода результата на консоль.
*/
import java.util.Scanner
fun main() {
    val scanner = Scanner(System.`in`)

    // Ввод первого числа
    println("Введите первое число")
    val a = scanner.nextInt()

    println("Введите второе число")
    val b = scanner.nextInt()

    val summa=a+b
    val product = a*b

    println("Сумма двух чисел $summa")
    println("Произведение двух чисел $product")

}