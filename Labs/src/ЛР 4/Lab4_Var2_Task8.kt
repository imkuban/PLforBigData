package `ЛР 4`

/*
Реализовать абстрактные классы или интерфейсы, а также наследование и полиморфизм для следующих классов
8.	interface Корабль <- class Грузовой Корабль <- class Танкер.

 */

// Интерфейс для кораблей
interface Ship {
    fun sail()
}

// Абстрактный класс для грузовых кораблей
abstract class CargoShip : Ship {
    abstract fun loadCargo()
    abstract fun unloadCargo()
}

// Класс Танкер, который является подклассом грузового корабля
class Tanker : CargoShip() {
    override fun sail() {
        println("Танкер плывет по морю.")
    }

    override fun loadCargo() {
        println("Танкер загружает нефтепродукты.")
    }

    override fun unloadCargo() {
        println("Танкер выгружает нефтепродукты.")
    }
}

fun main() {
    val tanker = Tanker()
    tanker.sail()
    tanker.loadCargo()
    tanker.unloadCargo()
}