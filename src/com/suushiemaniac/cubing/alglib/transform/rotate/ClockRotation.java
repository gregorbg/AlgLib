package com.suushiemaniac.cubing.alglib.transform.rotate;

import com.suushiemaniac.cubing.alglib.move.ClockMove;
import com.suushiemaniac.cubing.alglib.move.Move;

public enum ClockRotation implements Rotation {
    X_180, Y_180, Z_90, Z_180, Z_270;

    public Move rotate(Move origin) {
        return null;
    }

    public Move modify(Move origin) {
        return this.rotate(origin);
    }

    @Override
    public boolean supportsMoveClass(Move moveInst) {
        return moveInst instanceof ClockMove;
    }
}
