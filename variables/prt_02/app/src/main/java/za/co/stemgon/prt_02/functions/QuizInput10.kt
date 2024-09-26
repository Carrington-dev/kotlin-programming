package za.co.stemgon.prt_02.functions

fun addNumbers(number: Int, number2: Int): Int{
    return number + number2
}

// More Return Types

fun divideTwoNumbers(number: Double, number2: Double): Double {
    return  number / number2
}

fun main(){
    print("Please enter your first number: ")
    var firstNumber = readln().toInt()

    print("Please enter your second number: ")
    var secondNumber = readln().toInt()

    println("The sum of $firstNumber and $secondNumber is ${addNumbers(firstNumber, secondNumber)}")
    println("The division of $firstNumber and $secondNumber is ${divideTwoNumbers(firstNumber.toDouble(), secondNumber.toDouble())}")

}