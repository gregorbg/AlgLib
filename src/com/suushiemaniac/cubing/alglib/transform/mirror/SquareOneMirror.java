package com.suushiemaniac.cubing.alglib.transform.mirror;

import com.suushiemaniac.cubing.alglib.move.Move;
import com.suushiemaniac.cubing.alglib.move.SquareOneMove;

public class SquareOneMirror implements Mirror {
    @Override
    public Move mirror(Move origin) {
        return null;
    }

    @Override
    public Move transform(Move origin) {
        return this.mirror(origin);
    }

    @Override
    public boolean supportsMoveClass(Move moveInst) {
        return moveInst instanceof SquareOneMove;
    }
}
