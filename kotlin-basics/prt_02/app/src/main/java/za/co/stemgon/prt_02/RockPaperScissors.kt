package za.co.stemgon.prt_02

import kotlin.random.Random

fun main(){
    val computerChoice = (0..2).random()
    val options = arrayListOf<String>("Paper", "Rock", "Scissors")
//    println(options[computerChoice])
//    println(computerChoice)

    println()
    println("Choose one of the options below.")
    println("0. paper\n1. Rock\n2. Scissors")
//    print()
    val myChoice = readln().toInt()
//    println(options[myChoice])


    if (options[computerChoice] == options[myChoice]){
        println("It's a draw, play again")
    }else if (options[myChoice] == options[0]){
        if (options[computerChoice] == options[1]){
            println("You won, ")
        }else{
            println("You lost, ")
        }
    }else if (options[myChoice] == options[1]){
        if (options[computerChoice] == options[0]){
            println("You lost, ")
        }else{
            println("You won, ")
        }
    }else{
        if (options[computerChoice] == options[0]){
            println("You won, ")
        }else{
            println("You lost, ")
        }
    }
    println(options[computerChoice])
    println(options[myChoice])
}