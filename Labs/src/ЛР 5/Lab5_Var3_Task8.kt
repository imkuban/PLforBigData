/*
В следующих заданиях требуется ввести последовательность строк из текстового потока и выполнить указанные действия.
При этом могут рассматриваться два варианта:
    • каждая строка состоит из одного слова;
    • каждая строка состоит из нескольких слов.
Имена входного и выходного файлов, а также абсолютный путь к ним могут быть введены как параметры командной строки или храниться в файле.
Определить частоту повторяемости букв и слов в стихотворении Александра Пушкина

 */
import java.io.File

fun main() {
    val fileName = "D:/Рабочий стол/Studying/GitHub projects/Labs/src/ЛР 5/Стих.txt" // Имя файла
    val text = readTextFromFile(fileName)

    // Остальной код для обработки текста и вывода результатов остается без изменений
    if (text.isNotBlank()) {
        val letterFrequency = countLetterFrequency(text)
        println("Частота повторяемости букв:")
        letterFrequency.forEach { (letter, count) ->
            println("$letter: $count")
        }

        val wordFrequency = countWordFrequency(text)
        println("\nЧастота повторяемости слов:")
        wordFrequency.forEach { (word, count) ->
            println("$word: $count")
        }
    } else {
        println("Файл $fileName пуст или не существует.")
    }
}

// Функция для чтения текста из файла
fun readTextFromFile(fileName: String): String {
    val file = File(fileName)
    return if (file.exists()) {
        file.readText()
    } else {
        ""
    }
}

// Функция для подсчета частоты повторяемости букв в тексте
fun countLetterFrequency(text: String): Map<Char, Int> {
    val letterFrequency = mutableMapOf<Char, Int>()
    // Итерируемся по каждому символу в тексте
    for (char in text) {
        // Проверяем, является ли символ буквой
        if (char.isLetter()) {
            // Приводим символ к нижнему регистру
            val lowercaseChar = char.toLowerCase()
            // Увеличиваем счетчик повторяемости символа в карте
            letterFrequency[lowercaseChar] = letterFrequency.getOrDefault(lowercaseChar, 0) + 1
        }
    }
    return letterFrequency
}

// Функция для подсчета частоты повторяемости слов в тексте
fun countWordFrequency(text: String): Map<String, Int> {
    val wordFrequency = mutableMapOf<String, Int>()
    // Разбиваем текст на слова с помощью пробелов
    val words = text.split("\\s+".toRegex())
    // Итерируемся по каждому слову
    for (word in words) {
        // Приводим слово к нижнему регистру и убираем пробелы
        val lowercaseWord = word.toLowerCase().trim()
        // Проверяем, не пустое ли слово
        if (lowercaseWord.isNotBlank()) {
            // Увеличиваем счетчик повторяемости слова в карте
            wordFrequency[lowercaseWord] = wordFrequency.getOrDefault(lowercaseWord, 0) + 1
        }
    }
    return wordFrequency
}
