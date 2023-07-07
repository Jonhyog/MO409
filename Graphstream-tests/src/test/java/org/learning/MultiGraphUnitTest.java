package org.learning;

import org.graphstream.graph.implementations.MultiGraph;
import org.junit.jupiter.api.*;
import org.learning.utils.MultiGraphUt;

import static org.junit.jupiter.api.Assertions.*;

public class MultiGraphUnitTest {
    protected static MultiGraph g;

    @Test
    public void smallerCapacity() {
       MultiGraphUt g = new MultiGraphUt("Test", false,true,10,10);

       assertEquals(g.getMaxNode(),128);
       assertEquals(g.getMaxEdge(),1024);
    }

    @Test
    public void largerCapacity() {
        MultiGraphUt g = new MultiGraphUt("Test", false,true,200,2000);

        assertEquals(g.getMaxNode(),200);
        assertEquals(g.getMaxEdge(),2000);
    }

    @Test
    public void getNodeNegative(){
        MultiGraphUt g = new MultiGraphUt("Test", false,true,200,2000);

        assertEquals(g.getMaxNode(),200);
        assertEquals(g.getMaxEdge(),2000);

        g.addEdge("AB","A","B",false);
        g.addEdge("BC","B","C",false);
        g.addEdge("CD","C","D",false);

        assertThrows(IndexOutOfBoundsException.class, () -> {
            g.getNode(-1);
        });
    }

    @Test
    public void getNodeAboveLimit(){
        MultiGraphUt g = new MultiGraphUt("Test", false,true,200,2000);

        assertEquals(g.getMaxNode(),200);
        assertEquals(g.getMaxEdge(),2000);

        g.addEdge("AB","A","B",false);
        g.addEdge("BC","B","C",false);
        g.addEdge("CD","C","D",false);
        g.addEdge("CD1","C","D",false);
        g.addEdge("CD2","C","D",false);

        assertThrows(IndexOutOfBoundsException.class, () -> {
            g.getNode(6);
        });

    }
    
}
