package org.learning;

import org.graphstream.graph.Edge;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;
import org.junit.jupiter.api.*;
import org.learning.utils.SingleGraphUt;


import javax.sound.midi.SysexMessage;

import java.util.List;
import java.util.Vector;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class SingleGraphUnitTest {
    protected static SingleGraph graph;

    @BeforeAll
    public static void setup() {
        String[] nodeList = {"A", "B", "C", "D", "E", "G", "H"};
        List<Node> nodes = new Vector<>();

        graph = new SingleGraph("Graph");

        for (String nodeID : nodeList) {
            nodes.add(graph.addNode(nodeID));
        }

        graph.addEdge("E1", nodes.get(0), nodes.get(1));
        graph.addEdge("E2", nodes.get(1), nodes.get(2));
        graph.addEdge("E3", nodes.get(2), nodes.get(3));
        graph.addEdge("E4", nodes.get(3), nodes.get(4));
        graph.addEdge("E5", nodes.get(4), nodes.get(5));
        graph.addEdge("E6", nodes.get(5), nodes.get(6));

    }

    @AfterAll
    public static void teardown() {
        graph.clear();
    }

    @Test
    public void testNodeStream() {
        Stream<Node> nodeStream;

        nodeStream = graph.nodes();
        assertNotNull(nodeStream);
        assertTrue(nodeStream.findAny().isPresent());

        nodeStream = graph.nodes();
        assertNotNull(nodeStream);
        nodeStream.forEach(Assertions::assertNotNull);
    }

    @Test
    public void testEdgeStream() {
        Stream<Edge> edgeStream;

        edgeStream = graph.edges();
        assertNotNull(edgeStream);
        assertTrue(edgeStream.findAny().isPresent());

        edgeStream = graph.edges();
        assertNotNull(edgeStream);
        edgeStream.forEach(Assertions::assertNotNull);
    }

    @Test
    public void testGetNode() {
        String[] nodeList = {"A", "B", "C", "D", "E", "G", "H"};

        for (String nodeID : nodeList) {
            Node n = graph.getNode(nodeID);

            assertNotNull(n);
            assertEquals(nodeID, n.toString());
        }

        for (int i = 0; i < nodeList.length; i++) {
            Node n = graph.getNode(nodeList[i]);

            assertNotNull(n);
            assertEquals(nodeList[i], n.toString());
        }
    }

    @Test
    public void testGetEdge() {
        String[] edgeList = {"E1", "E2", "E3", "E4", "E5", "E6"};

        for (String edgeID : edgeList) {
            Edge e = graph.getEdge(edgeID);

            assertNotNull(e);
            assertEquals(edgeID, e.toString().split("\\[")[0]);
        }

        for (int i = 0; i < edgeList.length; i++) {
            Edge e = graph.getEdge(edgeList[i]);

            assertNotNull(e);
            assertEquals(edgeList[i], e.toString().split("\\[")[0]);
        }

    }
    
    @Test
    public void smallerCapacity() {
       SingleGraphUt g = new SingleGraphUt("Test", false,true,10,10);

       assertEquals(g.getMaxNode(),128);
       assertEquals(g.getMaxEdge(),1024);
    }

    @Test
    public void largerCapacity() {
        SingleGraphUt g = new SingleGraphUt("Test", false,true,200,2000);

        assertEquals(g.getMaxNode(),200);
        assertEquals(g.getMaxEdge(),2000);
    }

    @Test
    public void getNodeNegative(){
        SingleGraphUt g = new SingleGraphUt("Test", false,true,200,2000);

        assertEquals(g.getMaxNode(), 200);
        assertEquals(g.getMaxEdge(), 2000);

        g.addEdge("AB","A","B",false);
        g.addEdge("BC","B","C",false);
        g.addEdge("CD","C","D",false);

        assertThrows(IndexOutOfBoundsException.class, () -> {
            g.getNode(-1);
        });
    }

    @Test
    public void getNodeAboveLimit(){
        SingleGraphUt g = new SingleGraphUt("Test", false,true,200,2000);

        assertEquals(g.getMaxNode(),200);
        assertEquals(g.getMaxEdge(),2000);

        g.addEdge("AB","A","B",false);
        g.addEdge("BC","B","C",false);
        g.addEdge("CD","C","D",false);

        assertThrows(IndexOutOfBoundsException.class, () -> {
            g.getNode(4);
        });
    }

    @Test
    public void getEdgeNegative(){
        SingleGraphUt g = new SingleGraphUt("Test", false,true,200,2000);

        assertEquals(g.getMaxNode(), 200);
        assertEquals(g.getMaxEdge(), 2000);

        g.addEdge("AB","A","B",false);
        g.addEdge("BC","B","C",false);
        g.addEdge("CD","C","D",false);

        assertThrows(IndexOutOfBoundsException.class, () -> {
            g.getEdge(-1);
        });
    }

    @Test
    public void getEdgeAboveLimit(){
        SingleGraphUt g = new SingleGraphUt("Test", false,true,200,2000);

        assertEquals(g.getMaxNode(),200);
        assertEquals(g.getMaxEdge(),2000);

        g.addEdge("AB","A","B",false);
        g.addEdge("BC","B","C",false);
        g.addEdge("CD","C","D",false);

        assertThrows(IndexOutOfBoundsException.class, () -> {
            g.getEdge(4);
        });
    }
}
