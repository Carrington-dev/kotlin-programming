package za.co.stemgon.inheritence.classes

open class School {
    private  val  name: String = "School"
    private val numberOfTeachers = 234

    public open fun introduce(){
        println("$ My school is $name, it has $numberOfTeachers students")
    }

    public open fun educate(){
        println("$name teaches 9 subjects and is a high school")
    }
}