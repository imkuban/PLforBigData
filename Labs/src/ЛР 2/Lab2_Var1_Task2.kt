/*
В приведенных ниже заданиях необходимо вывести внизу фамилию разработчика, дату и время получения задания, а также дату и время сдачи задания.
Для получения последней даты и времени следует использовать класс Date.
2. Ввести n строк с консоли. Упорядочить и вывести строки в порядке возрастания (убывания) значений их длины.
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
    // Упорядочиваем строки по возрастанию и убыванию длины
    val sortedByLengthAscending = strings.sortedBy { it.length }
    val sortedByLengthDescending = strings.sortedByDescending { it.length }

    println("Убывающие строки")
    println(sortedByLengthDescending)
    println("возрастающие строки")
    println(sortedByLengthAscending)


    // Закрываем Scanner
    scanner.close()

    OutputInfo.printOutputInfo()
}