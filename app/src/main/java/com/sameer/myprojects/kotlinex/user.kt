package com.sameer.myprojects.kotlinex
fun main() {


    val myobj:Student = Student("sammer",123,"chhenai")
    println(myobj.name)

val name:String = "Sameer"
    println(name.commaSeparated("some other string"))




}

private fun Any.commaSeparated(s: String): Any {
    return "commasepareted "+s;

}


//val obj:print=print()
   // obj.somegthing()