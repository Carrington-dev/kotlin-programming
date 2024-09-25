package za.co.stemgon.prt_02

import kotlin.random.Random

fun main(){
    val computerChoice = (0..2).random()
    val options = arrayListOf<String>("Paper", "Rock", "Scissors")
    println(options[computerChoice])
    println(computerChoice)

//    print()
//    val myChoice =
}