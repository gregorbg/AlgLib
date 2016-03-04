import com.suushiemaniac.cubing.alglib.alg.Algorithm;
import com.suushiemaniac.cubing.alglib.lang.CubicAlgorithmReader;
import com.suushiemaniac.cubing.alglib.transform.mirror.CubicMirror;
import com.suushiemaniac.cubing.alglib.transform.rotate.CubicRotation;

public class Main {
    public static void main(String[] args) {
        //Algorithm testAlg = new CubicAlgorithmReader().parse("R U' R' U' R U R' F' R U R' U' R' F R");
        Algorithm testAlg = new CubicAlgorithmReader().parse("x y z");

        System.out.println(testAlg.transform(CubicMirror.M).toFormatString());
        System.out.println(testAlg.transform(CubicMirror.S).toFormatString());
        System.out.println(testAlg.transform(CubicMirror.E).toFormatString());
        System.out.println();
        System.out.println(testAlg.transform(CubicRotation.X_90).toFormatString());
        System.out.println(testAlg.transform(CubicRotation.X_180).toFormatString());
        System.out.println(testAlg.transform(CubicRotation.X_270).toFormatString());
        System.out.println(testAlg.transform(CubicRotation.Y_90).toFormatString());
        System.out.println(testAlg.transform(CubicRotation.Y_180).toFormatString());
        System.out.println(testAlg.transform(CubicRotation.Y_270).toFormatString());
        System.out.println(testAlg.transform(CubicRotation.Z_90).toFormatString());
        System.out.println(testAlg.transform(CubicRotation.Z_180).toFormatString());
        System.out.println(testAlg.transform(CubicRotation.Z_270).toFormatString());
        System.out.println();
        System.out.println(testAlg.transform(CubicRotation.Y_270).transform(CubicMirror.S).toFormatString());
        System.out.println(testAlg.transform(CubicRotation.Y_180).transform(CubicMirror.E).toFormatString());
        System.out.println(testAlg.transform(CubicRotation.Y_180).transform(CubicRotation.X_270).toFormatString());
    }
}
