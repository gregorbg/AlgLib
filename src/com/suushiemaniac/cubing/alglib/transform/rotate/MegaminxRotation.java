package com.suushiemaniac.cubing.alglib.transform.rotate;

import com.suushiemaniac.cubing.alglib.move.MegaminxMove;
import com.suushiemaniac.cubing.alglib.move.Move;

public enum MegaminxRotation implements Rotation {
    ;

    @Override
    public MegaminxMove rotate(Move origin) {
        return origin instanceof MegaminxMove ? (MegaminxMove) origin : null;
    }

    @Override
    public MegaminxMove transform(Move origin) {
        return this.rotate(origin);
    }
}
