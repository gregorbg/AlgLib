import com.suushiemaniac.cubing.alglib.alg.Algorithm;
import com.suushiemaniac.cubing.alglib.lang.CubicAlgorithmReader;
import com.suushiemaniac.cubing.alglib.transform.mirror.CubicMirror;

public class Main {
    public static void main(String[] args) {
        Algorithm testAlg = new CubicAlgorithmReader().parse("U D L R F B x y z M S E");
        System.out.println(testAlg.transform(CubicMirror.MIRROR_M).toFormatString());
        System.out.println(testAlg.transform(CubicMirror.MIRROR_S).toFormatString());
        System.out.println(testAlg.transform(CubicMirror.MIRROR_E).toFormatString());
    }
}
