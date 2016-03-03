package com.suushiemaniac.cubing.alglib.transform.mirror;

import com.suushiemaniac.cubing.alglib.move.Move;

public enum SquareOneMirror implements Mirror {
    ;

    @Override
    public Move mirror(Move origin) {
        return null;
    }

    @Override
    public Move transform(Move origin) {
        return this.mirror(origin);
    }
}
