package com.suushiemaniac.cubing.alglib.alg.commutator;

import com.suushiemaniac.cubing.alglib.alg.Algorithm;

public interface Commutator extends Algorithm {
    String toPlainString();

    int cancelationLength();

    Algorithm develop();

    Commutator inverse();

    boolean cancels();
}
