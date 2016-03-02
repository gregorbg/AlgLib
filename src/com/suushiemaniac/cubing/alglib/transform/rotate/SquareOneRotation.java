package com.suushiemaniac.cubing.alglib.transform.rotate;

import com.suushiemaniac.cubing.alglib.move.Move;
import com.suushiemaniac.cubing.alglib.move.SquareOneMove;

public enum SquareOneRotation implements Rotation {
    ;

    @Override
    public Move rotate(Move origin) {
        return null;
    }

    @Override
    public Move modify(Move origin) {
        return this.rotate(origin);
    }

    @Override
    public boolean supportsMoveClass(Move moveInst) {
        return moveInst instanceof SquareOneMove;
    }
}
