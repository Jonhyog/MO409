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
import org.learning.utils.SimpleTuple;

import java.util.List;
import java.util.Vector;SingleGra
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.*;

public class MultiGraphTest implements MultiGraphModel {
    
   
    
    @Test
    private void TC_1(){

        MultiGraph g = new MultiGraph();

        Node A = g.addNode("A");
        Node B = g.addNode("B");
        Node C = g.addNode("C");
        Node D = g.addNode("D");

        NodeStub _A = new NodeStub(A);
        NodeStub _B = new NodeStub(B);
        NodeStub _C = new NodeStub(C);
        NodeStub _D = new NodeStub(D);

        //Se der errado não identifica o erro :/
        Edge AB = g.addEdge("AB",A,B,true);
        Edge BC = g.addEdge("BC",B,C,true)

        _A.addOutEdge(AB);
        _B.addInEdge(AB);

        _B.addOutEdge(BC);
        _C.addInEdge(BC);

        //EM VEZ DE RETORNAR, GERAR ERRO
        if(!_A.isSameEdge(A))
            throw new Exception("Erro A");
        if(!_B.isSameEdge(B))
            throw new Exception("Erro B");
        if(!_C.isSameEdge(C))
            throw new Exception("Erro C");
        if(!_D.isSameEdge(D))
            throw new Exception("Erro D");
        


    }

    @Test
    private void TC_2(){

        MultiGraph g = new MultiGraph();

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
        MultiGraph g;
        assertNull(g);
    }

}
