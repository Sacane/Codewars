class KtSolver {

    fun multiplicationTable(size: Int): Array<IntArray> {
        return Array(size) {i -> IntArray(size) {j -> (i+1) * (j+1)} }
    }
}