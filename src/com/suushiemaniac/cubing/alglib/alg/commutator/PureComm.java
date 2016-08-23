package com.suushiemaniac.cubing.alglib.alg.commutator;

import com.suushiemaniac.cubing.alglib.alg.Algorithm;
import com.suushiemaniac.cubing.alglib.alg.SubGroup;
import com.suushiemaniac.cubing.alglib.move.Move;
import com.suushiemaniac.cubing.alglib.transform.Transform;

import java.util.Iterator;
import java.util.List;

public class PureComm implements Commutator {
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
    public String toPlainString() {
        return this.develop().toFormatString();
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
    public Algorithm plain() {
        return this.develop();
    }

    @Override
    public int moveLength() {
        return this.develop().moveLength();
    }

    @Override
    public int algLength() {
        return this.develop().algLength();
    }

    @Override
    public int cancelationLength() {
        return (2 * this.partA.moveLength() + 2 * this.partB.moveLength()) - this.moveLength();
    }

    @Override
    public int cancelationLength(Algorithm other) {
        return this.develop().cancelationLength(other);
    }

    @Override
    public Algorithm merge(Algorithm other) {
        return this.develop().merge(other);
    }

    @Override
    public Algorithm append(Move other) {
        return this.develop().append(other);
    }

    @Override
    public PureComm transform(Transform transform) {
        return new PureComm(this.partA.transform(transform), this.partB.transform(transform));
    }

    @Override
    public Move nMove(int n) {
        return this.develop().nMove(n);
    }

    @Override
    public Move firstMove() {
        return this.partA.firstMove();
    }

    @Override
    public Move lastMove() {
        return this.partB.inverse().lastMove();
    }

    @Override
    public List<Move> allMoves() {
        return this.develop().allMoves();
    }

    @Override
    public Algorithm subAlg(int from, int to) {
        return this.develop().subAlg(from, to);
    }

    @Override
    public SubGroup getSubGroup() {
        return SubGroup.fromAlg(this.develop());
    }

    @Override
    public boolean cancels() {
        return this.cancelationLength() > 0;
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

    @Override
    public Iterator<Move> iterator() {
        return this.plain().allMoves().iterator();
    }
}