package za.co.stemgon.inheritence.classes

class PrivateSchool: School() {
    private  val  name: String = "Private School"
    private val numberOfTeachers = 150

    public override fun introduce(){
        println("$ My school is $name, it has $numberOfTeachers students")
    }

    public override fun educate(){
        println("$name teaches 9 subjects and is a high school")
    }
}