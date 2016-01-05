package com.suushiemaniac.cubing.alglib.alg;

import com.suushiemaniac.cubing.alglib.move.Move;
import com.suushiemaniac.cubing.alglib.util.StringUtils;
import com.suushiemaniac.cubing.alglib.util.SubGroup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SimpleAlg implements Algorithm {
    private final List<Move> moves;

    public SimpleAlg(Move... moves) {
        this(Arrays.asList(moves));
    }

    public SimpleAlg(List<Move> moves) {
        List<Move> reducedList = new ArrayList<>();
        for (Move move : moves) reducedList = appendToList(reducedList, move);
        this.moves = new ArrayList<>(reducedList);
    }

    private List<Move> appendToList(List<Move> list, Move other) {
        if (list.size() == 0) //noinspection ArraysAsListWithZeroOrOneArgument
            return new ArrayList<>(Arrays.asList(other));

        if (list.get(list.size() - 1).cancels(other)) list = list.subList(0, this.length() - 1);
        else if (list.get(list.size() - 1).merges(other))
            list.set(list.size() - 1, list.get(list.size() - 1).merge(other));
        else if (list.get(list.size() - 1).mayAppend(other)) list.add(other);
        return new ArrayList<>(list);
    }

    @Override
    public SimpleAlg inverse() {
        List<Move> reversedMoves = new ArrayList<>(this.moves);
        Collections.reverse(reversedMoves);
        return new SimpleAlg(reversedMoves);
    }

    @Override
    public Algorithm plain() {
        return this;
    }

    @Override
    public String toFormatString() {
        return StringUtils.join(" ", this.allMoves());
    }

    @Override
    public int length() {
        return this.moves.size();
    }

    @Override
    public SimpleAlg merge(Algorithm other) {
        List<Move> oldMoves = this.allMoves();
        oldMoves.addAll(other.allMoves());
        return new SimpleAlg(oldMoves);
    }

    @Override
    public SimpleAlg append(Move other) {
        List<Move> oldMoves = this.allMoves();
        oldMoves.add(other);
        return new SimpleAlg(oldMoves);
    }

    @Override
    public int cancelationLength(Algorithm other) {
        return ((this.length() + other.length()) - new SimpleAlg(this.allMoves()).merge(other).length()) / 2;
    }

    @Override
    public Move nMove(int n) {
        return this.moves.get(n);
    }

    @Override
    public Move firstMove() {
        return this.nMove(0);
    }

    @Override
    public Move lastMove() {
        return this.nMove(this.moves.size() - 1);
    }

    @Override
    public List<Move> allMoves() {
        return new ArrayList<>(this.moves);
    }

    @Override
    public Algorithm subAlg(int from, int to) {
        return new SimpleAlg(this.moves.subList(from, to));
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
    public SubGroup getSubGroup() {
        return SubGroup.fromAlg(this);
    }
}