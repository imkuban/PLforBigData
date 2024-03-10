package `ЛР 4`

/*
9.	Создать класс Park (парк) с внутренним классом, с помощью объектов которого можно хранить информацию об аттракционах, времени их работы и стоимости.
 */

class Park {
    // Внутренний класс для хранения информации об аттракционах
    inner class Attraction(val name: String, val workingHours: String, val cost: Double)

    // Список аттракционов парка
    private val attractions: MutableList<Attraction> = mutableListOf()

    // Метод для добавления аттракциона в парк
    fun addAttraction(name: String, workingHours: String, cost: Double) {
        val attraction = Attraction(name, workingHours, cost)
        attractions.add(attraction)
    }

    // Метод для вывода информации обо всех аттракционах парка
    fun displayAttractions() {
        println("Список аттракционов парка:")
        attractions.forEachIndexed { index, attraction ->
            println("Аттракцион ${index + 1}: ${attraction.name}, Время работы: ${attraction.workingHours}, Стоимость: ${attraction.cost}")
        }
    }
}

fun main() {
    // Создаем объект парка
    val park = Park()

    // Добавляем аттракции в парк
    park.addAttraction("Карусель", "10:00 - 20:00", 5.0)
    park.addAttraction("Горка", "11:00 - 19:00", 7.0)
    park.addAttraction("Колесо обозрения", "12:00 - 21:00", 10.0)

    // Выводим информацию об аттракциях парка
    park.displayAttractions()
}
