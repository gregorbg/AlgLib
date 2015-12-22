package com.suushiemaniac.cubing.alglib.move.modifier;

import com.suushiemaniac.cubing.alglib.util.StringFormat;

public interface Modifier extends StringFormat {
    Modifier inverse();

    Modifier merge(Modifier other);
}
