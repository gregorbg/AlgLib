package com.suushiemaniac.cubing.alglib.transform.rotate;

import com.suushiemaniac.cubing.alglib.move.Move;
import com.suushiemaniac.cubing.alglib.move.PyraminxMove;

public enum PyraminxRotation implements Rotation {
    AXIS_F, AXIS_D, AXIS_L, AXIS_R;

    @Override
    public Move rotate(Move origin) {
        return null;
    }

    @Override
    public Move transform(Move origin) {
        return this.rotate(origin);
    }
}
