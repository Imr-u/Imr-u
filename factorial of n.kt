//Method
fun main(){
    recursiveMultiple(5)
   

}

fun recursiveMultiple(num : Int) : Int{

        if (num == 0) return 1
        val result = num * recursiveMultiple(num - 1)
        println("Factorial of $num is $result")
        return result
    }
//Method 2
package com.example.counterapp

fun main() {
    val result = recursive(5)
    println("Factorial: $result")
}

fun recursive(num: Int): Int {
    // Base case: if num is 0, return 1 because 0! = 1
    return if (num == 0) {
        1
    } else {
        num * recursive(num - 1)  // Recursive case: multiply num by factorial of (num - 1)
    }
}
