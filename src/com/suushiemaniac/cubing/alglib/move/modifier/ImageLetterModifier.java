package com.suushiemaniac.cubing.alglib.move.modifier;

public class ImageLetterModifier implements Modifier {
	public static final ImageLetterModifier INST = new ImageLetterModifier();

	@Override
	public String toFormatString() {
		return "";
	}

	@Override
	public Modifier inverse() {
		return this;
	}

	@Override
	public Modifier merge(Modifier other) {
		return null;
	}

	@Override
	public int hashCode() {
		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		return obj instanceof ImageLetterModifier;
	}
}
