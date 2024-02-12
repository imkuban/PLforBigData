/*
В приведенных ниже заданиях необходимо вывести внизу фамилию разработчика, дату и время получения задания, а также дату и время сдачи задания.
Для получения последней даты и времени следует использовать класс Date.

1. Ввести n строк с консоли, найти самую короткую и самую длинную строки. Вывести найденные строки и их длину.


 */
import java.util.Scanner
fun main() {
    val scanner = Scanner(System.`in`)
    // Ввод количества строк n
    println("Введите количество строк n")
    val n = scanner.nextInt()
    if (n <= 0) {
        println("Количество строк должно быть > 0.")
        return
    }
    // Считывание строк
    val strings = mutableListOf<String>()
    scanner.nextLine() // Считываем перевод строки после ввода числа n

    for (i in 1..n) {
        println("Введите строку $i:")
        val line = scanner.nextLine()
        strings.add(line)
    }
    // Находим самую короткую и самую длинную строку
    var shortest = strings.first()
    var longest = strings.first()

    for (str in strings) {
        if (str.length < shortest.length) {
            shortest = str
        }
        if (str.length > longest.length) {
            longest = str
        }
    }
    // Вывод результатов
    println("Самая короткая строка: $shortest (длина: ${shortest.length})")
    println("Самая длинная строка: $longest (длина: ${longest.length})")
    println()

    // Закрываем Scanner
    scanner.close()

    OutputInfo.printOutputInfo()
}