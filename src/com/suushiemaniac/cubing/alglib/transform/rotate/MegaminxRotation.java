package com.suushiemaniac.cubing.alglib.transform.rotate;

import com.suushiemaniac.cubing.alglib.move.MegaminxMove;
import com.suushiemaniac.cubing.alglib.move.Move;

public enum MegaminxRotation implements Rotation {
    ;

    @Override
    public Move rotate(Move origin) {
        return null;
    }

    @Override
    public Move transform(Move origin) {
        return this.rotate(origin);
    }
}
