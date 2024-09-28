package za.co.stemgon.prt_02.arrays

fun main() {
    var numbers = mutableListOf<Int>()
    println("Enter a number or q to quit")
    var input = readln()

    while (input != "q") {
        println("Enter a number or q to quit")
        numbers.add(input.toInt())
        input = readln()
    }

    println()
    println("All numbers are: ")
    for (number in numbers) {
        println(number)
    }

    numbers.set(2, 5)
    println()
    println("All numbers are: ")
    for (number in numbers) {
        println(number)
    }

    println(numbers.contains(5))

//
}