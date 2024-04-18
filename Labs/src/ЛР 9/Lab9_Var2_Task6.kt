/*
Использовать ТОЛЬКО методы Stream API. Циклов и условий быть не должно.
6.	Задана коллекция чисел. Получить сумму четных чисел.
создает поток из коллекции чисел, затем с помощью метода filter() оставляет только четные числа, используя лямбда-выражение
 */
fun main() {
    val numbers = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

    val sumOfEvenNumbers = numbers.stream()
        .filter { it % 2 == 0 }
        .mapToInt { it }
        .sum()

    println("Sum of even numbers: $sumOfEvenNumbers")
}

