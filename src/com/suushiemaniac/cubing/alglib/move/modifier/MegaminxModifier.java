package com.suushiemaniac.cubing.alglib.move.modifier;

public interface MegaminxModifier extends Modifier {
    @Override
    MegaminxModifier inverse();

    @Override
    MegaminxModifier merge(Modifier other);

    String getType();
}
