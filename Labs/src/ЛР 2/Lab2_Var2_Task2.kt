/*
Ввести с консоли n – размерность матрицы a[n][n]. Задать значения элементов матрицы в интервале значений от -n до n с помощью датчика случайных чисел.
5. Транспонировать квадратную матрицу.
 */

import java.util.*
fun main() {
    val scanner = Scanner(System.`in`)

    // Ввод размерности матрицы
    println("Введите размерность матрицы n:")
    val n = scanner.nextInt()

    // Создание матрицы
    val matrix = Array(n) { IntArray(n) }

    // Заполнение матрицы случайными числами в интервале от -n до n
    val random = Random()
    for (i in 0 until n) {
        for (j in 0 until n) {
            matrix[i][j] = random.nextInt(2 * n + 1) - n
        }
    }
    // Вывод исходной матрицы
    println("Исходная матрица:")
    printMatrix(matrix)

    // Транспонируем матрицу (поменяем строки и столбцы местами)
    val transposedMatrix = Array(n) { IntArray(n) }

    for (i in 0 until n) {
        for (j in 0 until n) {
            transposedMatrix[j][i] = matrix[i][j]
        }
    }

    // Вывод упорядоченной матрицы
    println("Матрица после упорядочивания:")
    printMatrix(transposedMatrix)

    // Закрываем Scanner
    scanner.close()
}

