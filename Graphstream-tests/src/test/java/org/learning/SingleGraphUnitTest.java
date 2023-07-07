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

public class SingleGraphUnityTests {
    protected static SingleGraph g;


    @Test
    public static void smallerCapacity() {

       SingleGraphUt g = new SingleGraph("Test", false,true,10,10);
       assertEqual(g.getMaxNode(),128);
       assertEqual(g.getMaxEdge(),1024);

    }
    @Test
    public static void largerCapacity() {

        SingleGraphUt g = new SingleGraph("Test", false,true,200,2000);
        assertEqual(g.getMaxNode(),200);
        assertEqual(g.getMaxEdge(),2000);

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public static void getNodeNegative(){
        SingleGraph g = new SingleGraph("Test", false,true,200,2000);
        assertEqual(g.getMaxNode(),200);
        assertEqual(g.getMaxEdge(),2000);
        g.addEdge("AB","A","B",false);
        g.addEdge("BC","B","C",false);
        g.addEdge("CD","C","D",false);
        g.getNode(-1);
        

    }
    @Test(expected = IndexOutOfBoundsException.class)
    public static void getNodeAboveLimite(){
        SingleGraph g = new SingleGraph("Test", false,true,200,2000);
        assertEqual(g.getMaxNode(),200);
        assertEqual(g.getMaxEdge(),2000);
        g.addEdge("AB","A","B",false);
        g.addEdge("BC","B","C",false);
        g.addEdge("CD","C","D",false);
        g.getNode(4);

    }
    
}
