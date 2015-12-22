package com.suushiemaniac.cubing.alglib.util;

import com.suushiemaniac.cubing.alglib.alg.Algorithm;
import com.suushiemaniac.cubing.alglib.move.plane.CubicPlane;
import com.suushiemaniac.cubing.alglib.move.plane.Plane;

import java.util.ArrayList;

public class SubGroup implements StringFormat {
    public static SubGroup fromAlg(Algorithm alg) {
        Plane[] algPlanes = new Plane[alg.allMoves().length];
        for (int i = 0; i < alg.allMoves().length; i++)
            algPlanes[i] = alg.nMove(i).getPlane();
        return new SubGroup(algPlanes);
    }

    public static SubGroup fromCubicAlgString(String alg) {
        String[] parts = alg.replace("<", "").replace(">", "").split(",");
        Plane[] algPlanes = new Plane[parts.length];
        for (int i = 0; i < parts.length; i++)
            algPlanes[i] = CubicPlane.fromNotation(parts[i]);
        return new SubGroup(algPlanes);
    }

    private ArrayList<Plane> groupList;

    public SubGroup(Plane... planes) {
        this.groupList = new ArrayList<>();
        for (Plane p : planes)
            if (this.groupList.contains(p))
                this.groupList.add(p);
    }

    private String[] getElementsAsString() {
        String[] elements = new String[this.groupList.size()];
        for (int i = 0; i < elements.length; i++) elements[i] = this.groupList.get(i).toFormatString();
        return elements;
    }

    @Override
    public String toFormatString() {
        String groupString = "<";
        groupString += StringUtils.join(",", this.getElementsAsString());
        return groupString + ">";
    }

    public boolean sameSubGroup(SubGroup other) {
        return this.size() == other.size() && this.containsAll(other);
    }

    public int size() {
        return this.groupList.size();
    }

    public boolean containsAll(SubGroup other) {
        return this.groupList.containsAll(other.groupList);
    }
}