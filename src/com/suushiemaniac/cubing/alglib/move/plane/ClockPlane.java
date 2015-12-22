package com.suushiemaniac.cubing.alglib.move.plane;

public enum ClockPlane implements Plane {
    UP("U"), UP_RIGHT("UR"), UP_LEFT("UL"), RIGHT("R"), DOWN("D"), DOWN_LEFT("DL"), DOWN_RIGHT("DR"), LEFT("L"), ALL("ALL"), VERTICAL("y");

    public static ClockPlane fromNotation(String notation) {
        for (ClockPlane plane : ClockPlane.values())
            if (plane.getNotation().equals(notation)) return plane;
        return null;
    }

    private String notation;

    ClockPlane(String notation) {
        this.notation = notation;
    }

    public String getNotation() {
        return notation;
    }

    @Override
    public String toFormatString() {
        return this.getNotation();
    }

    @Override
    public boolean isRotation() {
        return this == VERTICAL;
    }
}
