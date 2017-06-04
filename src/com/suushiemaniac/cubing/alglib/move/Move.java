package com.suushiemaniac.cubing.alglib.move;

import com.suushiemaniac.cubing.alglib.move.modifier.Modifier;
import com.suushiemaniac.cubing.alglib.move.plane.Plane;
import com.suushiemaniac.cubing.alglib.transform.Transform;
import com.suushiemaniac.cubing.alglib.util.StringFormat;

public interface Move extends StringFormat {
    boolean merges(Move other);

    boolean cancels(Move other);

    boolean mayAppend(Move other);

    Plane getPlane();

    Modifier getModifier();

    Move merge(Move other);

    int getDepth();

    Move inverse();

    Move transform(Transform transform);

    boolean equals(Object other);

    int hashCode();
}
