package com.suushiemaniac.cubing.alglib.transform.mirror;

import com.suushiemaniac.cubing.alglib.move.CubicMove;
import com.suushiemaniac.cubing.alglib.move.Move;

public enum CubicMirror implements Mirror {
    ;

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
        return moveInst instanceof CubicMove;
    }
}
