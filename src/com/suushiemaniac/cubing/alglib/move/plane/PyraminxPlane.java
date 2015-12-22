package com.suushiemaniac.cubing.alglib.move.plane;

public enum PyraminxPlane implements Plane {
    UP("U"), LEFT("L"), RIGHT("R"), BACK("B");

    public static PyraminxPlane fromNotation(String notation) {
        for (PyraminxPlane plane : PyraminxPlane.values())
            if (plane.getNotation().equals(notation)) return plane;
        return null;
    }

    private String notation;

    PyraminxPlane(String notation) {
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
