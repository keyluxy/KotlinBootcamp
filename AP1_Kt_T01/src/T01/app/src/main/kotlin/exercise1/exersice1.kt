package exercise1

import kotlin.math.pow
import kotlin.math.sqrt

data class Point(val x: Double, val y: Double)

fun main() {

    val coord1 = Point(checkInput(), checkInput())
    val coord2 = Point(checkInput(), checkInput())
    val coord3 = Point(checkInput(), checkInput())


    val per = perimeterTriangle(coord1, coord2, coord3)

    if (isTriangle(coord1, coord2, coord3)) {
        println(String.format("%.3f ", per))
    } else println("It's not a triangle")

}

fun isTriangle(coord1: Point, coord2: Point, coord3: Point): Boolean {
    val area = 0.5 * (coord1.x * (coord2.y - coord3.y) + coord2.x * (coord3.y - coord1.y) + coord3.x * (coord1.y - coord2.y))
    return area != 0.0
}

fun perimeterTriangle(coord1: Point, coord2: Point, coord3: Point): Double {
    val AB = sqrt((coord2.x - coord1.x).pow(2.0) + (coord2.y - coord1.y).pow(2.0))
    val AC = sqrt((coord3.x - coord1.x).pow(2.0) + (coord3.y - coord1.y).pow(2.0))
    val BC = sqrt((coord3.x - coord2.x).pow(2.0) + (coord3.y - coord2.y).pow(2.0))

    return AB + AC + BC
}

fun checkInput(): Double {
    while (true) {
        try {
            return readln().toDouble()
        } catch (e: NumberFormatException) {
            println("Couldn't parse a number. Please, try again")
        }
    }
}