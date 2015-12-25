package com.suushiemaniac.cubing.alglib.test;

import com.suushiemaniac.cubing.alglib.lang.CubicAlgorithmReader;
import org.junit.Test;

public class CubicNotationTest {
    private CubicAlgorithmReader reader;

    public CubicNotationTest() {
        this.reader = new CubicAlgorithmReader();
    }

    private void testNotation(String notation) {
        assert reader.parse(notation).toFormatString().equals(notation);
    }

    private void testNegNotation(String notation) {
        try {
            assert reader.parse(notation) == null || !reader.parse(notation).toFormatString().equals(notation);
        } catch (NullPointerException e) {
            assert true;
        }
    }

    @Test
    public void testBaseNotation() {
        testNotation("R B D B' L B2 D' F D2 L' U L2 F' R' F2 U' R2 U2");
        testNegNotation("2B'");
    }

    @Test
    public void testWideNotation() {
        testNotation("3Rw2 17Bw' 3Fw");
        testNegNotation("2Dw2");
    }

    @Test
    public void testCentralSliceNotation() {
        testNotation("M E S E' M' E2 S' M2 S2");
        testNegNotation("3M2");
    }

    @Test
    public void testSliceNotation() {
        testNotation("r2 b' 3f2");
        testNegNotation("uw dw'");
    }
}