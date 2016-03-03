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

            CubicPlane cPlane = cOrigin.getPlane();
            int ordinal = cPlane.ordinal();
            int base = ordinal < 6 ? 0 : ordinal < 12 ? 6 : ordinal < 15 ? 12 : 15;
            int size = base < 12 ? 6 : 3;
            boolean isPlaneAffected = this.ordinal() == (ordinal - base) / (size / 3);

            int offset = isPlaneAffected ? size / 6 : 0;
            int inTuple = ordinal % (size / 3);
            int planeIndex = ((inTuple + offset) % (size / 3)) + ordinal - inTuple;
            CubicPlane plane = CubicPlane.values()[planeIndex];

            boolean isModifierAffected = size == 6 || this.ordinal() != (ordinal - base) / (size / 3);
            CubicModifier modifier = cOrigin.getModifier();
            if (isModifierAffected) modifier = modifier.inverse();

            return new CubicMove(plane, modifier, cOrigin.getDepth());
        }
    }

    @Override
    public CubicMove transform(Move origin) {
        return this.mirror(origin);
    }
}
