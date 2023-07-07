package org.learning;

import org.graphstream.graph.implementations.SingleGraph;
import org.junit.jupiter.api.*;
import org.learning.utils.SingleGraphUt;


import javax.sound.midi.SysexMessage;

import static org.junit.jupiter.api.Assertions.*;

public class SingleGraphUnitTest {
    protected static SingleGraph g;

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
            System.out.println(g.getNode(4));
        });
    }

    
}
