package org.learning;

import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.MultiGraph;
import org.graphstream.graph.implementations.SingleGraph;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MultiGraphLimitValueTest {
    public static final int DEFAULT_NODE_CAPACITY = 128;
    public static final int DEFAULT_EDGE_CAPACITY = 1024;

    @Test
    public void nodeLimitCapacity() {
        MultiGraph g = new MultiGraph("NodeLimit");

        for (int i = 0; i < DEFAULT_NODE_CAPACITY; i++) {
            g.addNode(Integer.toString(i));
        }

        assertNotNull(g.addNode("129"));

        // FIX-ME: Move to unit test
        assertEquals(g.getNode("129"), g.getNode(128));
    }

    @Test
    public void edgeLimitCapacity() {
        int nodeNumber = 24;
        MultiGraph g = new MultiGraph("NodeLimit");
        Node a, b;

        for (int i = 0; i <= nodeNumber; i++) {
            g.addNode(Integer.toString(i));
        }

        for (int i = 0; i < nodeNumber; i++) {
            for (int j = 0; j < nodeNumber; j++) {
                a = g.getNode(Integer.toString(i));
                b = g.getNode(Integer.toString(j));

                g.addEdge(a.toString() + "_" + b.toString(), a, b, true);
            }
        }
    }

    @Test
    public void nodeGettersLimitValue() {
        int nodeQuantity = 10;
        SingleGraph g = new SingleGraph("NodeLimit");

        for (int i = 0; i < nodeQuantity; i++) {
            g.addNode(Integer.toString(i));
        }

        for (int i = 0; i < nodeQuantity; i++) {
            assertEquals(Integer.toString(i), g.getNode(i).toString());
        }

        assertThrows(IndexOutOfBoundsException.class, () -> { g.getNode(-1); });
        assertThrows(IndexOutOfBoundsException.class, () -> { g.getNode(nodeQuantity + 1); });
    }

    @Test
    public void edgeGettersLimitValue() {
        int nodeQuantity = 5;
        int edgeQuantity = (nodeQuantity * (nodeQuantity - 1));
        SingleGraph g = new SingleGraph("EdgeLimit");
        Node a, b;

        for (int i = 0; i <= nodeQuantity; i++) {
            g.addNode(Integer.toString(i));
        }

        for (int i = 0; i < nodeQuantity; i++) {
            for (int j = 0; j < nodeQuantity; j++) {
                if (i == j) continue;

                a = g.getNode(Integer.toString(i));
                b = g.getNode(Integer.toString(j));

                g.addEdge(a.toString() + "_" + b.toString(), a, b, true);
            }
        }

        for (int i = 0; i < nodeQuantity; i++) {
            for (int j = 0; j < nodeQuantity; j++) {
                if (i == j) continue;

                String id = i + "_" + j;
                assertEquals(id, g.getEdge(id).toString().split("\\[")[0]);
            }
        }

        assertThrows(IndexOutOfBoundsException.class, () -> { g.getEdge(-1); });
        assertThrows(IndexOutOfBoundsException.class, () -> { g.getEdge(edgeQuantity); });

    }
}
