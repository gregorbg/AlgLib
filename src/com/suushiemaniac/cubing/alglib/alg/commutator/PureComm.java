package com.suushiemaniac.cubing.alglib.alg.commutator;

import com.suushiemaniac.cubing.alglib.alg.Algorithm;
import com.suushiemaniac.cubing.alglib.alg.SubGroup;
import com.suushiemaniac.cubing.alglib.move.Move;
import com.suushiemaniac.cubing.alglib.transform.Transform;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class PureComm extends Commutator {
    public static boolean isPureCommutable(Algorithm algorithm) {
        //Not very useful atm, add functionality as long-term project??
        return algorithm instanceof PureComm;
    }

    protected Algorithm partA, partB;

    public PureComm(Algorithm partA, Algorithm partB) {
        this.partA = partA;
        this.partB = partB;
    }

    @Override
    public String toFormatString() {
        return "[" + this.partA.toFormatString() + " , " + this.partB.toFormatString() + "]";
    }

    @Override
    public Algorithm develop() {
        return this.partA.merge(this.partB).merge(this.partA.inverse()).merge(this.partB.inverse());
    }

    @Override
    public PureComm inverse() {
        return new PureComm(this.partB, this.partA);
    }

    @Override
    public int cancelationLength() {
        return (2 * this.partA.moveLength() + 2 * this.partB.moveLength()) - this.moveLength();
    }

    @Override
    public PureComm transform(Transform transform) {
        return new PureComm(this.partA.transform(transform), this.partB.transform(transform));
    }

    public Algorithm getPartA() {
        return this.partA;
    }

    public Algorithm getPartB() {
        return this.partB;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof PureComm)) return false;
        else {
            PureComm compareTo = (PureComm) obj;
            return this.partA.equals(compareTo.partA) && this.partB.equals(compareTo.partB);
        }
    }

    @Override
    public int hashCode() {
        return this.partA.hashCode() + this.partB.hashCode();
    }
}