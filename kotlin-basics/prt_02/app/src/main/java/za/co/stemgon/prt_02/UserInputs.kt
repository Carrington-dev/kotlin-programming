package za.co.stemgon.prt_02

fun main(){
    var age =  readln().toInt()
    if ( age < 18){
            println("You are too young, and you can not get an account")
    } else if ( age > 60){
        println("You are on retirement, vhagai vha duhulu vhavho?")
    } else if (age in 50..59){
        println("You are preparing for retirement, vhagai vha duhulu vhavho?")
    }
    else{
            println("Move to the next open counter")
    }

}