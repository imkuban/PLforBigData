import java.util.Date

object OutputInfo {
    val developerSurname = "Иванов"
    val startDate = Date() // дата получения задания
    var endDate: Date? = Date() // дата сдачи задания

    fun printOutputInfo() {
        println("Фамилия разработчика: $developerSurname")
        println("Дата и время получения задания: $startDate")
        println("Дата и время сдачи задания: $endDate")
    }
}


// Функция для вывода матрицы на экран
fun printMatrix(matrix: Array<IntArray>) {
    for (row in matrix) {
        println(row.joinToString(" "))
    }
}