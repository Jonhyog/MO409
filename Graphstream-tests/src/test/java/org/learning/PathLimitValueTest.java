package org.learning;

import org.graphstream.graph.Node;
import org.graphstream.graph.Path;
import org.graphstream.graph.implementations.SingleGraph;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

public class PathLimitValueTest {
    @Test
    public void pathLimit() {
        Path p = new Path();

        assertEquals(0, p.getNodeCount());
        assertEquals(0, p.getEdgeCount());

        assertThrows(EmptyStackException.class, p::peekNode);
        assertThrows(EmptyStackException.class, p::peekEdge);
        assertThrows(EmptyStackException.class, p::popNode);
        assertThrows(EmptyStackException.class, p::popEdge);

    }
}
