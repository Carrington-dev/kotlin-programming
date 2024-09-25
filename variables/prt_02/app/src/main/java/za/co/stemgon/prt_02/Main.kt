package za.co.stemgon.prt_02

fun main(){
    println("Hi there")
    var myName = "Carrington";
    println("I am $myName")
    var myAge = 28;
    println("I am $myAge years old")
    val myGod = "Yaweh"
    println("I serve $myGod")
//    val myGod can not be changed

    // Quiz
    val kotlin = "🙂"
    val constantNumber = 102
    var mutableString = "Hi there"
    println(kotlin)
    println(constantNumber)
    println(mutableString)
    mutableString = "I changed"
    println(mutableString)


    var myBiggestNumber = 0
    println(myBiggestNumber)
    myBiggestNumber = 256
    println(myBiggestNumber)
    /*
      Auto interger assignment (Int)

      var myOtherBiggestNumber = 0
    println(myOtherBiggestNumber)
    myOtherBiggestNumber = 25645653567
    println(myOtherBiggestNumber)

    gives an error becuase of change of data type from Int to Long which is not allowed

     */


}