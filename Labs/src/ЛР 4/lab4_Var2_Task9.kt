package `ЛР 4`

/*
Реализовать абстрактные классы или интерфейсы, а также наследование и полиморфизм для следующих классов
9.	interface Мебель <- abstract class Шкаф <- class Книжный Шкаф.
 */
// Интерфейс для мебели
interface Furniture {
    fun assemble()
}

// Абстрактный класс для шкафов
abstract class Cupboard : Furniture {
    abstract fun storeItems()
}

// Класс Книжный Шкаф, который является подклассом шкафа
class Bookshelf : Cupboard() {
    override fun assemble() {
        println("Сборка книжного шкафа")
    }

    override fun storeItems() {
        println("Хранение книг в книжном шкафу")
    }
}

fun main() {
    val bookshelf = Bookshelf()
    bookshelf.assemble()
    bookshelf.storeItems()
}
