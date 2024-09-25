package za.co.stemgon.prt_02.functions

fun makeCoffee(name: String) {
    println("i am preparing coffee for $name")
}

fun addNumber(number1: Int, number2: Int): Int {
    return (number1 + number2);
}

fun main(){
    makeCoffee("Carr")
    println(addNumber(5, 8))
}