// Bubble sort algorithm 
fun bubbleSort(arr: IntArray) {
    val n = arr.size
    for (i in 0 until n) {
        for (j in 0 until n - 1 - i) {
            if (arr[j] > arr[j + 1]) {
                // Swap the elements
                val temp = arr[j]
                arr[j] = arr[j + 1]
                arr[j + 1] = temp
            }
        }
    }
}

fun main() {
    val arr = intArrayOf(5, 3, 8, 4, 2)
    println("Before sorting: ${arr.joinToString(", ")}")
    bubbleSort(arr)
    println("After sorting: ${arr.joinToString(", ")}")
}
