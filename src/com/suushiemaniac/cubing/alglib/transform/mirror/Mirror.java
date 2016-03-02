package com.suushiemaniac.cubing.alglib.transform.mirror;

import com.suushiemaniac.cubing.alglib.transform.Transform;
import com.suushiemaniac.cubing.alglib.move.Move;

public interface Mirror extends Transform {
    Move mirror(Move origin);
}
