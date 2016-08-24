package com.suushiemaniac.cubing.alglib.alg.commutator;

import com.suushiemaniac.cubing.alglib.alg.Algorithm;
import com.suushiemaniac.cubing.alglib.alg.SubGroup;
import com.suushiemaniac.cubing.alglib.move.Move;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

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
	public int size() {
		return this.develop().size();
	}

	@Override
	public boolean isEmpty() {
		return this.develop().isEmpty();
	}

	@Override
	public boolean contains(Object o) {
		return this.develop().contains(o);
	}

	@Override
	public Object[] toArray() {
		return this.develop().toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return this.develop().toArray(a);
	}

	@Override
	public boolean add(Move move) {
		return false; //FIXME
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return this.develop().containsAll(c);
	}

	@Override
	public boolean addAll(Collection<? extends Move> c) {
		return false; //FIXME
	}

	@Override
	public boolean addAll(int index, Collection<? extends Move> c) {
		return false; //FIXME
	}

	@Override
	public Move get(int index) {
		return this.develop().get(index);
	}

	@Override
	public Move set(int index, Move element) {
		return null; //FIXME
	}

	@Override
	public void add(int index, Move element) {
		//FIXME
	}

	@Override
	public Move remove(int index) {
		return null; //FIXME
	}

	@Override
	public int indexOf(Object o) {
		return this.develop().indexOf(o);
	}

	@Override
	public int lastIndexOf(Object o) {
		return this.develop().lastIndexOf(o);
	}

	@Override
	public ListIterator<Move> listIterator() {
		return this.develop().listIterator();
	}

	@Override
	public ListIterator<Move> listIterator(int index) {
		return this.develop().listIterator(index);
	}

	@Override
	public List<Move> subList(int fromIndex, int toIndex) {
		return this.develop().subAlg(fromIndex, toIndex);
	}
}
