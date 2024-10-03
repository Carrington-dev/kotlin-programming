package za.co.stemgon.inheritence

import za.co.stemgon.inheritence.classes.School
import za.co.stemgon.inheritence.classes.Tertiary

fun main(){
    var school: School =  School()
    school.introduce()
    school.educate()

    var tertiary: School = Tertiary()
    tertiary.introduce()
    tertiary.educate()
}