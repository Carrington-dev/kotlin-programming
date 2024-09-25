package za.co.stemgon.prt_02

fun main(){
    var name = "";
    println(name)
    name = "My name is Carrington, and I love it that way."
    println(name)
    println()
    for (i in name){
        print("$i ")
    }
    println()

    println(name.toLowerCase())
    println(name.toUpperCase())
}