package org.learning;

import org.graphstream.graph.Edge;
import org.graphstream.graph.Node;
import org.graphstream.graph.Path;
import org.graphstream.graph.implementations.SingleGraph;
import org.junit.jupiter.api.*;

import java.util.List;
import java.util.Vector;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PathUnitTests {
    protected static SingleGraph g;
    protected static Path p1;
    protected static Path p2;

    @BeforeAll
    public static void setup() {
        String[] nodeList = {"A", "B", "C", "D", "E", "G", "H"};
        List<Node> nodes = new Vector<>();

        g = new SingleGraph("Graph");
        p1 = new Path();
        p2 = new Path();

        for (String nodeID : nodeList) {
            nodes.add(g.addNode(nodeID));
        }

        g.addNode("Lorem");
        g.addNode("Dolor");
        g.addEdge("Ipsum", g.getNode("Lorem"), g.getNode("Dolor"));


        g.addEdge("E1", nodes.get(0), nodes.get(1));
        g.addEdge("E2", nodes.get(1), nodes.get(2));
        g.addEdge("E3", nodes.get(2), nodes.get(3));
        g.addEdge("E4", nodes.get(3), nodes.get(4));
        g.addEdge("E5", nodes.get(4), nodes.get(5));
        g.addEdge("E6", nodes.get(5), nodes.get(6));

        p1.setRoot(nodes.get(0));
        p2.setRoot(nodes.get(0));

        p1.add(nodes.get(0), g.getEdge("E1"));
        p2.add(nodes.get(0), g.getEdge("E1"));

        p1.add(nodes.get(1), g.getEdge("E2"));
        p2.add(nodes.get(1), g.getEdge("E2"));

        p1.add(nodes.get(2), g.getEdge("E3"));
        p2.add(nodes.get(2), g.getEdge("E3"));

        p1.add(nodes.get(3), g.getEdge("E4"));
        p2.add(nodes.get(3), g.getEdge("E4"));

        p1.add(nodes.get(4), g.getEdge("E5"));
        p2.add(nodes.get(4), g.getEdge("E5"));

        p1.add(nodes.get(5), g.getEdge("E6"));
        p2.add(nodes.get(5), g.getEdge("E6"));

    }

    @AfterAll
    public static void teardown() {
        g.clear();
        p1.clear();
        p2.clear();
    }

    @Test
    @Order(1)
    public void testGetRoot() {
        assertNotNull(p1.getRoot());
        assertNotNull(p2.getRoot());

        assertEquals(g.getNode("A"), p1.getRoot());
        assertEquals(g.getNode("A"), p2.getRoot());
    }

    @Test
    @Order(2)
    public void testContainsNode() {
        assertTrue(p1.contains(g.getNode("C")));
        assertTrue(p2.contains(g.getNode("C")));

        assertFalse(p1.contains(g.getNode("Lorem")));
        assertFalse(p2.contains(g.getNode("Dolor")));
    }

    @Test
    @Order(3)
    public void testContainsEdge() {
        assertTrue(p1.contains(g.getEdge("E5")));
        assertTrue(p2.contains(g.getEdge("E5")));

        assertFalse(p1.contains(g.getEdge("Ipsum")));
        assertFalse(p2.contains(g.getEdge("Ipsum")));
    }

    @Test
    @Order(4)
    public void testEmpty() {
        Path p3 = new Path();

        assertFalse(p1.empty());
        assertFalse(p2.empty());
        assertTrue(p3.empty());
    }

    @Test
    @Order(5)
    public void testSize() {
        Path p3 = new Path();

        assertEquals(7, p1.size());
        assertEquals(7, p2.size());
        assertEquals(0, p3.size());
    }

    @Test
    @Order(6)
    public void testGetNodeCount() {
        Path p3 = new Path();

        assertEquals(0, p3.getNodeCount());
        assertEquals(7, p1.getNodeCount());
        assertEquals(7, p2.getNodeCount());
    }

    @Test
    @Order(7)
    public void testGetEdgeCount() {
        Path p3 = new Path();

        assertEquals(0, p3.getNodeCount());
        assertEquals(6, p1.getEdgeCount());
        assertEquals(6, p2.getEdgeCount());
    }

    @Test
    @Order(8)
    public void testGetEdgePath() {
        int i;
        String[] expected = {"E1", "E2", "E3", "E4", "E5", "E6"};

        List<Edge> edgePath1 = p1.getEdgePath();
        List<Edge> edgePath2 = p2.getEdgePath();

        assertFalse(edgePath1.isEmpty());
        assertFalse(edgePath2.isEmpty());

        i = 0;
        for (Edge e : edgePath1) {
            assertNotNull(e);
            assertEquals(expected[i], e.toString().split("\\[")[0]);
            i++;
        }

        i = 0;
        for (Edge e : edgePath2) {
            assertNotNull(e);
            assertEquals(expected[i], e.toString().split("\\[")[0]);
            i++;
        }
    }

    @Test
    @Order(9)
    public void testGetNodePath() {
        int i;
        String[] expected = {"A", "B", "C", "D", "E", "G", "H"};

        List<Node> nodePath1 = p1.getNodePath();
        List<Node> nodePath2 = p2.getNodePath();

        assertFalse(nodePath1.isEmpty());
        assertFalse(nodePath2.isEmpty());

        i = 0;
        for (Node n : nodePath1) {
            assertNotNull(n);
            assertEquals(expected[i], n.toString());
            i++;
        }

        i = 0;
        for (Node n : nodePath2) {
            assertNotNull(n);
            assertEquals(expected[i], n.toString());
            i++;
        }

    }

    @Test
    @Order(10)
    public void testGetNodeStream() {
        Stream<Node> nodeStream1;
        Stream<Node> nodeStream2;

        nodeStream1 = p1.nodes();
        assertNotNull(nodeStream1);
        assertTrue(nodeStream1.findAny().isPresent());

        nodeStream1 = p1.nodes();
        assertNotNull(nodeStream1);
        nodeStream1.forEach(Assertions::assertNotNull);

        nodeStream2 = p2.nodes();
        assertNotNull(nodeStream2);
        assertTrue(nodeStream2.findAny().isPresent());

        nodeStream2 = p2.nodes();
        assertNotNull(nodeStream2);
        nodeStream2.forEach(Assertions::assertNotNull);
    }

    @Test
    @Order(11)
    public void testGetEdgeStream() {
        Stream<Edge> edgeStream1;
        Stream<Edge> edgeStream2;

        edgeStream1 = p1.edges();
        assertNotNull(edgeStream1);
        assertTrue(edgeStream1.findAny().isPresent());

        edgeStream1 = p1.edges();
        assertNotNull(edgeStream1);
        edgeStream1.forEach(Assertions::assertNotNull);

        edgeStream2 = p2.edges();
        assertNotNull(edgeStream2);
        assertTrue(edgeStream2.findAny().isPresent());

        edgeStream2 = p1.edges();
        assertNotNull(edgeStream2);
        edgeStream2.forEach(Assertions::assertNotNull);
    }

    @Test
    @Order(12)
    public void testPopEdge() {
        Edge e1 = p1.popEdge();
        Edge e2 = p2.popEdge();

        assertNotNull(e1);
        assertNotNull(e2);

        assertEquals("E6", e1.toString().split("\\[")[0]);
        assertEquals("E6", e2.toString().split("\\[")[0]);
    }

    @Test
    @Order(13)
    public void testPopNode() {
        Node n1 = p1.popNode();
        Node n2 = p2.popNode();

        assertNotNull(n1);
        assertNotNull(n2);

        assertEquals("G", n1.toString());
        assertEquals("G", n2.toString());
    }

    @Test
    @Order(14)
    public void testPeekEdge() {
        Edge e1 = p1.peekEdge();
        Edge e2 = p2.peekEdge();

        assertNotNull(e1);
        assertNotNull(e2);

        assertEquals("E4", e1.toString().split("\\[")[0]);
        assertEquals("E4", e2.toString().split("\\[")[0]);
    }

    @Test
    @Order(15)
    public void testPeekNode() {
        Node n1 = p1.peekNode();
        Node n2 = p2.peekNode();

        assertNotNull(n1);
        assertNotNull(n2);

        assertEquals("E", n1.toString());
        assertEquals("E", n2.toString());
    }


    @Test
    @Order(16)
    public void testEquals() {
        Path p3 = new Path();

        assertFalse(p1.equals(p3));
        assertFalse(p3.equals(p1));

        assertFalse(p2.equals(p3));
        assertFalse(p3.equals(p2));

        assertTrue(p1.equals(p2));
        assertTrue(p2.equals(p1));
    }

    @Test
    @Order(17)
    public void testClear() {
        assertFalse(p1.empty());
        assertFalse(p2.empty());

        p1.clear();
        p2.clear();

        assertEquals(0, p1.size());
        assertEquals(0, p2.size());

        assertNull(p1.getRoot());
        assertNull(p2.getRoot());
    }
}
