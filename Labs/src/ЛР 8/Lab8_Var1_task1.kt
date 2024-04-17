/*
1.	Реализовать многопоточное приложение “Банк”. Имеется банковский счет.
Сделать синхронным пополнение и снятие денежных средств на счет/со счет случайной суммой.
При каждой операции (пополнения или снятие) вывести текущий баланс счета.
В том случае, если денежных средств недостаточно – вывести сообщение.
 */


/*
Этот код создает класс BankAccount, представляющий банковский счет с методами deposit (пополнение) и withdraw (снятие).
ба метода синхронизированы с помощью аннотации @Synchronized, чтобы обеспечить безопасность в многопоточной среде.
В функции main() создаются и запускаются несколько потоков для пополнения и снятия денег со счета со случайными суммами.
 */

import kotlin.random.Random
import kotlin.concurrent.thread

class BankAccount(private var balance: Int) {
    // Синхронизация метода пополнения счета
    @Synchronized
    fun deposit(amount: Int) {
        balance += amount
        println("Пополнение: +$amount, Текущий баланс: $balance")
    }

    // Синхронизация метода снятия денег со счета
    @Synchronized
    fun withdraw(amount: Int) {
        if (balance >= amount) {
            balance -= amount
            println("Снятие: -$amount, Текущий баланс: $balance")
        } else {
            println("Недостаточно денег на счете для снятия $amount")
        }
    }
}

fun main() {
    val bankAccount = BankAccount(1000)

    // Создание и запуск потоков для пополнения и снятия денег
    repeat(5) {
        thread {
            val amount = Random.nextInt(100, 500)
            bankAccount.deposit(amount)
        }
    }

    repeat(5) {
        thread {
            val amount = Random.nextInt(100, 500)
            bankAccount.withdraw(amount)
        }
    }
}
