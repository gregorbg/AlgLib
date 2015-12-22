package com.suushiemaniac.cubing.alglib.alg;

import com.suushiemaniac.cubing.alglib.move.Move;
import com.suushiemaniac.cubing.alglib.util.StringUtils;

import java.util.Arrays;

public class SimpleAlg implements Algorithm {
    private final Move[] moves;

    public SimpleAlg(Move... moves) {
        this.moves = Arrays.copyOf(moves, moves.length);
    }

    @Override
    public SimpleAlg inverse() {
        Move[] inverse = new Move[this.moves.length];
        for (int i = 0; i < this.moves.length; i++) inverse[-i + inverse.length - 1] = this.moves[i].inverse();
        return new SimpleAlg(inverse);
    }

    @Override
    public String toFormatString() {
        return StringUtils.join(" ", this.allMoves());
    }

    @Override
    public int length() {
        return this.moves.length;
    }

    @Override
    public SimpleAlg merge(Algorithm other) {
        SimpleAlg startAlg = new SimpleAlg(this.allMoves());
        for (Move newMove : other.allMoves()) startAlg = startAlg.append(newMove);
        return startAlg;
    }

    @Override
    public SimpleAlg append(Move other) {
        Move[] newMoves;
        if (this.lastMove().cancels(other)) {
            newMoves = new Move[this.allMoves().length - 1];
            for (int i = 0; i < newMoves.length; i++) newMoves[i] = this.allMoves()[i];
        } else if (this.lastMove().merges(other)) {
            newMoves = this.allMoves();
            newMoves[newMoves.length - 1] = newMoves[newMoves.length - 1].merge(other);
        } else if (this.lastMove().mayAppend(other)) {
            newMoves = Arrays.copyOf(this.allMoves(), this.allMoves().length + 1);
            newMoves[newMoves.length - 1] = other;
        } else newMoves = this.allMoves();
        return new SimpleAlg(newMoves);
    }

    @Override
    public int cancelationLength(Algorithm other) {
        return ((this.length() + other.length()) - new SimpleAlg(this.allMoves()).merge(other).length()) / 2;
    }

    @Override
    public Move nMove(int n) {
        return this.moves[n];
    }

    @Override
    public Move firstMove() {
        return this.nMove(0);
    }

    @Override
    public Move lastMove() {
        return this.nMove(this.moves.length- 1);
    }

    @Override
    public Move[] allMoves() {
        return this.moves;
    }

    @Override
    public Move[] subAlg(int from, int to) {
        Move[] subMoves = new Move[to - from + 1];
        int j = 0;
        for (int i = from; i <= to; i++)
            subMoves[j++] = this.nMove(i);
        return subMoves;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof SimpleAlg)) return false;
        else {
            SimpleAlg compareTo = (SimpleAlg) obj;
            if (this.length() != compareTo.length()) return false;
            for (int i = 0; i < (this.length() & compareTo.length()); i++)
                if (!this.nMove(i).equals(compareTo.nMove(i)))
                    return false;
            return true;
        }
    }

    @Override
    public SimpleAlg reduce() {
        SimpleAlg startAlg = new SimpleAlg(this.moves[0]);
        for (int i = 1; i < this.moves.length; i++)
            startAlg = startAlg.append(moves[i]);
        return startAlg;
    }

    @Override
    public String toString() {
        return this.toFormatString();
    }
}