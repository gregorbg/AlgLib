package com.suushiemaniac.cubing.alglib.move.plane;

public enum SkewbPlane implements Plane {
    UP("U"), LEFT("L"), RIGHT("R"), BACK("B");

    public static SkewbPlane fromNotation(String notation) {
        for (SkewbPlane plane : SkewbPlane.values())
            if (plane.getNotation().equals(notation)) return plane;
        return null;
    }

    private String notation;

    SkewbPlane(String notation) {
        this.notation = notation;
    }

    public String getNotation() {
        return this.notation;
    }

    @Override
    public String toFormatString() {
        return this.getNotation();
    }

    @Override
    public boolean isRotation() {
        return false;
    }
}
