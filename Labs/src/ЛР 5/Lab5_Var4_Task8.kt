/*
При выполнении следующих заданий для вывода результатов создавать новую директорию и файл средствами класса File
8.	Из текста Java-программы удалить все виды комментариев.
 */

import java.io.File

fun main() {
    val inputFileName = "D:\\Рабочий стол\\Studying\\GitHub projects\\Labs\\src\\ЛР 5\\код.txt" // Имя файла с Java-кодом
    val outputDirectoryName = "D:\\Рабочий стол\\Studying\\GitHub projects\\Labs\\src\\ЛР 5" // Название новой директории
    val outputFileName = "cleaned_code.txt" // Название нового файла без комментариев

    // Создаем новую директорию, если её нет
    val outputDirectory = File(outputDirectoryName)
    outputDirectory.mkdir()

    // Считываем текст из файла с Java-кодом
    val javaCode = readTextFromFile3(inputFileName)

    // Удаляем комментарии из Java-кода
    val cleanedCode = removeComments(javaCode)

    // Записываем очищенный код в новый файл
    val outputFile = File(outputDirectory, outputFileName)
    outputFile.writeText(cleanedCode)

    println("Очищенный код записан в файл: ${outputFile.absolutePath}")
}

// Функция для чтения текста из файла
fun readTextFromFile3(fileName: String): String {
    val file = File(fileName)
    return if (file.exists()) {
        file.readText()
    } else {
        ""
    }
}

// Функция для удаления комментариев из Java-кода
fun removeComments(javaCode: String): String {
    // Регулярное выражение для удаления всех видов комментариев в Java-коде
    val commentPattern = "(?:/\\*(?:[^*]|(?:\\*+[^*/]))*\\*+/)|(?://.*)".toRegex()
    return javaCode.replace(commentPattern, "")
}
