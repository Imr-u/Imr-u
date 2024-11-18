// Method 1

fun main() {
    println("Enter a word or phrase:")
    val input = readLine() ?: ""
    println(if (isPalindromeSimple(input)) "Palindrome" else "Not a Palindrome")
}

fun isPalindromeSimple(str: String): Boolean {
    val cleaned = str.replace(Regex("[^A-Za-z0-9]"), "").lowercase()  // Remove non-alphanumeric chars and lowercase
    return cleaned == cleaned.reversed()
}

// Method 2
fun main() {
    println("Enter a word or phrase:")
    val input = readLine() ?: ""
    println(if (isPalindromeTwoPointer(input)) "Palindrome" else "Not a Palindrome")
}

fun isPalindromeTwoPointer(str: String): Boolean {
    val cleaned = str.replace(Regex("[^A-Za-z0-9]"), "").lowercase()
    var left = 0
    var right = cleaned.length - 1

    while (left < right) {
        if (cleaned[left] != cleaned[right]) return false  // Characters don't match
        left++
        right--
    }
    return true  // All characters matched
}

// Method 3
fun main() {
    println("Enter a word or phrase:")
    val input = readLine() ?: ""
    println(if (isPalindromeRecursive(input)) "Palindrome" else "Not a Palindrome")
}

fun isPalindromeRecursive(str: String): Boolean {
    val cleaned = str.replace(Regex("[^A-Za-z0-9]"), "").lowercase()
    return checkPalindromeRecursive(cleaned, 0, cleaned.length - 1)
}

fun checkPalindromeRecursive(str: String, left: Int, right: Int): Boolean {
    if (left >= right) return true  // Base case: pointers have met or crossed
    if (str[left] != str[right]) return false  // Characters don't match
    return checkPalindromeRecursive(str, left + 1, right - 1)  // Move pointers inward
}

// Method 4
fun main() {
    println("Enter a word or phrase:")
    val input = readLine() ?: ""
    println(if (isPalindromeFunctional(input)) "Palindrome" else "Not a Palindrome")
}

fun isPalindromeFunctional(str: String): Boolean {
    val cleaned = str.replace(Regex("[^A-Za-z0-9]"), "").lowercase()
    return cleaned.asSequence()
        .zip(cleaned.reversed().asSequence())  // Pair each char with its counterpart in reversed
        .all { it.first == it.second }  // Check if all pairs are equal
}
