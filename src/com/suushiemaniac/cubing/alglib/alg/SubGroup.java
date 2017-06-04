package com.suushiemaniac.cubing.alglib.alg;

import com.suushiemaniac.cubing.alglib.move.plane.CubicPlane;
import com.suushiemaniac.cubing.alglib.move.plane.Plane;
import com.suushiemaniac.cubing.alglib.util.FixArrayComparator;
import com.suushiemaniac.cubing.alglib.util.StringFormat;

import java.util.ArrayList;

public class SubGroup implements StringFormat {
    public static SubGroup fromAlg(Algorithm alg, boolean rotations) {
        Plane[] algPlanes = new Plane[alg.allMoves().size()];
        for (int i = 0; i < alg.allMoves().size(); i++)
            if (alg.nMove(i).getPlane().isRotation() == rotations)
                algPlanes[i] = alg.nMove(i).getPlane();
        return new SubGroup(algPlanes);
    }

    public static SubGroup fromCubicGroupString(String alg) {
        String[] parts = alg.replace("<", "").replace(">", "").split(",");
        CubicPlane[] algPlanes = new CubicPlane[parts.length];
        for (int i = 0; i < parts.length; i++)
            algPlanes[i] = CubicPlane.fromNotation(parts[i]);
        return new SubGroup(algPlanes);
    }

    private ArrayList<Plane> groupList;

    public SubGroup(Plane... planes) {
        this.groupList = new ArrayList<>();

        for (Plane p : planes) {
            if (p == null) {
                continue;
            }

            if (!this.groupList.contains(p)) {
                this.groupList.add(p);
            }
        }
        CubicPlane[] orderedPlanes = {CubicPlane.HORIZONTAL, CubicPlane.VERTICAL, CubicPlane.SPATIAL, CubicPlane.MIDDLE, CubicPlane.SANDWICH, CubicPlane.EQUATOR, CubicPlane.LEFT, CubicPlane.RIGHT, CubicPlane.UP, CubicPlane.DOWN, CubicPlane.FRONT, CubicPlane.BACK};
        this.groupList.sort(new FixArrayComparator<>(orderedPlanes));
    }

    private String[] getElementsAsString() {
        String[] elements = new String[this.groupList.size()];
        for (int i = 0; i < elements.length; i++) elements[i] = this.groupList.get(i).toFormatString();
        return elements;
    }

    @Override
    public String toString() {
        return this.toFormatString();
    }

    @Override
    public String toFormatString() {
        String groupString = "<";
        groupString += String.join(",", this.getElementsAsString());
        return groupString + ">";
    }

    public String toRawString() {
        return String.join("", this.getElementsAsString());
    }

    public boolean sameSubGroup(SubGroup other) {
        return this.size() == other.size() && this.containsAll(other) && other.containsAll(this);
    }

    public boolean smallerSubGroup(SubGroup other) {
        return this.size() < other.size() && other.containsAll(this);
    }

    public boolean sameOrSmallerSubGroup(SubGroup other) {
        return this.sameSubGroup(other) || this.smallerSubGroup(other);
    }

    public boolean largerSubGroup(SubGroup other) {
        return this.size() > other.size() && this.containsAll(other);
    }

    public boolean sameOrLargerSubGroup(SubGroup other) {
        return this.sameSubGroup(other) || this.largerSubGroup(other);
    }

    public int size() {
        return this.groupList.size();
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }

    public boolean containsAll(SubGroup other) {
        return this.groupList.containsAll(other.groupList);
    }

    @Override
    public int hashCode() {
        return this.toRawString().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof SubGroup && ((SubGroup) obj).sameSubGroup(this);
    }
}