/*
В следующих заданиях требуется ввести последовательность строк из текстового потока и выполнить указанные действия. При этом могут рассматриваться два варианта:
 • каждая строка состоит из одного слова;
• каждая строка состоит из нескольких слов.
Имена входного и выходного файлов, а также абсолютный путь к ним могут быть введены как параметры командной строки или храниться в файле.

В каждом слове стихотворения Николая Заболоцкого заменить первую букву слова на прописную.
 */

import java.io.File

fun main() {
    val fileName = "D:/Рабочий стол/Studying/GitHub projects/Labs/src/ЛР 5/стихзаболоцкого.txt"// Имя файла со стихотворением
    val text2 = readTextFromFile2(fileName)

    // Проверяем, получилось ли прочитать текст из файла
    if (text2.isNotBlank()) {
        val modifiedText = modifyText(text2)
        println("Измененный текст:")
        println(modifiedText)

        // Записываем измененный текст обратно в файл
        val outputFileName = "modified_$fileName"
        writeTextToFile(outputFileName, modifiedText)
        println("\nИзмененный текст записан в файл: $outputFileName")
    } else {
        println("Файл $fileName пуст или не существует.")
    }
}

// Функция для чтения текста из файла
fun readTextFromFile2(fileName: String): String {
    val file = File(fileName)
    return if (file.exists()) {
        file.readText()
    } else {
        ""
    }
}

// Функция для записи текста в файл
fun writeTextToFile(fileName: String, text: String) {
    val file = File(fileName)
    file.writeText(text)
}

// Функция для замены первой буквы в каждом слове на прописную
fun modifyText(text: String): String {
    val words = text.split("\\s+".toRegex())
    val modifiedWords = words.map { word ->
        if (word.isNotEmpty()) {
            val firstChar = word.first().toUpperCase()
            val restOfWord = word.substring(1)
            "$firstChar$restOfWord"
        } else {
            ""
        }
    }
    return modifiedWords.joinToString(separator = " ")
}