package exercise5

fun main() {
    var countNumber: Int

    while (true) {
        try {
            countNumber = readln().toInt()

            if (countNumber <= 0) {
                println("Input error. Size <= 0")
                return
            } else {
                break
            }
        } catch (e: NumberFormatException) {
            println("Couldn't parse a number. Please, try again")
        }
    }

    val arr = mutableSetOf<Int>()
    var count = 0

    val numsInput = readln().split(" ")

    try {
        if (numsInput.size != countNumber) {
            println("List size does not match quantity")
            return
        }
    } catch (e: IllegalArgumentException) {
        println("List size does not match quantity")
    }


    while (count < countNumber) {
        val num = numsInput[count].toInt()

        if (coincidenceFirstandLastNumber(num)) {
            arr.add(num)
        }
        count++
    }

    if (arr.isNotEmpty()) {
        println(arr.joinToString(" "))
    } else {
        println("There are no such elements.")
    }
}

fun coincidenceFirstandLastNumber(num: Int): Boolean {
    val numToStr = num.toString()
    return numToStr.first() == numToStr.last()
}
