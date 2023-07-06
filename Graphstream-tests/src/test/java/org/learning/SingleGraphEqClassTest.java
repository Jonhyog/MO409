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
import org.learning.utils.SimpleTuple;

import java.util.List;
import java.util.Vector;SingleGra
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.*;

public class SingleGraphEqClassTest {
    
   
    
    @Test
    private void TC_1(){

        SingleGraph g = new SingleGraph();

        Node A = g.addNode("A");
        Node B = g.addNode("B");
        Node C = g.addNode("C");
        Node D = g.addNode("D");

        NodeStub _A = new NodeStub(A,g);
        NodeStub _B = new NodeStub(B,g);
        NodeStub _C = new NodeStub(C,g);
        NodeStub _D = new NodeStub(D,g);


        _A.addEdge(A,B,true,_B);
        _B.addEdge(B,C,true,_C);

        //EM VEZ DE RETORNAR, GERAR ERRO
        if(!_A.isSameEdge(A))
            throw new Exception("Erro A");
        if(!_B.isSameEdge(B))
            throw new Exception("Erro B");
        if(!_C.isSameEdge(C))
            throw new Exception("Erro C");
        if(!_C.isSameEdge(C))
            throw new Exception("Erro D");
        


    }

    @Test
    private void TC_2(){

        SingleGraph g = new SingleGraph();

        Node A = g.addNode("A");
        Node B = g.addNode("B");
        Node C = g.addNode("C");


        NodeStub _A = new NodeStub(A,g);
        NodeStub _B = new NodeStub(B,g);
        NodeStub _C = new NodeStub(C,g);


        _A.addEdge(A,B,false,_B);
        _B.addEdge(B,C,false,_C);
        _C.addEdge(C,A,false,_A);

        //EM VEZ DE RETORNAR, GERAR ERRO
        if(!_A.isSameEdge(A))
            throw new Exception("Erro A");
        if(!_B.isSameEdge(B))
            throw new Exception("Erro B");
        if(!_C.isSameEdge(C))
            throw new Exception("Erro C");

        

    }

    @Test
    private void TC_3(){
        " ¯\_(ツ)_/¯"
        SingleGraph g;
        assertNull(g);
    }

}
