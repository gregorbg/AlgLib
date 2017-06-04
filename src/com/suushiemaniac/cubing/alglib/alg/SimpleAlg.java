package com.suushiemaniac.cubing.alglib.alg;

import com.suushiemaniac.cubing.alglib.move.Move;
import com.suushiemaniac.cubing.alglib.transform.Transform;
import com.suushiemaniac.cubing.alglib.util.StringUtils;

import java.util.*;
import java.util.stream.Stream;

public class SimpleAlg implements Algorithm {
    private List<Move> moves;
    private String formatDelimiter;

	public SimpleAlg(Algorithm other) {
		this(other.allMoves());
	}

    public SimpleAlg(Move... moves) {
        this(Arrays.asList(moves));
    }

    public SimpleAlg(List<Move> moves) {
		this.moves = new ArrayList<>(moves);
		this.formatDelimiter = " ";

		this.reduce();
    }

    public void setFormatDelimiter(String formatDelimiter) {
		this.formatDelimiter = formatDelimiter;
	}

    protected SimpleAlg reduce() {
		List<Move> reduced = new ArrayList<>();

		for (Move move : this.moves) {
			if (reduced.size() == 0)
				reduced.add(move);
			else if (reduced.get(reduced.size() - 1).cancels(move))
				reduced.remove(reduced.size() - 1);
			else if (reduced.get(reduced.size() - 1).merges(move))
				reduced.set(reduced.size() - 1, reduced.get(reduced.size() - 1).merge(move));
			else if (reduced.get(reduced.size() - 1).mayAppend(move))
				reduced.add(move);
		}

		this.moves = new ArrayList<>(reduced);

		return this;
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
        return new SimpleAlg(this.allMoves());
    }

    @Override
    public String toFormatString() {
        return StringUtils.join(this.formatDelimiter, this.allMoves());
    }

    @Override
    public int moveLength() {
        int size = 0;
        for (Move m : this.moves)
        	if (!m.getPlane().isRotation()) size++;
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
		this.moves = new ArrayList<>(oldMoves);
		return this.reduce();
    }

    @Override
    public SimpleAlg append(Move other) {
		List<Move> oldMoves = this.allMoves();
		oldMoves.add(other);
		this.moves = new ArrayList<>(oldMoves);
		return this.reduce();
    }

    @Override
    public Algorithm transform(Transform transform) {
		List<Move> oldMoves = this.allMoves();
		for (int i = 0; i < oldMoves.size(); i++) oldMoves.set(i, oldMoves.get(i).transform(transform));
		this.moves = new ArrayList<>(oldMoves);
		return this.reduce();
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
        return obj instanceof SimpleAlg
				&& this.allMoves().containsAll(((SimpleAlg) obj).allMoves())
				&& ((SimpleAlg) obj).allMoves().containsAll(this.allMoves());
    }

    @Override
    public int hashCode() {
        return this.allMoves().hashCode();
    }

	@Override
	public SubGroup getSubGroup() {
		return SubGroup.fromAlg(this, false);
	}

	@Override
	public SubGroup getRotationGroup() {
		return SubGroup.fromAlg(this, true);
	}

	@Override
	public Stream<Move> stream() {
		return this.allMoves().stream();
	}

	@Override
	public Iterator<Move> iterator() {
		return this.allMoves().iterator();
	}

	public Algorithm copy() {
		return new SimpleAlg(this);
	}

	public String toString() {
		return this.toFormatString();
	}
}