package com.suushiemaniac.cubing.alglib.transform.rotate;

import com.suushiemaniac.cubing.alglib.move.Move;

public enum PyraminxRotation implements Rotation {
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
