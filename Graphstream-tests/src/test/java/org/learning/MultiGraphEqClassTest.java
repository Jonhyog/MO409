package org.learning;

import org.graphstream.graph.ElementNotFoundException;
import org.graphstream.graph.IdAlreadyInUseException;
import org.graphstream.graph.Node;
import org.graphstream.graph.Edge;
import org.graphstream.graph.implementations.MultiGraph;
import org.graphstream.graph.implementations.SingleNode;
import org.junit.jupiter.api.Test;
import org.learning.models.MultiGraphModel;
import org.learning.utils.GraphHelper;
import org.learning.utils.NodeStub;
import org.learning.utils.SimpleTuple;

import java.util.List;
import java.util.Vector;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.*;

public class MultiGraphEqClassTest{
    
   
    
    @Test
    public void TC_1(){

        MultiGraph g = new MultiGraph("EPO");

        Node A = g.addNode("A");
        Node B = g.addNode("B");
        Node C = g.addNode("C");

        NodeStub _A = new NodeStub(A, g);
        NodeStub _B = new NodeStub(B, g);
        NodeStub _C = new NodeStub(C, g);

        //A-B-C
        _A.addEdge(A,B,true,_B);
        _B.addEdge(B,C,true,_C);

        assertTrue(_A.isSameEdge(A));
        assertTrue(_B.isSameEdge(B));
        assertTrue(_C.isSameEdge(C));

        assertEquals(3, g.getNodeCount());
        assertEquals(2, g.getEdgeCount());
    }

    @Test
    public void TC_2(){

        MultiGraph g = new MultiGraph("EPO");

        Node A = g.addNode("A");
        Node B = g.addNode("B");
        Node C = g.addNode("C");


        NodeStub _A = new NodeStub(A,g);
        NodeStub _B = new NodeStub(B,g);
        NodeStub _C = new NodeStub(C,g);


        /*   < -
            B< - > A <-> C
            ^------------^  
         */
        _A.addEdge(A,B,false,_B);
        _A.addEdge("AB1",A,B,false,_B);
        _A.addEdge(A,C,false,_C);
        

        _B.addEdge(B,A,false,_A);
        _B.addEdge(B,C,false,_C);

        _C.addEdge(C,A,false,_A);
        _C.addEdge(C,B,false,_B);

        assertTrue(_A.isSameEdge(A));
        assertTrue(_B.isSameEdge(B));
        assertTrue(_C.isSameEdge(C));

        assertEquals(3, g.getNodeCount());
        assertEquals(7, g.getEdgeCount());
    }

    @Test
    public void TC_3(){
        // ¯\_(ツ)_/¯
        MultiGraph g = null;
        assertNull(g);
    }

}
