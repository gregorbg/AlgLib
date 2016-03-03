package com.suushiemaniac.cubing.alglib.transform.mirror;

import com.suushiemaniac.cubing.alglib.move.CubicMove;
import com.suushiemaniac.cubing.alglib.move.Move;
import com.suushiemaniac.cubing.alglib.move.modifier.CubicModifier;
import com.suushiemaniac.cubing.alglib.move.plane.CubicPlane;

public enum CubicMirror implements Mirror {
    MIRROR_E, MIRROR_M, MIRROR_S;

    @Override
    public CubicMove mirror(Move origin) {
        if (!(origin instanceof CubicMove)) return null;
        else {
            CubicMove cOrigin = (CubicMove) origin;
            return cOrigin;
        }
    }

    @Override
    public CubicMove transform(Move origin) {
        return this.mirror(origin);
    }
}
