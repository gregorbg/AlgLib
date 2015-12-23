package com.suushiemaniac.cubing.alglib.alg.commutator;

import com.suushiemaniac.cubing.alglib.alg.Algorithm;
import com.suushiemaniac.cubing.alglib.move.Move;
import com.suushiemaniac.cubing.alglib.util.SubGroup;

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
    public int length() {
        return 2 * this.partA.length() + 2 * this.partB.length();
    }

    @Override
    public int cancelationLength() {
        return 0;
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
    public Move[] allMoves() {
        return this.develop().allMoves();
    }

    @Override
    public Move[] subAlg(int from, int to) {
        return this.develop().subAlg(from, to);
    }

    @Override
    public Algorithm reduce() {
        return this.develop().reduce();
    }

    @Override
    public SubGroup getSubGroup() {
        return SubGroup.fromAlg(this.develop());
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
            return this.partA.equals(compareTo.getPartA()) && this.partB.equals(compareTo.partB);
        }
    }
}