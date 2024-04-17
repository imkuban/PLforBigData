/*
2.	Реализовать многопоточное приложение “Робот”.
Надо написать робота, который умеет ходить.
За движение каждой его ноги отвечает отдельный поток.
Шаг выражается в выводе в консоль LEFT или RIGHT.
 */

import kotlin.concurrent.thread

class Robot {
    fun walk() {
        val leftLeg = thread(start = false) {
            repeat(5) {
                println("LEFT")
                Thread.sleep(1000) // имитация шага
            }
        }

        val rightLeg = thread(start = false) {
            repeat(5) {
                println("RIGHT")
                Thread.sleep(1000) // имитация шага
            }
        }

        leftLeg.start()
        rightLeg.start()

        leftLeg.join()
        rightLeg.join()
    }
}

fun main() {
    val robot = Robot()
    robot.walk()
}


/*
Этот код создает класс Robot, который содержит метод walk().
Внутри метода walk() создаются два потока, представляющие левую и правую ногу робота.
В каждом потоке выводится сообщение о шаге в соответствующую сторону (LEFT или RIGHT) и происходит пауза с помощью Thread.sleep(), чтобы имитировать шаг.
После запуска обоих потоков метод walk() ожидает их завершения с помощью join(), чтобы гарантировать, что все шаги будут выполнены.
В функции main() создается экземпляр робота и вызывается его метод walk().
 */