package com.suushiemaniac.cubing.alglib.alg;

import com.suushiemaniac.cubing.alglib.move.plane.CubicPlane;
import com.suushiemaniac.cubing.alglib.util.ArrayUtils;
import com.suushiemaniac.cubing.alglib.util.StringFormat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class SubGroup implements StringFormat {
    public class GroupComparator implements Comparator<CubicPlane> {
        @Override
        public int compare(CubicPlane o1, CubicPlane o2) {
            CubicPlane[] orderedPlanes = {CubicPlane.MIDDLE, CubicPlane.SANDWICH, CubicPlane.EQUATOR, CubicPlane.LEFT, CubicPlane.RIGHT, CubicPlane.UP, CubicPlane.DOWN, CubicPlane.FRONT, CubicPlane.BACK};
            return Integer.compare(ArrayUtils.arrayIndex(orderedPlanes, o1), ArrayUtils.arrayIndex(orderedPlanes, o2));
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof GroupComparator)) return false;
            for (CubicPlane p1 : CubicPlane.values())
                for (CubicPlane p2 : CubicPlane.values())
                    if (this.compare(p1, p2) != ((GroupComparator) obj).compare(p1, p2))
                        return false;
            return true;
        }
    }

    public static SubGroup fromAlg(Algorithm alg) {
        CubicPlane[] algPlanes = new CubicPlane[alg.allMoves().size()];
        for (int i = 0; i < alg.allMoves().size(); i++)
            algPlanes[i] = (CubicPlane) alg.nMove(i).getPlane();
        return new SubGroup(algPlanes);
    }

    public static SubGroup fromCubicGroupString(String alg) {
        String[] parts = alg.replace("<", "").replace(">", "").split(",");
        CubicPlane[] algPlanes = new CubicPlane[parts.length];
        for (int i = 0; i < parts.length; i++)
            algPlanes[i] = CubicPlane.fromNotation(parts[i]);
        return new SubGroup(algPlanes);
    }

    private ArrayList<CubicPlane> groupList;

    public SubGroup(CubicPlane... planes) {
        this.groupList = new ArrayList<>();
        for (CubicPlane p : planes)
            if (!this.groupList.contains(p) && !p.isRotation())
                this.groupList.add(p);
        Collections.sort(this.groupList, new GroupComparator());
    }

    private String[] getElementsAsString() {
        String[] elements = new String[this.groupList.size()];
        for (int i = 0; i < elements.length; i++) elements[i] = this.groupList.get(i).toFormatString();
        return elements;
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

    public boolean containsAll(SubGroup other) {
        return this.groupList.containsAll(other.groupList);
    }
}