/*
Использовать ТОЛЬКО методы Stream API. Циклов и условий быть не должно.
5.	Задана коллекция строк. Вернуть список из коллекции без повторов.
Для решения этой задачи можно воспользоваться методом distinct(), который исключает повторяющиеся элементы из потока
 */
fun main() {
    val collection = listOf("apple", "banana", "apple", "orange", "banana", "kiwi")

    val distinctList = collection.stream()
        .distinct()
        .toList()

    println("List without duplicates: $distinctList")
}
