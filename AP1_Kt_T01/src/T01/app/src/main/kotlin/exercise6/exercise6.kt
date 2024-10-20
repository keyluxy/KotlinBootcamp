package exercise6

import kotlin.system.exitProcess

fun main() {
    val number = checkNumber()
    if (number <= 0) {
        println("Input error. Size <= 0")
        return
    }

    val list = checkList()
    if (number != list.size) {
        println("List size does not match quantity")
        return
    }

    if (list.isNotEmpty()) {
        selectionSort(list)
        println(list.joinToString(" "))
    }

}
fun checkNumber(): Int {
    while (true) {
        try {
            val inputNumber = readln().toInt()

            return inputNumber
        } catch (e: NumberFormatException) {
            println("Couldn't parse a number. Please, try again")
        }
    }
}




fun checkList(): MutableList<Double> {
    while (true) {
        try {
            val inputList = readln().split(" ").map {it.toDouble()}.toMutableList()
            return inputList
        } catch (e: NumberFormatException) {
            println("Couldn't parse a number. Please, try again")
        }
    }
}


fun selectionSort(list: MutableList<Double>): MutableList<Double> {
    val len = list.size
    var temp: Double

    for (i in 0..len - 1) {
        var m = list[i]
        var p = i
        for (j in len - 1 downTo i) {
            if (m > list[j]) {
                m = list[j]
                p = j
            }
        }
        if (p != i) {
             temp = list[i]
            list[i] = list[p]
            list[p] = temp
        }

    }

    return list

}