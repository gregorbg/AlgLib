package com.suushiemaniac.cubing.alglib.transform.rotate;

import com.suushiemaniac.cubing.alglib.move.CubicMove;
import com.suushiemaniac.cubing.alglib.move.Move;
import com.suushiemaniac.cubing.alglib.move.modifier.CubicModifier;
import com.suushiemaniac.cubing.alglib.move.plane.CubicPlane;
import com.suushiemaniac.cubing.alglib.util.ArrayUtils;

import static com.suushiemaniac.cubing.alglib.move.plane.CubicPlane.*;

public enum CubicRotation implements Rotation {
    Y_90, X_90, Z_90, Y_180, X_180, Z_180, Y_270, X_270, Z_270;

    private static CubicPlane[][][] rotOrder = {
            {{RIGHT, FRONT, LEFT, BACK}, {RIGHT_SLICE, FRONT_SLICE, LEFT_SLICE, BACK_SLICE}, {MIDDLE, SANDWICH}, {SPATIAL, HORIZONTAL}},
            {{UP, BACK, DOWN, FRONT}, {UP_SLICE, BACK_SLICE, DOWN_SLICE, FRONT_SLICE}, {SANDWICH, EQUATOR}, {VERTICAL, SPATIAL}},
            {{RIGHT, DOWN, LEFT, UP}, {RIGHT_SLICE, DOWN_SLICE, LEFT_SLICE, UP_SLICE}, {MIDDLE, EQUATOR}, {HORIZONTAL, VERTICAL}}
    };

    @Override
    public Move rotate(Move origin) {
        if (!(origin instanceof CubicMove)) return null;
        else {
            int rotBaseOrdinal = this.ordinal() % 3;
            int rotAmountOrdinal = this.ordinal() / 3;

            CubicMove cOrigin = (CubicMove) origin;

            CubicPlane cPlane = cOrigin.getPlane();
            int ordinal = cPlane.ordinal();
            int base = ordinal < 6 ? 0 : ordinal < 12 ? 6 : ordinal < 15 ? 12 : 15;
            int size = base < 12 ? 6 : 3;
            boolean isPlaneAffected = rotBaseOrdinal != (ordinal - base) / (size / 3);

            int typeBase = ordinal < 6 ? 0 : ordinal < 12 ? 1 : ordinal < 15 ? 2 : 3;
            int rotIndex = isPlaneAffected ? ArrayUtils.arrayIndex(rotOrder[rotBaseOrdinal][typeBase], cPlane) : 0;
            int modLen = (size / 3) * 2;
            int fullIndex = (rotIndex + rotAmountOrdinal + 1) % modLen;
            CubicPlane plane = isPlaneAffected ? rotOrder[rotBaseOrdinal][typeBase][fullIndex] : cPlane;

            CubicModifier modifier = cOrigin.getModifier();
            for (int i = 0; i <= rotAmountOrdinal; i++)
                if (isPlaneAffected && modLen == 2 && (++rotIndex % 2) % 2 == 1)
                    modifier = modifier.inverse();

            return new CubicMove(plane, modifier, cOrigin.getDepth());
        }
    }

    @Override
    public Move transform(Move origin) {
        return this.rotate(origin);
    }
}
