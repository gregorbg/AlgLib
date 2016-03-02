package com.suushiemaniac.cubing.alglib.modify.rotate;

import com.suushiemaniac.cubing.alglib.modify.Modifier;
import com.suushiemaniac.cubing.alglib.move.Move;

public interface Rotation extends Modifier {
    Move rotate(Move origin);
}
