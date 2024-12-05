 package com.example.counterapp

/*
fun and(p:Boolean , q:Boolean):Boolean = p && q
fun or(p:Boolean , q:Boolean):Boolean = p || q
fun notp(p:Boolean):Boolean = !p
fun notq(q:Boolean) = !q
fun implies(p:Boolean , q:Boolean):Boolean = !p || q
*/

fun generateTruthTable(operator: String) {
    val truthValues = listOf(
        true to true,
        true to false,
        false to true,
        false to false
    )

    println("| p     | q     | $operator |")
    println("-----------------------------")

    for ((p, q) in truthValues) {
        val result = when (operator) {
            "AND" -> p && q
            "OR" -> p || q
            "IMPLIES" -> !p || q
            "NOT" -> !p // For NOT, you might handle differently since it only needs `p`
            else -> false // Shouldn't happen for predefined operators
        }
        println("| $p | $q | $result |")
    }
}

fun main(){

    val predefinedOptions = listOf("AND", "OR", "NOT", "IMPLIES")

    println("Choose a logical operator from the list or type your own:")
    println(predefinedOptions.joinToString(", "))

    val userChoice = readln().uppercase()

   generateTruthTable(userChoice)


}
