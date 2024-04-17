/*
6.	После каждого слова текста, заканчивающегося заданной подстрокой, вставить указанное слово.
 */

fun main() {
    val text = "Я часто бываю в этом парке. Я часто бываю в этом парке. Я часто бываю в этом парке"
    val substring = "арке"
    val wordToInsert = "кошке"

    val words = text.split(" ")
    val modifiedText = StringBuilder()

    for (word in words) {
        modifiedText.append(word)
        if (word.endsWith(substring)) {
            modifiedText.append(" $wordToInsert")
        }
        modifiedText.append(" ")
    }

    println(modifiedText.toString().trim())
}
