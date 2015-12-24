package com.suushiemaniac.cubing.alglib.test;

import com.suushiemaniac.cubing.alglib.lang.CubicAlgorithmReader;
import org.junit.Test;

public class CubicNotationTest {
    private CubicAlgorithmReader reader = new CubicAlgorithmReader();

    private void testNotation(String notation) {
        assert reader.parse(notation).toFormatString().equals(notation);
    }

    @Test
    public void testBaseNotation() {
        testNotation("R U2 R' D2 F B L'");
    }

    @Test
    public void testWideNotation() {
        testNotation("3Rw2 17Bw' 3Fw");
    }
}