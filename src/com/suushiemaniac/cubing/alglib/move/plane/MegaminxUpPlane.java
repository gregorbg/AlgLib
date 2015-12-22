package com.suushiemaniac.cubing.alglib.move.plane;

public enum MegaminxUpPlane implements MegaminxPlane {
    UP("U");

    public static MegaminxUpPlane fromNotation(String notation) {
        for (MegaminxUpPlane plane : MegaminxUpPlane.values())
            if (plane.getNotation().equals(notation)) return plane;
        return null;
    }

    private String notation;

    MegaminxUpPlane(String notation) {
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
        return "UP";
    }
}
