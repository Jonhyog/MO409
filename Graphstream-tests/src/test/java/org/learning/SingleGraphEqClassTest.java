package org.learning;

import org.graphstream.graph.ElementNotFoundException;
import org.graphstream.graph.IdAlreadyInUseException;
import org.graphstream.graph.Node;
import org.graphstream.graph.Edge;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.graph.implementations.SingleNode;
import org.junit.jupiter.api.Test;
import org.learning.models.SingleGraphModel;
import org.learning.utils.GraphHelper;
import org.learning.utils.NodeStub;
import org.learning.utils.SimpleTuple;

import java.util.List;
import java.util.Vector;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.*;

public class SingleGraphEqClassTest {
    
   
    
    @Test
    public void TC_1(){

        SingleGraph g = new SingleGraph("EPO");

        Node A = g.addNode("A");
        Node B = g.addNode("B");
        Node C = g.addNode("C");
        Node D = g.addNode("D");

        NodeStub _A = new NodeStub(A, g);
        NodeStub _B = new NodeStub(B, g);
        NodeStub _C = new NodeStub(C, g);
        NodeStub _D = new NodeStub(D, g);


        _A.addEdge(A, B,true, _B);
        _B.addEdge(B, C,true, _C);

        assertTrue(_A.isSameEdge(A));
        assertTrue(_B.isSameEdge(B));
        assertTrue(_C.isSameEdge(C));
    }

    @Test
    public void TC_2(){

        SingleGraph g = new SingleGraph("EPO");

        Node A = g.addNode("A");
        Node B = g.addNode("B");
        Node C = g.addNode("C");


        NodeStub _A = new NodeStub(A,g);
        NodeStub _B = new NodeStub(B,g);
        NodeStub _C = new NodeStub(C,g);


        _A.addEdge(A,B,false,_B);
        _B.addEdge(B,C,false,_C);
        _C.addEdge(C,A,false,_A);

        assertTrue(_A.isSameEdge(A));
        assertTrue(_B.isSameEdge(B));
        assertTrue(_C.isSameEdge(C));
    }

    @Test
    public void TC_3(){
        // ¯\_(ツ)_/¯
        SingleGraph g = null;
        assertNull(g);
    }

}
