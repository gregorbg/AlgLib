package com.suushiemaniac.cubing.alglib.modify.rotate;

import com.suushiemaniac.cubing.alglib.move.CubicMove;
import com.suushiemaniac.cubing.alglib.move.Move;

public enum CubicRotation implements Rotation {
    X, Y, Z;

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
        return moveInst instanceof CubicMove;
    }
}
