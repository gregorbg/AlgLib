package com.suushiemaniac.cubing.alglib.move;

import com.suushiemaniac.cubing.alglib.move.modifier.ImageLetterModifier;
import com.suushiemaniac.cubing.alglib.move.modifier.Modifier;
import com.suushiemaniac.cubing.alglib.move.plane.ImageLetterPlane;
import com.suushiemaniac.cubing.alglib.move.plane.Plane;
import com.suushiemaniac.cubing.alglib.transform.Transform;

public class ImageLetterMove implements Move {
	protected ImageLetterPlane plane;

	public ImageLetterMove(ImageLetterPlane plane) {
		this.plane = plane;
	}

	@Override
	public String toFormatString() {
		return this.plane.toFormatString();
	}

	@Override
	public boolean merges(Move other) {
		return false;
	}

	@Override
	public boolean cancels(Move other) {
		return false;
	}

	@Override
	public boolean mayAppend(Move other) {
		return true;
	}

	@Override
	public Plane getPlane() {
		return this.plane;
	}

	@Override
	public Modifier getModifier() {
		return ImageLetterModifier.INST;
	}

	@Override
	public Move merge(Move other) {
		return null;
	}

	@Override
	public int getDepth() {
		return 1;
	}

	@Override
	public Move inverse() {
		return new ImageLetterMove(this.plane);
	}

	@Override
	public Move transform(Transform transform) {
		return transform.transform(this);
	}

	@Override
	public boolean equals(Object obj) {
		return obj instanceof ImageLetterMove
				&& ((ImageLetterMove) obj).plane.equals(this.plane);
	}

	@Override
	public int hashCode() {
		return this.toFormatString().hashCode();
	}
}
