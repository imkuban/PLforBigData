package `ЛР 3`

/*
Создать классы, спецификации которых приведены ниже. Определить конструкторы и методы setТип(), getТип(), toString().
Определить дополнительно методы в классе, создающем массив объектов. Задать критерий выбора данных и вывести эти данные на консоль.
Car: id, Марка, Модель, Год выпуска, Цвет, Цена, Регистрационный номер. Создать массив объектов.
Вывести:
a) список автомобилей заданной марки;
b) список автомобилей заданной модели, которые эксплуатируются больше n лет;
c) список автомобилей заданного года выпуска, цена которых больше указанной.

 */

class Car(
    private var id: Int,
    private var brand: String,
    private var model: String,
    private var year: Int,
    private var color: String,
    private var price: Double,
    private var registrationNumber: String
) {
    // Методы set и get
    fun setId(id: Int) {
        this.id = id
    }

    fun getId(): Int {
        return id
    }

    fun setBrand(brand: String) {
        this.brand = brand
    }

    fun getBrand(): String {
        return brand
    }

    fun setModel(model: String) {
        this.model = model
    }

    fun getModel(): String {
        return model
    }

    fun setYear(year: Int) {
        this.year = year
    }

    fun getYear(): Int {
        return year
    }

    fun setColor(color: String) {
        this.color = color
    }

    fun getColor(): String {
        return color
    }

    fun setPrice(price: Double) {
        this.price = price
    }

    fun getPrice(): Double {
        return price
    }

    fun setRegistrationNumber(registrationNumber: String) {
        this.registrationNumber = registrationNumber
    }

    fun getRegistrationNumber(): String {
        return registrationNumber
    }

    override fun toString(): String {
        return "Car(id=$id, brand='$brand', model='$model', year=$year, color='$color', price=$price, registrationNumber='$registrationNumber')"
    }
}

fun main() {
    val cars = arrayOf(
        Car(1, "Toyota", "Camry", 2018, "Black", 25000.0, "ABC123"),
        Car(2, "Honda", "Civic", 2016, "Red", 18000.0, "XYZ456"),
        Car(3, "Toyota", "Corolla", 2017, "Blue", 25000.0, "DEF789"),
        Car(4, "Ford", "Focus", 2017, "White", 21000.0, "GHI012"),
        Car(5, "Toyota", "Rav4", 2014, "Silver", 28000.0, "JKL345")
    )

    // a) список автомобилей заданной марки
    val brandToSearch = "Toyota"
    println("Список автомобилей марки $brandToSearch:")
    cars.filter { it.getBrand() == brandToSearch }.forEach { println(it) }

    // b) список автомобилей заданной модели, которые эксплуатируются больше n лет
    val modelToSearch = "Camry"
    val yearsToExploit = 5
    println("\nСписок автомобилей модели $modelToSearch, которые эксплуатируются более $yearsToExploit лет:")
    val currentYear = 2024 // предположим, что текущий год 2022
    cars.filter { it.getModel() == modelToSearch && currentYear - it.getYear() > yearsToExploit }
        .forEach { println(it) }

    // c) список автомобилей заданного года выпуска, цена которых больше указанной
    val yearToSearch = 2017
    val minPrice = 20000.0
    println("\nСписок автомобилей выпуска $yearToSearch, цена которых больше $minPrice:")
    cars.filter { it.getYear() == yearToSearch && it.getPrice() > minPrice }.forEach { println(it) }
}
