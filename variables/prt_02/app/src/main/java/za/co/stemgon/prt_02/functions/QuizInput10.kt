package za.co.stemgon.prt_02.functions

fun addNumbers(number: Int, number2: Int): Int{
    return number + number2
}

fun main(){
    print("Please enter your first number: ")
    var firstNumber = readln().toInt()

    print("Please enter your second number: ")
    var secondNumber = readln().toInt()

    println("The sum of $firstNumber and $secondNumber is ${addNumbers(firstNumber, secondNumber)}")

}