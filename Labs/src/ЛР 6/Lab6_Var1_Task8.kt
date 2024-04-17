/*
8.	Задана строка, состоящая из символов '(', ')', '[', ']', '{', '}'. Проверить правильность расстановки скобок. Использовать стек.

 */
import java.util.Stack

fun main() {
    val input = "{[()()]}{"
    if (checkBracketBalance(input)) {
        println("Скобки в строке расставлены правильно.")
    } else {
        println("Скобки в строке расставлены неправильно.")
    }
}

fun checkBracketBalance(input: String): Boolean {
    val stack = Stack<Char>()

    for (char in input) {
        when (char) {
            '(', '[', '{' -> stack.push(char)
            ')', ']', '}' -> {
                if (stack.isEmpty()) {
                    return false // Встретилась закрывающая скобка, но стек пустой
                }
                val top = stack.pop()
                if ((char == ')' && top != '(') ||
                    (char == ']' && top != '[') ||
                    (char == '}' && top != '{')
                ) {
                    return false // Не совпадение типов скобок
                }
            }
            else -> return false // Неизвестный символ в строке
        }
    }

    return stack.isEmpty() // Если стек пустой в конце, то скобки расставлены правильно
}
