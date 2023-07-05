package org.learning.utils;

public class SimpleTuple<X, Y> {
    public final X x;
    public final Y y;

    public SimpleTuple(X x, Y y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return "(" + this.x + ", " + this.y + ")";
    }
}
