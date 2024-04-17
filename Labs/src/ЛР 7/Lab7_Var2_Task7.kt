/*
В тексте найти и напечатать все слова максимальной и все слова минимальной длины.
 */
fun main() {
    val text = "Этот код ищет слова максимальнойqqqq и минимальной длины в заданном тексте и печатает их."
    val words = text.split("\\s+".toRegex()) // Разделение текста на слова

    // Находим длину самого длинного и самого короткого слова
    val maxLength = words.maxByOrNull { it.length }?.length ?: 0
    val minLength = words.minByOrNull { it.length }?.length ?: 0

    // Находим все слова максимальной и минимальной длины
    val longestWords = words.filter { it.length == maxLength }
    val shortestWords = words.filter { it.length == minLength }

    // Печатаем результаты
    println("Слова максимальной длины ($maxLength символов):")
    println(longestWords.joinToString(", "))
    println()
    println("Слова минимальной длины ($minLength символов):")
    println(shortestWords.joinToString(", "))
}
