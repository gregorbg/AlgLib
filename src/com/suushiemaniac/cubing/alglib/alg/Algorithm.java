package com.suushiemaniac.cubing.alglib.alg;

import com.suushiemaniac.cubing.alglib.move.Move;
import com.suushiemaniac.cubing.alglib.util.StringFormat;
import com.suushiemaniac.cubing.alglib.util.SubGroup;

import java.util.List;

public interface Algorithm extends StringFormat {
    Algorithm inverse();

    Algorithm plain();

    int length();

    int cancelationLength(Algorithm other);

    Algorithm merge(Algorithm other);

    Algorithm append(Move other);

    Move nMove(int n);

    Move firstMove();

    Move lastMove();

    List<Move> allMoves();

    Algorithm subAlg(int from, int to);

    SubGroup getSubGroup();
}
