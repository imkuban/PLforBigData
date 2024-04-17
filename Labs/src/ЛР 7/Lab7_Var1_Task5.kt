/*
5.	В тексте после k-го символа вставить заданную подстроку.
 */

fun main() {
    val text = "Наши предки жили долго и счастливо в таинственном лесу, где в каждом кусте могла прятаться волшебница или опасный зверь."
    val k = 24
    val substring = "удивительном"

    if (k < text.length) {
        val modifiedText = text.substring(0, k) + substring + text.substring(k)
        println(modifiedText)
    } else {
        println("Ошибка: k превышает длину текста.")
    }
}
