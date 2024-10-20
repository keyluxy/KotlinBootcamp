package exercise3

import exercise2.checkInput

fun main() {
    val input = checkInput()
    if (input > 40) {
        println("Too large n")
    } else
        println(fibonacciRecursion(input))
}

fun fibonacciRecursion(num: Int): Int {
    return if (num <= 1) {
        num
    } else {
        fibonacciRecursion(num - 1) + fibonacciRecursion(num - 2)
    }
}

