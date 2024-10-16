package za.co.stemgon.prt_02.functions


fun makeCoffeeForCustomer(name: String, number: Int) {
    println("i am preparing coffee for $name and I like $number spoons of sugar")
}



fun main(){
    makeCoffeeForCustomer("Carr", 4)

    println("Enter your name,")


    val nameOfClient = readln()
    println("Enter the number of tea spoons you want:")
    val numberOfTeaSpoons = readln().toInt()

    makeCoffeeForCustomer(nameOfClient, numberOfTeaSpoons)
}