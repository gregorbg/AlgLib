package com.suushiemaniac.cubing.alglib.alg;

import com.suushiemaniac.cubing.alglib.move.Move;
import com.suushiemaniac.cubing.alglib.util.StringUtils;

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
        List<Move> list = new ArrayList<>();
        for (Move move : moves) {
            if (list.size() == 0) list.add(move);
            else if (list.get(list.size() - 1).cancels(move)) list.remove(list.size() - 1);
            else if (list.get(list.size() - 1).merges(move))
                list.set(list.size() - 1, list.get(list.size() - 1).merge(move));
            else if (list.get(list.size() - 1).mayAppend(move)) list.add(move);
        }
        this.moves = new ArrayList<>(list);
    }

    @Override
    public SimpleAlg inverse() {
        List<Move> reversedMoves = new ArrayList<>(this.moves);
        Collections.reverse(reversedMoves);
        for (int i = 0; i < reversedMoves.size(); i++) reversedMoves.set(i, reversedMoves.get(i).inverse());
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
    public int moveLength() {
        int size = 0;
        for (Move m : this.moves) if (!m.getPlane().isRotation()) size++;
        return size;
    }

    @Override
    public int algLength() {
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
        return ((this.moveLength() + other.moveLength()) - new SimpleAlg(this.allMoves()).merge(other).moveLength()) / 2;
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
        return obj instanceof SimpleAlg && this.allMoves().containsAll(((SimpleAlg) obj).allMoves()) && ((SimpleAlg) obj).allMoves().containsAll(this.allMoves());
    }

    @Override
    public SubGroup getSubGroup() {
        return SubGroup.fromAlg(this);
    }
}