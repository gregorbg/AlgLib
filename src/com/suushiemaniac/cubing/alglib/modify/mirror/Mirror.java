package com.suushiemaniac.cubing.alglib.modify.mirror;

import com.suushiemaniac.cubing.alglib.modify.Modifier;
import com.suushiemaniac.cubing.alglib.move.Move;

public interface Mirror extends Modifier {
    Move mirror(Move origin);
}
