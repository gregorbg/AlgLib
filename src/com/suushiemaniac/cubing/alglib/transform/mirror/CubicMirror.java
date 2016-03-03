package com.suushiemaniac.cubing.alglib.transform.mirror;

import com.suushiemaniac.cubing.alglib.move.CubicMove;
import com.suushiemaniac.cubing.alglib.move.Move;

public enum CubicMirror implements Mirror {
    MIRROR_M, MIRROR_S, MIRROR_E;

    @Override
    public Move mirror(Move origin) {
        if (!(origin instanceof CubicMove)) return origin;
        else {
            CubicMove cOrigin = (CubicMove) origin;
            return cOrigin;
        }
    }

    @Override
    public Move transform(Move origin) {
        return this.mirror(origin);
    }
}
