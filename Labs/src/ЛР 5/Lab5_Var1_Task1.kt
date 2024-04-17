/*
Выполнить задания, контролируя состояние потоков ввода/вывода.
При возникновении ошибок, связанных с корректностью выполнения математических операций, генерировать и обрабатывать исключительные ситуации.
Предусмотреть обработку исключений, возникающих при нехватке памяти, отсутствии требуемой записи (объекта) в файле, недопустимом значении поля и т.д.

Задание
Lab3_Var1_Task8.Определить класс Комплекс. Класс должен содержать несколько конструкторов.
Реализовать методы для сложения, вычитания, умножения, деления, присваивания комплексных чисел.
Создать два вектора размерности n из комплексных координат. Передать их в метод, который выполнит их сложение.

 */
import kotlin.math.pow
import kotlin.math.sqrt

class Complex(var real: Double, var imag: Double) {
    init {
        require(!(real.isNaN() || imag.isNaN())) { "Invalid complex number: NaN" }
    }

    // Конструктор без аргументов, создает комплексное число 0 + 0i
    constructor() : this(0.0, 0.0)

    // Конструктор с одним аргументом, создает комплексное число a + 0i
    constructor(a: Double) : this(a, 0.0)

    // Метод для получения модуля комплексного числа
    fun abs(): Double {
        return kotlin.math.sqrt(real.pow(2) + imag.pow(2))
    }

    // Метод для сложения комплексных чисел
    fun add(c: Complex) {
        real += c.real
        imag += c.imag
    }

    // Метод для вычитания комплексных чисел
    fun subtract(c: Complex) {
        real -= c.real
        imag -= c.imag
    }

    // Метод для умножения комплексных чисел
    fun multiply(c: Complex) {
        val tempReal = real * c.real - imag * c.imag
        val tempImag = real * c.imag + imag * c.real
        real = tempReal
        imag = tempImag
    }

    // Метод для деления комплексных чисел
    fun divide(c: Complex) {
        val denominator = c.real.pow(2) + c.imag.pow(2)
        if (denominator == 0.0) {
            throw IllegalArgumentException("Division by zero is undefined for complex numbers.")
        }
        val tempReal = (real * c.real + imag * c.imag) / denominator
        val tempImag = (imag * c.real - real * c.imag) / denominator
        real = tempReal
        imag = tempImag
    }

    // Метод для вывода комплексного числа в формате a + bi
    override fun toString(): String {
        return "$real + ${imag}i"
    }
}

fun main() {
    try {
        val complex1 = Complex(2.0, 3.0)
        val complex2 = Complex(1.0, -1.0)

        println("Комплексное число 1: $complex1")
        println("Комплексное число 2: $complex2")

        val sum = Complex(complex1.real, complex1.imag)
        sum.add(complex2)
        println("Сумма: $sum")

        val difference = Complex(complex1.real, complex1.imag)
        difference.subtract(complex2)
        println("Разность: $difference")

        val product = Complex(complex1.real, complex1.imag)
        product.multiply(complex2)
        println("Произведение: $product")

        val quotient = Complex(complex1.real, complex1.imag)
        quotient.divide(complex2)
        println("Частное: $quotient")

        // Создание двух векторов из комплексных чисел
        val vector1 = Array(3) { Complex(it.toDouble(), it.toDouble()) }
        val vector2 = Array(3) { Complex((it + 1).toDouble(), (it + 1).toDouble()) }

        // Сложение векторов
        val sumVector = Array(3) { Complex() }
        for (i in vector1.indices) {
            sumVector[i] = Complex(vector1[i].real, vector1[i].imag)
            sumVector[i].add(vector2[i])
        }

        // Вывод результата сложения векторов
        println("Результат сложения векторов:")
        sumVector.forEachIndexed { index, complex ->
            println("Элемент $index: $complex")
        }
    } catch (e: Exception) {
        println("An error occurred: ${e.message}")
    }
}
