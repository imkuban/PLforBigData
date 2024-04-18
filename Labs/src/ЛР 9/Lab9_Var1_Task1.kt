/*
Использовать ТОЛЬКО методы Stream API. Циклов и условий быть не должно.
1.	Задана коллекция строк. Вернуть последний элемент и третий элемент коллекции
 */
fun main() {
    val array = arrayOf("one", "two", "three", "four", "five")

    val lastAndThird = array.asList().stream()
        .skip((array.size - 1).toLong())
        .findFirst()
        .orElse(null) to array.asList().stream()
        .skip(2)
        .findFirst()
        .orElse(null)

    println("Last element: ${lastAndThird.first}")
    println("Third element: ${lastAndThird.second}")
}
