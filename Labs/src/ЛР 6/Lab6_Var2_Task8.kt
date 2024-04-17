/*
9.	Дана матрица из целых чисел. Найти в ней прямоугольную подматрицу, состоящую из максимального количества одинаковых элементов. Использовать класс Stack.
 */
import java.util.*

class StackRectangularMatrix(private val matrix: Array<IntArray>) {
    fun findMaxRectangle(): Pair<Pair<Int, Int>, Pair<Int, Int>>? {
        val rows = matrix.size
        if (rows == 0) return null
        val cols = matrix[0].size

        var maxArea = 0
        var maxRect: Pair<Pair<Int, Int>, Pair<Int, Int>>? = null

        val heights = IntArray(cols)
        for (row in 0 until rows) {
            for (col in 0 until cols) {
                if (matrix[row][col] == 0) {
                    heights[col] = 0
                } else {
                    heights[col]++
                }
            }

            val stack = Stack<Int>()
            var col = 0
            while (col <= cols) {
                val h = if (col == cols) 0 else heights[col]
                if (stack.isEmpty() || h >= heights[stack.peek()]) {
                    stack.push(col++)
                } else {
                    val top = stack.pop()
                    val area = heights[top] * (if (stack.isEmpty()) col else col - stack.peek() - 1)
                    if (area > maxArea) {
                        maxArea = area
                        maxRect = Pair(Pair(row - heights[top] + 1, top), Pair(row, col - 1))
                    }
                }
            }
        }

        return maxRect
    }
}

fun main() {
    val matrix = arrayOf(
        intArrayOf(1, 0, 1, 1),
        intArrayOf(0, 1, 1, 0),
        intArrayOf(1, 1, 1, 1),
        intArrayOf(1, 1, 1, 0)
    )

    val stackRectangularMatrix = StackRectangularMatrix(matrix)
    val maxRect = stackRectangularMatrix.findMaxRectangle()

    if (maxRect != null) {
        println("Максимальная прямоугольная подматрица:")
        for (i in maxRect.first.first..maxRect.second.first) {
            for (j in maxRect.first.second..maxRect.second.second) {
                print("${matrix[i][j]} ")
            }
            println()
        }
    } else {
        println("Матрица пуста.")
    }
}
