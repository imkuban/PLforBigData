package `ЛР 3`

/*
Создать классы, спецификации которых приведены ниже. Определить конструкторы и методы setТип(), getТип(), toString().
Определить дополнительно методы в классе, создающем массив объектов. Задать критерий выбора данных и вывести эти данные на консоль.
9. Product: id, Наименование, UPC, Производитель, Цена, Срок хранения, Количество. Создать массив объектов.
Вывести:
a) список товаров для заданного наименования;
b) список товаров для заданного наименования, цена которых не превосходит заданную;
c) список товаров, срок хранения которых больше заданного.

 */

class Product(
    private var id: Int,
    private var name: String,
    private var UPC: String,
    private var manufacturer: String,
    private var price: Double,
    private var shelfLife: Int, // Срок хранения в днях
    private var quantity: Int
) {
    // Методы set и get для всех свойств
    fun setId(id: Int) {
        this.id = id
    }

    fun getId(): Int {
        return id
    }

    fun setName(name: String) {
        this.name = name
    }

    fun getName(): String {
        return name
    }

    fun setUPC(upc: String) {
        this.UPC = upc
    }

    fun getUPC(): String {
        return UPC
    }

    fun setManufacturer(manufacturer: String) {
        this.manufacturer = manufacturer
    }

    fun getManufacturer(): String {
        return manufacturer
    }

    fun setPrice(price: Double) {
        this.price = price
    }

    fun getPrice(): Double {
        return price
    }

    fun setShelfLife(shelfLife: Int) {
        this.shelfLife = shelfLife
    }

    fun getShelfLife(): Int {
        return shelfLife
    }

    fun setQuantity(quantity: Int) {
        this.quantity = quantity
    }

    fun getQuantity(): Int {
        return quantity
    }

    // Метод для преобразования объекта в строку
    override fun toString(): String {
        return "Product(id=$id, name='$name', UPC='$UPC', manufacturer='$manufacturer', price=$price, shelfLife=$shelfLife, quantity=$quantity)"
    }
}

class ProductManager {
    private val products: MutableList<Product> = mutableListOf()

    // Метод для добавления продукта в массив объектов
    fun addProduct(product: Product) {
        products.add(product)
    }

    // Метод для вывода списка товаров по заданному наименованию
    fun listProductsByName(name: String) {
        val filteredProducts = products.filter { it.getName() == name }
        if (filteredProducts.isNotEmpty()) {
            println("Список товаров для наименования '$name':")
            filteredProducts.forEach { println(it) }
        } else {
            println("Товары с наименованием '$name' не найдены.")
        }
    }

    // Метод для вывода списка товаров по заданному наименованию и цене
    fun listProductsByNameAndPrice(name: String, maxPrice: Double) {
        val filteredProducts = products.filter { it.getName() == name && it.getPrice() <= maxPrice }
        if (filteredProducts.isNotEmpty()) {
            println("Список товаров для наименования '$name' и цены до $maxPrice:")
            filteredProducts.forEach { println(it) }
        } else {
            println("Товары с наименованием '$name' и ценой до $maxPrice не найдены.")
        }
    }

    // Метод для вывода списка товаров с сроком хранения больше заданного
    fun listProductsByShelfLife(minShelfLife: Int) {
        val filteredProducts = products.filter { it.getShelfLife() > minShelfLife }
        if (filteredProducts.isNotEmpty()) {
            println("Список товаров со сроком хранения больше $minShelfLife дней:")
            filteredProducts.forEach { println(it) }
        } else {
            println("Товары со сроком хранения больше $minShelfLife дней не найдены.")
        }
    }
}

fun main() {
    val manager = ProductManager()

    // Добавление некоторых продуктов
    manager.addProduct(Product(1, "Молоко", "123456789", "Компания A", 2.5, 7, 100))
    manager.addProduct(Product(2, "Хлеб", "987654321", "Компания B", 1.0, 3, 50))
    manager.addProduct(Product(3, "Яблоки", "567891234", "Компания C", 3.0, 14, 75))

    // Вывод списка товаров по наименованию
    manager.listProductsByName("Молоко")
    println()

    // Вывод списка товаров по наименованию и цене
    manager.listProductsByNameAndPrice("Молоко", 3.0)
    println()

    // Вывод списка товаров с сроком хранения больше заданного
    manager.listProductsByShelfLife(5)
    println()
}
