package za.co.stemgon.prt_02

import kotlin.random.Random

fun main(){
    val computerChoice = (1..3).random()
    val options = arrayListOf<String>("Paper", "Rock", "Scissors")
    println(options[computerChoice])
}