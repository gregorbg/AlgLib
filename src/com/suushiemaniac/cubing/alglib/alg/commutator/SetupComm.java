package com.suushiemaniac.cubing.alglib.alg.commutator;

import com.suushiemaniac.cubing.alglib.alg.Algorithm;
import com.suushiemaniac.cubing.alglib.transform.Transform;

import java.util.Collection;

public class SetupComm extends Commutator {
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
    public Algorithm develop() {
        return this.setup.merge(this.inner).merge(this.setup.inverse());
    }

    @Override
    public SetupComm inverse() {
        return new SetupComm(this.setup, this.inner.inverse());
    }

    @Override
    public int cancelationLength() {
        return (2 * this.setup.moveLength() + this.inner.moveLength()) - this.moveLength();
    }

    @Override
    public SetupComm transform(Transform transform) {
        return new SetupComm(this.setup.transform(transform), this.inner.transform(transform));
    }

    public Algorithm getSetup() {
        return this.setup;
    }

    public Algorithm getInner() {
        return this.inner;
    }

    @Override
    public boolean remove(Object o) {
        return this.setup.remove(o) | this.inner.remove(o);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return this.setup.removeAll(c) | this.inner.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return this.setup.retainAll(c) | this.inner.retainAll(c);
    }

    @Override
    public void clear() {
        this.setup.clear();
        this.inner.clear();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof SetupComm)) return false;
        else {
            SetupComm compareTo = (SetupComm) obj;
            return this.setup.equals(compareTo.setup) && this.inner.equals(compareTo.inner);
        }
    }

    @Override
    public int hashCode() {
        return this.setup.hashCode() + this.inner.hashCode();
    }
}