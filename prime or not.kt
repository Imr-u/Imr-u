// Method 1
import kotlin.math.sqrt

fun main() {
    println("Enter a number:")
    val number = readLine()?.toIntOrNull() ?: return

    if (isPrimeOptimized(number)) {
        println("$number is Prime")
    } else {
        println("$number is Not Prime")
    }
}

fun isPrimeOptimized(n: Int): Boolean {
    if (n <= 1) return false
    for (i in 2..sqrt(n.toDouble()).toInt()) {  // Only check up to √n
        if (n % i == 0) return false
    }
    return true
}

// Method 2
fun main() {
    println("Enter a number:")
    val number = readLine()?.toIntOrNull() ?: return

    if (isPrimeRecursive(number, 2)) {
        println("$number is Prime")
    } else {
        println("$number is Not Prime")
    }
}

fun isPrimeRecursive(n: Int, divisor: Int): Boolean {
    if (n <= 1) return false
    if (divisor * divisor > n) return true  // No divisors found, it's prime
    if (n % divisor == 0) return false  // Found a divisor, it's not prime
    return isPrimeRecursive(n, divisor + 1)  // Check next divisor
}

    return true
}
//Metho 3
import kotlin.math.sqrt

fun main() {
    println("Enter a number:")
    val number = readLine()?.toIntOrNull() ?: return

    if (isPrimeEfficient(number)) {
        println("$number is Prime")
    } else {
        println("$number is Not Prime")
    }
}

fun isPrimeEfficient(n: Int): Boolean {
    if (n <= 1) return false
    if (n == 2 || n == 3) return true  // 2 and 3 are prime
    if (n % 2 == 0 || n % 3 == 0) return false  // Eliminate multiples of 2 and 3

    var i = 5
    while (i * i <= n) {
        if (n % i == 0 || n % (i + 2) == 0) return false
        i += 6  // Check numbers of the form 6k ± 1
    }
    return true
}
// Method 4
import kotlin.math.sqrt

fun main() {
    println("Enter a number:")
    val number = readLine()?.toIntOrNull() ?: return

    if (isPrimeOptimized(number)) {
        println("$number is Prime")
    } else {
        println("$number is Not Prime")
    }
}

fun isPrimeOptimized(n: Int): Boolean {
    if (n <= 1) return false
    for (i in 2..sqrt(n.toDouble()).toInt()) {  // Only check up to √n
        if (n % i == 0) return false
    }
    return true
}
// Method 5
fun main() {
    println("Enter a number:")
    val number = readLine()?.toIntOrNull() ?: return

    if (isPrimeBasic(number)) {
        println("$number is Prime")
    } else {
        println("$number is Not Prime")
    }
}

fun isPrimeBasic(n: Int): Boolean {
    if (n <= 1) return false  // Numbers <= 1 are not prime
    for (i in 2 until n) {  // Check divisors from 2 to n-1
        if (n % i == 0) return false
    }
    return true
}
