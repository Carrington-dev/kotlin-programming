package za.co.stemgon.prt_02.dataclass

data class Coffee(val typeOfCoffee: String, val numberOfSpoons: Int, val hasMilk: Boolean)

fun makeCoffee(coffee: Coffee){
    println("Make ${ coffee.typeOfCoffee} with ${coffee.numberOfSpoons} spoons of sugar and ${ if (coffee.hasMilk) " some " else " no " } milk")
}


fun main(){
    val coffee = Coffee("Cappuccino", 0, true)
    makeCoffee(coffee)

    val coffee2 = Coffee("Espresso", 2, false)
    makeCoffee(coffee2)
}