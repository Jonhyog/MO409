package org.learning;

import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class SingleGraphLimitValueTest {
    public static final int DEFAULT_NODE_CAPACITY = 128;
    public static final int DEFAULT_EDGE_CAPACITY = 1024;

    @Test
    public void nodeLimitCapacity() {
        SingleGraph g = new SingleGraph("NodeLimit");

        for (int i = 0; i < DEFAULT_NODE_CAPACITY; i++) {
            g.addNode(Integer.toString(i));
        }

        assertNotNull(g.addNode("129"));
    }

    @ParameterizedTest
    @ValueSource(ints = {47, 48}) // ( 47 * 46 ) / 2 == 1081 > DEFAULT_EDGE_CAPACITY
    public void edgeLimitCapacity(int nodeNumber) {
        SingleGraph g = new SingleGraph("NodeLimit");
        Node a, b;

        for (int i = 0; i <= nodeNumber; i++) {
            g.addNode(Integer.toString(i));
        }

        // Creates full graph
        for (int i = 0; i < nodeNumber; i++) {
            for (int j = i + 1; j < nodeNumber; j++) {
                a = g.getNode(Integer.toString(i));
                b = g.getNode(Integer.toString(j));

                g.addEdge(a.toString() + "_" + b.toString(), a, b, false);
            }
        }

        // Adds one more edge
        assertNotNull(g.addEdge("l" , g.getNode("0"), g.getNode(Integer.toString(nodeNumber)), false));
    }

    @ParameterizedTest
    @ValueSource(ints = {10, 11, 42, 51, 128})
    public void nodeGettersLimitValue(int nodeQuantity) {
        SingleGraph g = new SingleGraph("NodeLimit");

        for (int i = 0; i < nodeQuantity; i++) {
            g.addNode(Integer.toString(i));
        }

        for (int i = 0; i < nodeQuantity; i++) {
            assertEquals(Integer.toString(i), g.getNode(i).toString());
        }

        assertThrows(IndexOutOfBoundsException.class, () -> { g.getNode(-1); });
        // assertThrows(IndexOutOfBoundsException.class, () -> { g.getNode(nodeQuantity); });
    }

    @ParameterizedTest
    @ValueSource(ints = {10, 11, 42, 51, 128})
    public void edgeGettersLimitValue(int nodeQuantity) {
        int edgeQuantity = (nodeQuantity * (nodeQuantity - 1)) / 2;
        SingleGraph g = new SingleGraph("EdgeLimit");
        Node a, b;

        for (int i = 0; i <= nodeQuantity; i++) {
            g.addNode(Integer.toString(i));
        }

        for (int i = 0; i < nodeQuantity; i++) {
            for (int j = i + 1; j < nodeQuantity; j++) {
                a = g.getNode(Integer.toString(i));
                b = g.getNode(Integer.toString(j));

                g.addEdge(a.toString() + "_" + b.toString(), a, b, false);
            }
        }

        for (int i = 0; i < nodeQuantity; i++) {
            for (int j = i + 1; j < nodeQuantity; j++) {
                String id = Integer.toString(i) + "_" + Integer.toString(j);
                assertEquals(id, g.getEdge(id).toString().split("\\[")[0]);
            }
        }

        assertThrows(IndexOutOfBoundsException.class, () -> { g.getEdge(-1); });
        assertThrows(IndexOutOfBoundsException.class, () -> { g.getEdge(edgeQuantity); });

    }

}
