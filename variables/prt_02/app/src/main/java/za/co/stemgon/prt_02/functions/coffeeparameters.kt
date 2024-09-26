package za.co.stemgon.prt_02.functions

fun makeCoffee(name: String, number: Int) {
    println("i am preparing coffee for $name and I like $number spoons of sugar")
}

fun addNumber(number1: Int, number2: Int): Int {
    return (number1 + number2);
}

fun main(){
    makeCoffee("Carr", 4)
    makeCoffee("Carry", 3)
    makeCoffee("Carrie", 6)
    makeCoffee("Mulalo", 8)
    makeCoffee("Him", 54)
    makeCoffee("Her", 47)
    println(addNumber(5, 8))
}