package exercise4

fun main() {
    var coutNums: Int = 0
    var nums: MutableList<Int>

    while (true) {
        try {
            coutNums = readln().toInt()
            if (coutNums <= 0) {
                println("Input error. Size <= 0")
                return
            }
            break
        } catch (e: NumberFormatException) {
            println("Couldn't parse a number. Please, try again.")
        }
    }

    while (true) {
        try {
            nums = readln().split(" ").map {it.toInt()}.toMutableList()
            if (nums.size < coutNums || coutNums < nums.size) {
                println("List size does not match quantity")
                return
            }
            break
        } catch (e: NumberFormatException) {
            println("Couldn't parse a number. Please, try again.")
        }
    }

    val negativ = addOtrNumsToList(nums)

    if (negativ.isNotEmpty()) {
        println(harderArithmetic(negativ))
    } else {
        println("There are no negative elements.")
    }
}

fun addOtrNumsToList(nums: MutableList<Int>): MutableList<Int> {
    val otrList = mutableListOf<Int>()
    for (i in nums) {
        if (i < 0) {
            otrList.add(i)
        }
    }
    return otrList
}

fun harderArithmetic(sredArm: MutableList<Int>): Int {
    var otrNum = 0
    if (sredArm.isNotEmpty()) {
        otrNum = sredArm.sum() / sredArm.size
    }
    return otrNum
}
