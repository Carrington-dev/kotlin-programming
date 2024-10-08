package za.co.stemgon.inheritence

import za.co.stemgon.inheritence.classes.PrivateSchool
import za.co.stemgon.inheritence.classes.School
import za.co.stemgon.inheritence.classes.Tertiary

fun main(){
    var school: School =  School()
    school.introduce()
    school.educate()

    var tertiary: Tertiary = Tertiary()
    tertiary.introduce()
    tertiary.educate()

    var privateSchool: School = PrivateSchool()
    privateSchool.introduce()
    privateSchool.educate()
}