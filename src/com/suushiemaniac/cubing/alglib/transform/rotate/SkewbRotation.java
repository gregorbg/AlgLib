package com.suushiemaniac.cubing.alglib.transform.rotate;

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
    public Move transform(Move origin) {
        return this.rotate(origin);
    }
}
