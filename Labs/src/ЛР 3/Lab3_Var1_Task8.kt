package `ЛР 3`
/*
8.Определить класс Комплекс. Класс должен содержать несколько конструкторов.
Реализовать методы для сложения, вычитания, умножения, деления, присваивания комплексных чисел.
Создать два вектора размерности n из комплексных координат. Передать их в метод, который выполнит их сложение.
 */
import kotlin.math.pow
import kotlin.math.sqrt

class Complex(var real: Double, var imag: Double) {
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
}

