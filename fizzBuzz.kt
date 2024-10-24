// Method 1
fun main() {
    for (i in 1..100) {  // Loop through numbers from 1 to 100
        when {
            i % 3 == 0 && i % 5 == 0 -> println("FizzBuzz")  // Divisible by both 3 and 5
            i % 3 == 0 -> println("Fizz")  // Divisible by 3
            i % 5 == 0 -> println("Buzz")  // Divisible by 5
            else -> println(i)  // If not divisible by either, print the number
        }
    }
}

// Method 2
fun main() {
    for (i in 1..100) {
        if (i % 3 == 0 && i % 5 == 0) {
            println("FizzBuzz")
        } else if (i % 3 == 0) {
            println("Fizz")
        } else if (i % 5 == 0) {
            println("Buzz")
        } else {
            println(i)
        }
    }
}

// Method 3
fun main() {
    for (i in 1..100) {
        var output = ""
        if (i % 3 == 0) output += "Fizz"
        if (i % 5 == 0) output += "Buzz"
        if (output.isEmpty()) output = i.toString()
        println(output)
    }
}

        }
    }
}

// Method 4
fun main() {
    (1..100).map { i ->
        when {
            i % 3 == 0 && i % 5 == 0 -> "FizzBuzz"
            i % 3 == 0 -> "Fizz"
            i % 5 == 0 -> "Buzz"
            else -> i.toString()
        }
    }.forEach { println(it) }
}

// Method 5
fun fizzBuzzRecursive(n: Int) {
    if (n > 100) return
    when {
        n % 3 == 0 && n % 5 == 0 -> println("FizzBuzz")
        n % 3 == 0 -> println("Fizz")
        n % 5 == 0 -> println("Buzz")
        else -> println(n)
    }
    fizzBuzzRecursive(n + 1)
}

fun main() {
    fizzBuzzRecursive(1)
}



// Method 6
fun main() {
    generateSequence(1) { it + 1 }
        .take(100)
        .map { i ->
            when {
                i % 3 == 0 && i % 5 == 0 -> "FizzBuzz"
                i % 3 == 0 -> "Fizz"
                i % 5 == 0 -> "Buzz"
                else -> i.toString()
            }
        }
        .forEach { println(it) }
}

// Method 7
fun main() {
    println("Enter start of range:")
    val start = readLine()?.toIntOrNull() ?: return
    println("Enter end of range:")
    val end = readLine()?.toIntOrNull() ?: return

    for (i in start..end) {
        when {
            i % 3 == 0 && i % 5 == 0 -> println("FizzBuzz")
            i % 3 == 0 -> println("Fizz")
            i % 5 == 0 -> println("Buzz")
            else -> println(i)
        }
    }
}

// Method 8
fun main() {
    (1..100).forEach { i -> println(when {
        i % 3 == 0 && i % 5 == 0 -> "FizzBuzz"
        i % 3 == 0 -> "Fizz"
        i % 5 == 0 -> "Buzz"
        else -> i.toString()
    }) }
}

// Method 9
class FizzBuzz {
    fun checkNumber(n: Int): String {
        return when {
            n % 3 == 0 && n % 5 == 0 -> "FizzBuzz"
            n % 3 == 0 -> "Fizz"
            n % 5 == 0 -> "Buzz"
            else -> n.toString()
        }
    }

    fun run(range: IntRange) {
        for (i in range) {
            println(checkNumber(i))
        }
    }
}

fun main() {
    val fizzBuzz = FizzBuzz()
    fizzBuzz.run(1..100)
}


