package com.suushiemaniac.cubing.alglib.modify;

import com.suushiemaniac.cubing.alglib.move.Move;

public interface Modifier {
    Move modify(Move origin);

    boolean supportsMoveClass(Move moveInst);
}
