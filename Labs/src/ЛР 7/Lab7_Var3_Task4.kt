/*
9.	Напечатать слова русского текста в алфавитном порядке по первой букве. Слова, начинающиеся с новой буквы, печатать с красной строки
 */

fun main() {
    val text = "Напечатать слова русского текста в алфавитном порядке по первой букве. Слова, начинающиеся с новой буквы, печатать с красной строки"

    // Разделение текста на слова
    val words = text.split("\\s+".toRegex())

    // Сортировка слов в алфавитном порядке
    val sortedWords = words.sorted()

    // Печать слов с красной строки при изменении первой буквы
    var prevFirstLetter = ' '
    sortedWords.forEach { word ->
        val currentFirstLetter = word.first()
        if (currentFirstLetter != prevFirstLetter) {
            println()
            prevFirstLetter = currentFirstLetter
        }
        print("$word ")
    }
}
