package com.suushiemaniac.cubing.alglib.move.plane;

public class ImageLetterPlane implements Plane {
	protected char letter;

	public ImageLetterPlane(char letter) {
		this.letter = letter;
	}

	@Override
	public String toFormatString() {
		return String.valueOf(this.letter);
	}

	@Override
	public boolean isRotation() {
		return false;
	}

	@Override
	public int hashCode() {
		return (int) this.letter;
	}

	@Override
	public boolean equals(Object obj) {
		return obj instanceof ImageLetterPlane
				&& ((ImageLetterPlane) obj).letter == this.letter;
	}
}
