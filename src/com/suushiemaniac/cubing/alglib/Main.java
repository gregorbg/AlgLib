package com.suushiemaniac.cubing.alglib;

import com.suushiemaniac.cubing.alglib.alg.commutator.Commutator;
import com.suushiemaniac.cubing.alglib.lang.CubicAlgorithmReader;

public class Main {
    public static void main(String[] args) {
        Commutator comm = (Commutator) new CubicAlgorithmReader().parse("[U2 : [U R U' R' , R F2 R']]");
        System.out.println(comm.develop().toFormatString());
    }
}
