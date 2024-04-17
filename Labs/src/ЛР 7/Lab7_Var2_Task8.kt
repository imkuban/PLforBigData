/*
6. Напечатать без повторения слова текста, у которых первая и последняя буквы совпадают.
 */

fun main() {
    val text = "МАМ , ПАП , ТАТ , ТАТ , ТАТ , КАК /Этот код находит и печатает слова текста без повторений, у которых первая и последняя буквы совпадают."
    val words = text.split("\\s+".toRegex()) // Разделение текста на слова
    val uniqueWords = mutableSetOf<String>()

    for (word in words) {
        if (word.length > 1 && word.first() == word.last()) {
            uniqueWords.add(word)
        }
    }

    println("Слова без повторений, у которых первая и последняя буквы совпадают:")
    println(uniqueWords.joinToString(", "))
}
