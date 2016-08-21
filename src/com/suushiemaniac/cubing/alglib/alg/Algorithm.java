package com.suushiemaniac.cubing.alglib.alg;

import com.suushiemaniac.cubing.alglib.move.Move;
import com.suushiemaniac.cubing.alglib.transform.Transform;
import com.suushiemaniac.cubing.alglib.util.StringFormat;

import java.util.List;

public interface Algorithm extends StringFormat, Iterable<Move> {
    Algorithm inverse();

    Algorithm plain();

    int moveLength();

    int algLength();

    int cancelationLength(Algorithm other);

    Algorithm merge(Algorithm other);

    Algorithm append(Move other);

    Algorithm transform(Transform transform);

    Move nMove(int n);

    Move firstMove();

    Move lastMove();

    List<Move> allMoves();

    Algorithm subAlg(int from, int to);

    SubGroup getSubGroup();
}
