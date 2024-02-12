/*
№6 Создать приложение, выводящее фамилию разработчика, дату и время получения задания, а также дату и время сдачи задания.
Для получения последней даты и времени использовать класс Calendar из пакета java.util
*/
import java.util.Calendar
fun main() {
    // Фамилия разработчика
    val developerSurname = "Иванов"

    // Дата и время получения задания
    val startDate = Calendar.getInstance().apply {
        set(Calendar.YEAR, 2024)
        set(Calendar.MONTH, Calendar.JANUARY)
        set(Calendar.DAY_OF_MONTH, 1)
        set(Calendar.HOUR_OF_DAY, 12)
        set(Calendar.MINUTE, 0)
        set(Calendar.SECOND, 0)
    }
    // Дата и время сдачи задания
    val endDate = Calendar.getInstance()

    // Вывод информации
    println("Фамилия разработчика: $developerSurname")
    println("Дата и время получения задания: ${formatCalendar(startDate)}")
    println("Дата и время сдачи задания: ${formatCalendar(endDate)}")
}

// Метод для форматирования даты и времени в удобочитаемый вид
fun formatCalendar(calendar: Calendar): String {
    val year = calendar.get(Calendar.YEAR)
    val month = calendar.get(Calendar.MONTH) + 1 // Месяцы начинаются с 0
    val day = calendar.get(Calendar.DAY_OF_MONTH)
    val hour = calendar.get(Calendar.HOUR_OF_DAY)
    val minute = calendar.get(Calendar.MINUTE)
    val second = calendar.get(Calendar.SECOND)

    return String.format("%02d.%02d.%d %02d:%02d:%02d", day, month, year, hour, minute, second)
}