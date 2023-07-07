package org.learning;

import org.graphstream.graph.Edge;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Vector;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class SingleGraphUnitTests {
    protected static SingleGraph g;

    @BeforeAll
    public static void setup() {
        String[] nodeList = {"A", "B", "C", "D", "E", "G", "H"};
        List<Node> nodes = new Vector<>();

        g = new SingleGraph("Graph");

        for (String nodeID : nodeList) {
            nodes.add(g.addNode(nodeID));
        }

        g.addEdge("E1", nodes.get(0), nodes.get(1));
        g.addEdge("E2", nodes.get(1), nodes.get(2));
        g.addEdge("E3", nodes.get(2), nodes.get(3));
        g.addEdge("E4", nodes.get(3), nodes.get(4));
        g.addEdge("E5", nodes.get(4), nodes.get(5));
        g.addEdge("E6", nodes.get(5), nodes.get(6));

    }

    @AfterAll
    public static void teardown() {
        g.clear();
    }

    @Test
    public void testNodeStream() {
        Stream<Node> nodeStream;

        nodeStream = g.nodes();
        assertNotNull(nodeStream);
        assertTrue(nodeStream.findAny().isPresent());

        nodeStream = g.nodes();
        assertNotNull(nodeStream);
        nodeStream.forEach(Assertions::assertNotNull);
    }

    @Test
    public void testEdgeStream() {
        Stream<Edge> edgeStream;

        edgeStream = g.edges();
        assertNotNull(edgeStream);
        assertTrue(edgeStream.findAny().isPresent());

        edgeStream = g.edges();
        assertNotNull(edgeStream);
        edgeStream.forEach(Assertions::assertNotNull);
    }

    @Test
    public void testGetNode() {
        String[] nodeList = {"A", "B", "C", "D", "E", "G", "H"};

        for (String nodeID : nodeList) {
            Node n = g.getNode(nodeID);

            assertNotNull(n);
            assertEquals(nodeID, n.toString());
        }

        for (int i = 0; i < nodeList.length; i++) {
            Node n = g.getNode(nodeList[i]);

            assertNotNull(n);
            assertEquals(nodeList[i], n.toString());
        }

    }

    @Test
    public void testGetEdge() {
        String[] edgeList = {"E1", "E2", "E3", "E4", "E5", "E6"};

        for (String edgeID : edgeList) {
            Edge e = g.getEdge(edgeID);

            assertNotNull(e);
            assertEquals(edgeID, e.toString().split("\\[")[0]);
        }

        for (int i = 0; i < edgeList.length; i++) {
            Edge e = g.getEdge(edgeList[i]);

            assertNotNull(e);
            assertEquals(edgeList[i], e.toString().split("\\[")[0]);
        }

    }




}
