/*
10.	Рассортировать слова русского текста по возрастанию доли гласных букв (отношение количества гласных к общему количеству букв в слове)
 */

fun main() {
    val text = "Рассортировать слова русского текста по возрастанию доли гласных букв / отношение количества гласных к общему количеству букв в слове"

    // Разделение текста на слова
    val words = text.split("\\s+".toRegex())

    // Функция для подсчета количества гласных букв в слове
    fun countVowels(word: String): Int {
        val vowels = setOf('а', 'е', 'ё', 'и', 'о', 'у', 'ы', 'э', 'ю', 'я')
        return word.count { it.toLowerCase() in vowels }
    }

    // Сортировка слов по доле гласных букв
    val sortedWords = words.sortedBy { countVowels(it).toDouble() / it.length }

    // Печать отсортированных слов
    sortedWords.forEach { println(it) }
}
