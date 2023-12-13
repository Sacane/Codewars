package kt

fun solve(sentence: String): String {
    return sentence.split(" ").joinToString(" ") {
        when {
            it.length >= 5 -> it.reversed()
            else -> it
        }
    }
}


fun main(){
    println(solve("Hey fellow warriors"))
}