import java.util.*

class Driver(val name: String) {
    var isAvailable: Boolean = true
    var isWorking: Boolean = false

    fun requestRepair() {
        println("$name has requested a repair.")
    }

    fun markTripCompleted() {
        println("$name has marked the trip as completed.")
    }
}

class Car(val registrationNumber: String) {
    var isAvailable: Boolean = true

    fun markForRepair() {
        println("Car $registrationNumber has been marked for repair.")
    }
}

class Trip(private val driver: Driver, private val car: Car) {
    fun startTrip() {
        println("Trip started by ${driver.name} with car ${car.registrationNumber}.")
    }

    fun endTrip() {
        println("Trip ended by ${driver.name} with car ${car.registrationNumber}.")
    }
}

class Dispatcher {
    fun assignTrip(driver: Driver, car: Car) {
        if (driver.isAvailable && car.isAvailable) {
            val trip = Trip(driver, car)
            trip.startTrip()
            driver.isWorking = true
            car.isAvailable = false
        } else {
            println("Driver or car is not available for the trip.")
        }
    }

    fun suspendDriver(driver: Driver) {
        driver.isAvailable = false
    }
}

fun main() {
    val dispatcher = Dispatcher()

    val driver1 = Driver("John")
    val driver2 = Driver("Alice")

    val car1 = Car("ABC123")
    val car2 = Car("XYZ789")

    dispatcher.assignTrip(driver1, car1)
    dispatcher.assignTrip(driver2, car2)

    driver1.markTripCompleted()
    car1.markForRepair()

    dispatcher.suspendDriver(driver1)
}
