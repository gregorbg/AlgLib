package com.suushiemaniac.cubing.alglib.transform.rotate;

import com.suushiemaniac.cubing.alglib.move.Move;

public enum ClockRotation implements Rotation {
    ;

    public Move rotate(Move origin) {
        return null;
    }

    public Move transform(Move origin) {
        return this.rotate(origin);
    }
}