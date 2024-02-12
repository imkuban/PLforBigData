/*
№3 Создать приложение, выводящее n строк с переходом и без перехода на новую строку. .
*/
import java.util.Scanner
fun main() {
    val scanner = Scanner(System.`in`)

    // Ввод количества строк n
    println("Введите количество строк n")
    val n = scanner.nextInt()
    println("С переносом: ")

    for (i in 0 until n) {

        println("Строка $i")
    }
    println("Без переноса:")
    for (i in 0 until n) {
        print("Строка $i ")
    }


}