package com.suushiemaniac.cubing.alglib.alg.commutator;

import com.suushiemaniac.cubing.alglib.alg.Algorithm;
import com.suushiemaniac.cubing.alglib.move.Move;
import com.suushiemaniac.cubing.alglib.util.SubGroup;

public class SetupComm implements Commutator {
    public static boolean isSetupCommutable(Algorithm algorithm) {
        //Not very useful atm, add functionality as long-term project??
        return algorithm instanceof SetupComm;
    }

    protected Algorithm setup, inner;

    public SetupComm(Algorithm setup, Algorithm inner) {
        this.setup = setup;
        this.inner = inner;
    }

    @Override
    public String toFormatString() {
        return "[" + this.setup.toFormatString() + (this.cancels() ? " : " : " ; ") + this.inner.toFormatString() + "]";
    }

    @Override
    public String toPlainString() {
        return this.develop().toFormatString();
    }

    @Override
    public Algorithm develop() {
        Algorithm setupMerged = this.setup.merge(this.inner);
        return setupMerged.merge(this.setup.inverse());
    }

    @Override
    public SetupComm inverse() {
        return new SetupComm(this.setup, this.inner.inverse());
    }

    @Override
    public Algorithm plain() {
        return this.develop();
    }

    @Override
    public int length() {
        return (2 * this.setup.length() + this.inner.length()) - this.cancelationLength();
    }

    @Override
    public int cancelationLength() {
        return this.cancels() ? 1 : ((2 * this.setup.length() + this.inner.length()) - this.develop().length());
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
        return this.setup.firstMove();
    }

    @Override
    public Move lastMove() {
        return this.setup.inverse().lastMove();
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

    public Algorithm getSetup() {
        return this.setup;
    }

    public Algorithm getInner() {
        return this.inner;
    }

    public boolean cancels() {
        return this.setup.lastMove().merges(this.inner.firstMove())
                || this.setup.lastMove().merges(this.inner.lastMove());
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof SetupComm)) return false;
        else {
            SetupComm compareTo = (SetupComm) obj;
            return this.setup.equals(compareTo.getSetup()) && this.inner.equals(compareTo.getInner());
        }
    }
}