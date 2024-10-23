// Multiple ways of solving the problem whether a number is even or odd
// Method 1

fun main() {
    println("Enter a number:")
    val number = readLine()?.toIntOrNull() ?: return

    if (number % 2 == 0) {
        println("The number $number is even.")
    } else {
        println("The number $number is odd.")
    }
}

// Method 2

fun main() {
    println("Enter a number:")
    val number = readLine()?.toIntOrNull() ?: return

    if (number and 1 == 0) {  // Bitwise AND with 1
        println("The number $number is even.")
    } else {
        println("The number $number is odd.")
    }
}

//Method 3

fun main() {
    println("Enter a number:")
    val number = readLine()?.toIntOrNull() ?: return

    val dividedByTwo = number / 2
    val multipliedBack = dividedByTwo * 2

    if (multipliedBack == number) {
        println("The number $number is even.")
    } else {
        println("The number $number is odd.")
    }
}


//Method 4

fun isEvenRecursive(number: Int): Boolean {
    return when {
        number == 0 -> true
        number == 1 -> false
        else -> isEvenRecursive(number - 2)  // Keep subtracting 2 recursively
    }
}

fun main() {
    println("Enter a number:")
    val number = readLine()?.toIntOrNull() ?: return

    if (isEvenRecursive(number)) {
        println("The number $number is even.")
    } else {
        println("The number $number is odd.")
    }
}


//Method 5

fun main() {
    println("Enter a number:")
    val number = readLine()?.toIntOrNull() ?: return

    val evenNumbers = (0..100).filter { it % 2 == 0 }  // List of even numbers from 0 to 100

    if (number in evenNumbers) {
        println("The number $number is even.")
    } else {
        println("The number $number is odd.")
    }
}

//Method 6

fun main() {
    println("Enter a number:")
    val number = readLine()?.toIntOrNull() ?: return

    val lastDigit = number.toString().last()

    if (lastDigit in listOf('0', '2', '4', '6', '8')) {
        println("The number $number is even.")
    } else {
        println("The number $number is odd.")
    }
}

