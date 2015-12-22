package com.suushiemaniac.cubing.alglib.alg;

import com.suushiemaniac.cubing.alglib.move.Move;
import com.suushiemaniac.cubing.alglib.util.StringFormat;

public interface Algorithm extends StringFormat {
    Algorithm inverse();

    int length();

    int cancelationLength(Algorithm other);

    Algorithm merge(Algorithm other);

    Algorithm append(Move other);

    Move nMove(int n);

    Move firstMove();

    Move lastMove();

    Move[] allMoves();

    Move[] subAlg(int from, int to);

    Algorithm reduce();
}
