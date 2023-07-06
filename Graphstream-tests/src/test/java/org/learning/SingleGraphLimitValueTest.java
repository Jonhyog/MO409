package org.learning;

import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;
import org.junit.jupiter.api.Test;

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

    @Test
    public void edgeLimitCapacity() {
        int nodeNumber = 47;
        SingleGraph g = new SingleGraph("NodeLimit");
        Node a, b;

        for (int i = 0; i <= nodeNumber; i++) {
            g.addNode(Integer.toString(i));
        }

        for (int i = 0; i < nodeNumber; i++) {
            for (int j = i + 1; j < nodeNumber; j++) {
                a = g.getNode(Integer.toString(i));
                b = g.getNode(Integer.toString(j));

                g.addEdge(a.toString() + "_" + b.toString(), a, b, false);
            }
        }

        assertNotNull(g.addEdge("l" , g.getNode("0"), g.getNode("47"), false));
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
        int nodeQuantity = 10;
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
