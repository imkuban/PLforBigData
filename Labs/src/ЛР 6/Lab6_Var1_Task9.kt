/*
9.	Задан файл с текстом на английском языке.
Выделить все различные слова. Слова, отличающиеся только регистром букв, считать одинаковыми.
Использовать класс HashSet.
 */

import java.io.File

fun main() {
    val inputFileName = "D:\\Рабочий стол\\Studying\\GitHub projects\\Labs\\src\\ЛР 6\\текст.txt" // Имя файла с текстом на английском языке
    val words = extractUniqueWords(inputFileName)
    println("Все различные слова в тексте:")
    words.forEach { println(it) }
}

fun extractUniqueWords(inputFileName: String): Set<String> {
    val wordsSet = HashSet<String>()

    File(inputFileName).forEachLine { line ->
        val words = line.split("\\W+".toRegex()) // Разбиваем строку на слова, игнорируя знаки препинания
        words.forEach { word ->
            if (word.isNotBlank()) { // Проверяем, что слово не пустое
                wordsSet.add(word.toLowerCase()) // Добавляем слово в нижнем регистре в HashSet
            }
        }
    }

    return wordsSet
}
