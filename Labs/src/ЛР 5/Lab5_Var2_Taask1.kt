/*
Выполнить задания , реализуя собственные обработчики исключений и исключения ввода/вывода.
Задание
Создать классы, спецификации которых приведены ниже. Определить конструкторы и методы setТип(), getТип(), toString().
Определить дополнительно методы в классе, создающем массив объектов. Задать критерий выбора данных и вывести эти данные на консоль.
Car: id, Марка, Модель, Год выпуска, Цвет, Цена, Регистрационный номер. Создать массив объектов.
Вывести:
a) список автомобилей заданной марки;
b) список автомобилей заданной модели, которые эксплуатируются больше n лет;
c) список автомобилей заданного года выпуска, цена которых больше указанной.


 */

import java.io.IOException

// Собственный класс исключения для ошибок ввода/вывода
class CarDataException(message: String) : IOException(message)

// Собственный класс исключения для ошибок валидации данных автомобиля
class CarValidationException(message: String) : Exception(message)

class Cars(
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
        if (id < 0) {
            throw CarValidationException("ID must be a non-negative number.")
        }
        this.id = id
    }

    fun getId(): Int {
        return id
    }

    fun setBrand(brand: String) {
        if (brand.isBlank()) {
            throw CarValidationException("Brand cannot be empty.")
        }
        this.brand = brand
    }

    fun getBrand(): String {
        return brand
    }

    fun setModel(model: String) {
        if (model.isBlank()) {
            throw CarValidationException("Model cannot be empty.")
        }
        this.model = model
    }

    fun getModel(): String {
        return model
    }

    fun setYear(year: Int) {
        if (year < 1900 || year > 2025) {
            throw CarValidationException("Year must be between 1900 and 2025.")
        }
        this.year = year
    }

    fun getYear(): Int {
        return year
    }

    fun setColor(color: String) {
        if (color.isBlank()) {
            throw CarValidationException("Color cannot be empty.")
        }
        this.color = color
    }

    fun getColor(): String {
        return color
    }

    fun setPrice(price: Double) {
        if (price <= 0) {
            throw CarValidationException("Price must be a positive number.")
        }
        this.price = price
    }

    fun getPrice(): Double {
        return price
    }

    fun setRegistrationNumber(registrationNumber: String) {
        if (registrationNumber.isBlank()) {
            throw CarValidationException("Registration number cannot be empty.")
        }
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
    try {
        val cars = arrayOf(
            Cars(1, "Toyota", "Camry", 2018, "Black", 25000.0, "ABC123"),
            Cars(2, "Honda", "Civic", 2016, "Red", 18000.0, "XYZ456"),
            Cars(3, "Toyota", "Corolla", 2017, "Blue", 25000.0, "DEF789"),
            Cars(4, "Ford", "Focus", 2017, "White", 21000.0, "GHI012"),
            Cars(5, "Toyota", "Rav4", 2014, "Silver", 28000.0, "JKL345")
        )

        // a) список автомобилей заданной марки
        val brandToSearch = "Toyota"
        println("Список автомобилей марки $brandToSearch:")
        cars.filter { it.getBrand() == brandToSearch }.forEach { println(it) }

        // b) список автомобилей заданной модели, которые эксплуатируются больше n лет
        val modelToSearch = "Camry"
        val yearsToExploit = 5
        println("\nСписок автомобилей модели $modelToSearch, которые эксплуатируются более $yearsToExploit лет:")
        val currentYear = 2024 // предположим, что текущий год 2024
        cars.filter { it.getModel() == modelToSearch && currentYear - it.getYear() > yearsToExploit }
            .forEach { println(it) }

        // c) список автомобилей заданного года выпуска, цена которых больше указанной
        val yearToSearch = 2017
        val minPrice = 20000.0
        println("\nСписок автомобилей выпуска $yearToSearch, цена которых больше $minPrice:")
        cars.filter { it.getYear() == yearToSearch && it.getPrice() > minPrice }.forEach { println(it) }
    } catch (e: CarValidationException) {
        println("Validation error: ${e.message}")
    } catch (e: CarDataException) {
        println("Data error: ${e.message}")
    } catch (e: Exception) {
        println("An error occurred: ${e.message}")
    }
}
