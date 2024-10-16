package za.co.stemgon.prt_02

fun main(){
    var counter = 0
    while (counter < 5){
        println(counter)
        counter += 1
    }

    println("Print 1 to continue and 0 to stop")
    var enteredValue = readln().toInt()
    while (enteredValue != 1){
        println("You entered $enteredValue")
        println("Print 1 to continue and 0 to stop")
        enteredValue = readln().toInt()
    }
}