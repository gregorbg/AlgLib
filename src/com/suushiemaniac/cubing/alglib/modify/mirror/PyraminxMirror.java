package com.suushiemaniac.cubing.alglib.modify.mirror;

import com.suushiemaniac.cubing.alglib.move.Move;
import com.suushiemaniac.cubing.alglib.move.PyraminxMove;

public enum PyraminxMirror implements Mirror {
    ;

    @Override
    public Move mirror(Move origin) {
        return null;
    }

    @Override
    public Move modify(Move origin) {
        return this.mirror(origin);
    }

    @Override
    public boolean supportsMoveClass(Move moveInst) {
        return moveInst instanceof PyraminxMove;
    }
}
