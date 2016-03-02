package com.suushiemaniac.cubing.alglib.transform;

import com.suushiemaniac.cubing.alglib.move.Move;

public interface Transform {
    Move transform(Move origin);

    boolean supportsMoveClass(Move moveInst);
}
