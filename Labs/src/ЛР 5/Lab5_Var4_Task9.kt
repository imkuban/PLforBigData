/*
При выполнении следующих заданий для вывода результатов создавать новую директорию и файл средствами класса File
9.	Прочитать строки из файла и поменять местами первое и последнее слова в каждой строке.
 */

import java.io.File

fun main() {
    val inputFileName = "D:/Рабочий стол/Studying/GitHub projects/Labs/src/ЛР 5/Стих.txt" // Имя входного файла
    val outputDirectoryName = "D:/Рабочий стол/Studying/GitHub projects/Labs/src/ЛР 5" // Название новой директории
    val outputFileName = "swapped_words.txt" // Название нового файла с замененными словами

    // Создаем новую директорию, если её нет
    val outputDirectory = File(outputDirectoryName)
    outputDirectory.mkdir()

    // Читаем строки из файла
    val lines = readLinesFromFile(inputFileName)

    // Заменяем первое и последнее слово в каждой строке
    val swappedLines = lines.map { swapFirstAndLastWords(it) }

    // Записываем замененные строки в новый файл
    val outputFile = File(outputDirectory, outputFileName)
    writeLinesToFile(outputFile, swappedLines)

    println("Замененные строки записаны в файл: ${outputFile.absolutePath}")
}

// Функция для чтения строк из файла
fun readLinesFromFile(fileName: String): List<String> {
    val file = File(fileName)
    return if (file.exists()) {
        file.readLines()
    } else {
        listOf()
    }
}

// Функция для записи строк в файл
fun writeLinesToFile(file: File, lines: List<String>) {
    file.bufferedWriter().use { writer ->
        lines.forEach { writer.write("$it\n") }
    }
}

// Функция для замены первого и последнего слова в строке
fun swapFirstAndLastWords(line: String): String {
    val words = line.split("\\s+".toRegex())
    return if (words.size >= 2) {
        val firstWord = words.first()
        val lastWord = words.last()
        val middleWords = words.subList(1, words.size - 1).joinToString(separator = " ")
        "$lastWord $middleWords $firstWord"
    } else {
        line // Если в строке меньше двух слов, возвращаем её без изменений
    }
}
