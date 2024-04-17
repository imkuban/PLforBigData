/*
5.	Заменить все одинаковые рядом стоящие символы в тексте одним символом.
 */
fun main() {
    val text = "Ззаменить всссе оодинаковые рядомм сстоящие символыы в теексте однимм символомм."

    val result = StringBuilder()
    var prevChar: Char? = null

    for (char in text) {
        if (char.toLowerCase() != prevChar?.toLowerCase()) {
            result.append(char)
            prevChar = char
        }
    }

    println(result.toString())
}
