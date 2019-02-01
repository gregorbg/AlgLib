import com.suushiemaniac.cubing.alglib.lang.CubicAlgorithmReader
import com.suushiemaniac.cubing.alglib.transform.mirror.CubicMirror

fun main() {
    val reader = CubicAlgorithmReader()
    val alg = reader.parse("[r ; [r , U R U']]")

    println(alg.transform(CubicMirror.M))
}
