package com.suushiemaniac.cubing.alglib.test;

import com.suushiemaniac.cubing.alglib.alg.Algorithm;
import com.suushiemaniac.cubing.alglib.alg.SimpleAlg;
import com.suushiemaniac.cubing.alglib.alg.commutator.PureComm;
import com.suushiemaniac.cubing.alglib.move.CubicMove;
import com.suushiemaniac.cubing.alglib.move.modifier.CubicModifier;
import com.suushiemaniac.cubing.alglib.move.plane.CubicPlane;
import com.suushiemaniac.cubing.alglib.util.SubGroup;
import org.junit.Test;

public class SubGroupTest {
    private Algorithm testAlg = new PureComm(new SimpleAlg(new CubicMove[]{new CubicMove(CubicPlane.MIDDLE, CubicModifier.CCW, 1), new CubicMove(CubicPlane.UP, CubicModifier.DOUBLE, 1), new CubicMove(CubicPlane.MIDDLE, CubicModifier.CW, 1)}), new SimpleAlg(new CubicMove[]{new CubicMove(CubicPlane.DOWN, CubicModifier.CCW, 1)}));
    private SubGroup testSubGroup = new SubGroup(CubicPlane.MIDDLE, CubicPlane.UP, CubicPlane.DOWN);

    @Test
    public void testParseFromString() {
        assert SubGroup.fromCubicGroupString("<M,U,D>").sameSubGroup(testSubGroup);
    }

    @Test
    public void testParseFromAlg() {
        assert testAlg.getSubGroup().sameSubGroup(testSubGroup);
    }

    @Test
    public void testStringPrint() {
        assert testSubGroup.toFormatString().equals("<M,U,D>");
    }

    @Test
    public void testEquality() {
        assert SubGroup.fromCubicGroupString("<M,U,D>").sameSubGroup(SubGroup.fromCubicGroupString("<U,D,M>"));
        assert !SubGroup.fromCubicGroupString("<M,U,D>").sameSubGroup(SubGroup.fromCubicGroupString("<M,U,R,D>"));
    }
}
