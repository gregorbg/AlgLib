package com.suushiemaniac.cubing.alglib.transform.mirror;

import com.suushiemaniac.cubing.alglib.move.MegaminxMove;
import com.suushiemaniac.cubing.alglib.move.Move;

public enum MegaminxMirror implements Mirror {
    R_GRIP_AXIS;

    @Override
    public MegaminxMove mirror(Move origin) {
        if (!(origin instanceof MegaminxMove)) return null;
        else return ((MegaminxMove) origin).inverse();
    }

    @Override
    public MegaminxMove transform(Move origin) {
        return this.mirror(origin);
    }
}