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

public class SingleGraphTest implements SingleGraphModel {
    
   
    
    @Test
    private void TC_1(){

        SingleGraph g = new SingleGraph();

        Node A = g.addNode("A");
        Node B = g.addNode("B");
        Node C = g.addNode("C");
        Node D = g.addNode("D");

        NodeStub _A = new NodeStub(A);
        NodeStub _B = new NodeStub(B);
        NodeStub _C = new NodeStub(C);
        NodeStub _D = new NodeStub(D);

        _A.addOutEdge(g.addEdge("AB",A,B,true));
        _B.addOutEdge(g.addEdge("BC",B,C,true));
        _B.addOutEdge(g.addEdge("BC",B,D,true));
        _C.addOutEdge(g.addEdge("BC",C,D,true));

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

        NodeStub _A = new NodeStub(A);
        NodeStub _B = new NodeStub(B);
        NodeStub _C = new NodeStub(C);

        _A.addOutEdge(g.addEdge("AB",A,B,false));
        _B.addOutEdge(g.addEdge("BC",B,C,false));
        _C.addOutEdge(g.addEdge("CA",C,A,false));



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

    @Test
    public void eqClassTest() {
        


    }
}
