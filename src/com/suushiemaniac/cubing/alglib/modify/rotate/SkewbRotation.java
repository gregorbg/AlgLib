package com.suushiemaniac.cubing.alglib.modify.rotate;

import com.suushiemaniac.cubing.alglib.move.Move;
import com.suushiemaniac.cubing.alglib.move.SkewbMove;

public enum SkewbRotation implements Rotation {
    //TODO
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
        return moveInst instanceof SkewbMove;
    }
}
