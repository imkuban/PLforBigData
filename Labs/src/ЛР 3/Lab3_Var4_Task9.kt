package `ЛР 3`

/*
Построить модель программной системы.
9. Система Интернет-магазин. Администратор добавляет информацию о Товаре.
Клиент делает и оплачивает Заказ на Товары.
Администратор регистрирует Продажу и может занести неплательщиков в «черный список».
 */
import java.util.*

// Класс, представляющий товар
data class Item(
    val id: Int,
    val name: String,
    val price: Double
)

// Класс, представляющий заказ
data class Order(
    val id: Int,
    val items: List<Item>,
    val totalPrice: Double
)

// Класс, представляющий клиента
data class Customer(
    val id: Int,
    val name: String,
    val email: String
)

// Класс, представляющий продажу
data class Sale(
    val id: Int,
    val customer: Customer,
    val order: Order,
    val date: Date = Date()
)

// Класс, представляющий администратора магазина
class Administrator {
    val blackList: MutableSet<Customer> = mutableSetOf()

    // Метод для добавления клиента в черный список
    fun addToBlackList(customer: Customer) {
        blackList.add(customer)
    }

    // Метод для регистрации продажи
    fun registerSale(customer: Customer, order: Order) {
        if (customer !in blackList) {
            val saleId = generateSaleId() // Генерируем уникальный идентификатор продажи
            val sale = Sale(saleId, customer, order)
            // Здесь может быть логика сохранения продажи в базу данных или ее обработки
            println("Продажа зарегистрирована: $sale")
        } else {
            println("Клиент находится в черном списке и не может совершать покупки.")
        }
    }

    // Метод для генерации уникального идентификатора продажи
    private fun generateSaleId(): Int {
        // Здесь может быть более сложная логика генерации уникального идентификатора
        return Random().nextInt(1000)
    }
}

fun main() {
    // Создаем товары
    val item1 = Item(1, "Ноутбук", 1000.0)
    val item2 = Item(2, "Смартфон", 500.0)
    val item3 = Item(3, "Наушники", 100.0)

    // Создаем заказ
    val order = Order(1, listOf(item1, item2), item1.price + item2.price)

    // Создаем клиента
    val customer = Customer(1, "Иван", "ivan@example.com")

    // Создаем администратора
    val admin = Administrator()

    // Регистрируем продажу
    admin.registerSale(customer, order)

    // Добавляем клиента в черный список
    admin.addToBlackList(customer)

    // Пытаемся зарегистрировать продажу с клиентом из черного списка
    admin.registerSale(customer, order)
}

