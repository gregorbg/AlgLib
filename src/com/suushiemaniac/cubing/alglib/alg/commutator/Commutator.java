package com.suushiemaniac.cubing.alglib.alg.commutator;

import com.suushiemaniac.cubing.alglib.alg.Algorithm;
import com.suushiemaniac.cubing.alglib.alg.SubGroup;
import com.suushiemaniac.cubing.alglib.move.Move;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public abstract class Commutator implements Algorithm {
    public abstract int cancelationLength();

    public abstract Algorithm develop();

    public abstract Commutator inverse();

	public boolean cancels() {
		return this.cancelationLength() > 0;
	}

	public String toPlainString() {
		return this.develop().toFormatString();
	}

    @Override
    public Iterator<Move> iterator() {
        return this.plain().allMoves().iterator();
    }

	@Override
	public Move nMove(int n) {
		return this.develop().nMove(n);
	}

	@Override
	public Move firstMove() {
		return this.develop().firstMove();
	}

	@Override
	public Move lastMove() {
		return this.develop().lastMove();
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
	public Stream<Move> stream() {
		return this.develop().stream();
	}
}
