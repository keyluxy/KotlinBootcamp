package exercise2



fun main() {
    var exitProgram = false

    while (!exitProgram) {
        val second = checkInput()
        if (second <= 0) {
            println("Incorrect time")
            exitProgram = true
        } else {
            val (hour, minutes, sec) = parseTime(second)
            println(outputTime(hour, minutes, sec))
            exitProgram = true
        }
    }
}


fun parseTime(totalTime: Int): Triple<Int, Int, Int> {
    val hour = totalTime / 3600
    val minutes = (totalTime % 3600) / 60
    val second = totalTime % 60

    return Triple(hour, minutes, second)
}


fun outputTime(hour: Int, minutes: Int, second: Int): String {
    return String.format("%02d:%02d:%02d", hour, minutes, second)
}

fun checkInput(): Int {
    val input = readln()

    return when {
        input.toIntOrNull() != null -> {
            input.toInt()
        }

        else -> {
            println("Couldn't parse a number. Please, try again")
            checkInput()
        }
    }
}