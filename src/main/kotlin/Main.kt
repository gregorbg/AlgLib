import com.suushiemaniac.cubing.alglib.lang.CubicAlgorithmReader
import com.suushiemaniac.cubing.alglib.move.plane.CubicPlane
import com.suushiemaniac.cubing.alglib.transform.mirror.AxisCubicMirror
import com.suushiemaniac.cubing.alglib.transform.mirror.CubicMirror
import com.suushiemaniac.cubing.alglib.transform.rotate.AxisCubicRotation

fun main() {
    val reader = CubicAlgorithmReader()
    val alg = reader.parse("[r ; [r , U R U']]")

    println(alg)
    println(alg.transform(AxisCubicRotation.Z_270))
}
