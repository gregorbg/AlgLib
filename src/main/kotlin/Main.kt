import com.suushiemaniac.cubing.alglib.lang.CubicAlgorithmReader

fun main(vararg args: String) {
    val reader = CubicAlgorithmReader()

    val alg = reader.parse("[D' R2 U': [U2, R D R']]")
    val otherAlg = reader.parse("[D' R2 U: [R D R', U2]]")

    val ls = listOf(alg, otherAlg)

    println(ls)
}
