package `ЛР 4`

/*
8.	Создать класс Computer (компьютер) с внутренним классом,
с помощью объектов которого можно хранить информацию об операционной системе, процессоре и оперативной памяти.
 */

class Computer {
    // Внутренний класс для хранения информации об операционной системе
    inner class OperatingSystem(var name: String, var version: String)

    // Внутренний класс для хранения информации о процессоре
    inner class Processor(var model: String, var frequency: Double)

    // Внутренний класс для хранения информации об оперативной памяти
    inner class RAM(var capacity: Int, var type: String)

    // Свойства компьютера
    var os: OperatingSystem? = null
    var processor: Processor? = null
    var ram: RAM? = null

    // Метод для вывода информации о компьютере
    override fun toString(): String {
        return "Computer: OS=${os?.name} ${os?.version}, Processor=${processor?.model} ${processor?.frequency} GHz, RAM=${ram?.capacity}GB ${ram?.type}"
    }
}

fun main() {
    // Создаем объект компьютера
    val myComputer = Computer()

    // Создаем объекты для операционной системы, процессора и оперативной памяти
    val os = myComputer.OperatingSystem("Windows", "10")
    val processor = myComputer.Processor("Intel Core i5", 3.2)
    val ram = myComputer.RAM(8, "DDR4")

    // Устанавливаем информацию о компонентов в компьютер
    myComputer.os = os
    myComputer.processor = processor
    myComputer.ram = ram

    // Выводим информацию о компьютере
    println(myComputer)
}
