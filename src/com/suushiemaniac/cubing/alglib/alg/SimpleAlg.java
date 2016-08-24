package com.suushiemaniac.cubing.alglib.alg;

import com.suushiemaniac.cubing.alglib.move.Move;
import com.suushiemaniac.cubing.alglib.transform.Transform;
import com.suushiemaniac.cubing.alglib.util.StringUtils;

import java.util.*;

public class SimpleAlg implements Algorithm {
    private List<Move> moves;
	private boolean reduceAutomatic;

    public SimpleAlg(Move... moves) {
        this(Arrays.asList(moves));
    }

    public SimpleAlg(List<Move> moves) {
    	this(moves, true);
	}

    public SimpleAlg(List<Move> moves, boolean reduceAutomatic) {
        this.moves = new ArrayList<>(moves);
		this.reduceAutomatic = reduceAutomatic;

		if (this.reduceAutomatic)
			this.reduce();
    }

    private void reduce() {
		List<Move> list = new ArrayList<>();

		for (Move move : this.moves) {
			if (list.size() == 0) list.add(move);
			else if (list.get(list.size() - 1).cancels(move)) list.remove(list.size() - 1);
			else if (list.get(list.size() - 1).merges(move))
				list.set(list.size() - 1, list.get(list.size() - 1).merge(move));
			else if (list.get(list.size() - 1).mayAppend(move)) list.add(move);
		}

		this.moves = list;
	}

    @Override
    public SimpleAlg inverse() {
        Collections.reverse(this.moves);
        for (int i = 0; i < this.moves.size(); i++) this.moves.set(i, this.moves.get(i).inverse());
        if (this.reduceAutomatic) this.reduce();

		return this;
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
        this.moves.addAll(other.allMoves());
		if (this.reduceAutomatic) this.reduce();

		return this;
    }

    @Override
    public SimpleAlg append(Move other) {
    	this.moves.add(other);
		if (this.reduceAutomatic) this.reduce();

		return this;
    }

    @Override
    public Algorithm transform(Transform transform) {
        for (int i = 0; i < this.moves.size(); i++) this.moves.set(i, this.moves.get(i).transform(transform));
        if (this.reduceAutomatic) this.reduce();

		return this;
    }

    @Override
    public int cancelationLength(Algorithm other) {
        return ((this.moveLength() + other.moveLength()) - new SimpleAlg(this.allMoves(), this.reduceAutomatic).merge(other).moveLength()) / 2;
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
    public int hashCode() {
        return this.allMoves().hashCode();
    }

	@Override
	public Move get(int index) {
		return this.moves.get(index);
	}

	@Override
	public Move set(int index, Move element) {
		Move m = this.moves.set(index, element);
		if (this.reduceAutomatic) this.reduce();

		return m;
	}

	@Override
	public void add(int index, Move element) {
		this.moves.add(index, element);
		if (this.reduceAutomatic) this.reduce();
	}

	@Override
	public Move remove(int index) {
		Move m = this.moves.remove(index);
		if (this.reduceAutomatic) this.reduce();

		return m;
	}

	@Override
	public int indexOf(Object o) {
		return this.moves.indexOf(o);
	}

	@Override
	public int lastIndexOf(Object o) {
		return this.moves.lastIndexOf(o);
	}

	@Override
	public ListIterator<Move> listIterator() {
		return this.moves.listIterator();
	}

	@Override
	public ListIterator<Move> listIterator(int index) {
		return this.moves.listIterator(index);
	}

	@Override
	public List<Move> subList(int fromIndex, int toIndex) {
		return this.subAlg(fromIndex, toIndex);
	}

	@Override
	public SubGroup getSubGroup() {
		return SubGroup.fromAlg(this);
	}

	@Override
	public int size() {
		return this.algLength();
	}

	@Override
	public boolean isEmpty() {
		return this.moves.isEmpty();
	}

	@Override
	public boolean contains(Object o) {
		return this.moves.contains(o);
	}

	@Override
    public Iterator<Move> iterator() {
        return this.allMoves().iterator();
    }

	@Override
	public Object[] toArray() {
		return this.moves.toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return this.moves.toArray(a);
	}

	@Override
	public boolean add(Move move) {
		boolean b = this.moves.add(move);
		if (this.reduceAutomatic) this.reduce();

		return b;
	}

	@Override
	public boolean remove(Object o) {
		boolean b = this.moves.remove(o);
		if (this.reduceAutomatic) this.reduce();

		return b;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return this.moves.containsAll(c);
	}

	@Override
	public boolean addAll(Collection<? extends Move> c) {
		boolean b = this.moves.addAll(c);
		if (this.reduceAutomatic) this.reduce();

		return b;
	}

	@Override
	public boolean addAll(int index, Collection<? extends Move> c) {
		boolean b = this.moves.addAll(index, c);
		if (this.reduceAutomatic) this.reduce();

		return b;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		boolean b = this.moves.removeAll(c);
		if (this.reduceAutomatic) this.reduce();

		return b;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		boolean b = this.moves.retainAll(c);
		if (this.reduceAutomatic) this.reduce();

		return b;
	}

	@Override
	public void clear() {
		this.moves.clear();
		if (this.reduceAutomatic) this.reduce();
	}
}