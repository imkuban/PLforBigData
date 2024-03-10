package `ЛР 3`

/*
Создать приложение, удовлетворяющее требованиям, приведенным в задании.
Аргументировать принадлежность классу каждого создаваемого метода и корректно переопределить для каждого класса методы equals(), hashCode(), toString().
8. Создать объект класса Пианино, используя класс Клавиша.
Методы: настроить, играть на пианино, нажимать клавишу.
 */
// Класс, представляющий клавишу пианино
class Key(val note: String) {
    // Переопределение метода equals для сравнения объектов Key по их нотам
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Key) return false
        return note == other.note
    }

    // Переопределение метода hashCode для обеспечения согласованности с equals
    override fun hashCode(): Int {
        return note.hashCode()
    }

    // Переопределение метода toString для представления объекта Key в виде строки
    override fun toString(): String {
        return "Key(note='$note')"
    }
}

// Класс, представляющий пианино
class Piano {
    private var tuned = false

    // Метод для настройки пианино
    fun tune() {
        println("Piano is tuned.")
        tuned = true
    }

    // Метод для игры на пианино
    fun play() {
        if (tuned) {
            println("Playing the piano.")
        } else {
            println("Cannot play the piano until it's tuned.")
        }
    }

    // Метод для нажатия клавиши на пианино
    fun pressKey(key: Key) {
        if (tuned) {
            println("Key ${key.note} is pressed.")
        } else {
            println("Cannot press keys until the piano is tuned.")
        }
    }

    // Переопределение метода equals для сравнения объектов Piano
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Piano) return false
        return tuned == other.tuned
    }

    // Переопределение метода hashCode для обеспечения согласованности с equals
    override fun hashCode(): Int {
        return tuned.hashCode()
    }

    // Переопределение метода toString для представления объекта Piano в виде строки
    override fun toString(): String {
        return "Piano(tuned=$tuned)"
    }
}

fun main() {
    // Создание объектов пианино и клавиши
    val piano = Piano()
    val keyC = Key("C")

    // Настройка пианино и игра на нем
    piano.tune()
    piano.play()

    // Нажатие клавиши на пианино
    piano.pressKey(keyC)

    // Примеры использования переопределенных методов equals(), hashCode(), toString()
    val keyD = Key("D")
    val anotherKeyD = Key("D")

    println("keyD equals anotherKeyD: ${keyD == anotherKeyD}")
    println("keyD hashCode: ${keyD.hashCode()}")
    println("keyD: $keyD")
    println("piano: $piano")
}
