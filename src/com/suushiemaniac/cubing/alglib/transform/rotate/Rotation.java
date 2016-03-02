package com.suushiemaniac.cubing.alglib.transform.rotate;

import com.suushiemaniac.cubing.alglib.transform.Transform;
import com.suushiemaniac.cubing.alglib.move.Move;

public interface Rotation extends Transform {
    Move rotate(Move origin);
}
