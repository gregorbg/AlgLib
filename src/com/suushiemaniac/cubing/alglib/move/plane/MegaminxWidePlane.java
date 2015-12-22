package com.suushiemaniac.cubing.alglib.move.plane;

public enum MegaminxWidePlane implements MegaminxPlane {
    RIGHT("R"), DOWN("D");

    public static MegaminxWidePlane fromNotation(String notation) {
        for (MegaminxWidePlane plane : MegaminxWidePlane.values())
            if (plane.getNotation().equals(notation)) return plane;
        return null;
    }

    private String notation;

    MegaminxWidePlane(String notation) {
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

    @Override
    public String getType() {
        return "WIDE";
    }
}
