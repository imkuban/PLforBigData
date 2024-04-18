/*
Использовать ТОЛЬКО методы Stream API. Циклов и условий быть не должно.
1.	Задана коллекция строк. Отсортировать значения по алфавиту и убрать повторы.
создает поток из коллекции строк, затем применяет метод distinct(), чтобы исключить повторяющиеся элементы,
и метод sorted(), чтобы отсортировать элементы по алфавиту, а затем преобразует поток обратно в список с помощью метода toList().
 */
fun main() {
    val collection = listOf("banana", "apple", "orange", "banana", "kiwi", "apple")

    val sortedDistinctList = collection.stream()
        .distinct()
        .sorted()
        .toList()

    println("Sorted list without duplicates: $sortedDistinctList")
}
