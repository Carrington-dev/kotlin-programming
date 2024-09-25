package za.co.stemgon.prt_02

fun main(){
    var circleRatio = 3.14f;
    println(circleRatio)
    circleRatio = 3.14F; // error
    println(circleRatio)
    circleRatio = 3.1415926535F; // error
    println(circleRatio)
    circleRatio = 3.1415926535897932; // error
    println(circleRatio)
}