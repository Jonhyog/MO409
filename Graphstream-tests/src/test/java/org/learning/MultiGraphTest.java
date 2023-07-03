package org.learning;

import org.graphstream.graph.ElementNotFoundException;
import org.graphstream.graph.IdAlreadyInUseException;
import org.graphstream.graph.Node;
import org.graphstream.graph.Edge;
import org.graphstream.graph.implementations.MultiGraph;
import org.junit.jupiter.api.Test;
import org.learning.models.MultiGraphModel;
import org.learning.utils.GraphHelper;
import org.learning.utils.SimpleTuple;

import java.util.List;
import java.util.Vector;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.*;

public class MultiGraphTest implements MultiGraphModel {
    //Utilitários
    MultiGraph g;
    GraphHelper helper;
    Node nodeHelper, nodeGraph;
    Edge edgeHelper, edgeGraph;


    public void e_AddNode() {
        String nodeID = helper.nextId();
        Node newNode = this.g.addNode(nodeID);
        helper.addNode(newNode);
    }

    public void v_NodeNotExists() {
        //Verifica se há uma exceção e se ela foi gerada pelo erro
        Exception ex = this.helper.getCapturedException();

        assertThrows(ElementNotFoundException.class, () -> { throw ex; });
    }

    public void v_NodeCreated() {

    }

    public void v_EdgeCreated() {

        //Verifica se a última aresta criada foi , de fato, a inserida
        Edge edge = this.helper.getLastEdge();
        assertNotNull(edge);

    }

    public void e_AddEdge() {
    //Gera tupla de vértices aleatórios
    SimpleTuple<Node, Node> tuple = this.helper.generateRandomEdge();
    //Gera um id novo incrementado do último
    String edgeID = this.helper.nextId();
    //Adiciona a adge nova no helper
    this.helper.addEdge(this.g.addEdge(edgeID, tuple.x, tuple.y, false));

    }

    public void v_Node() {

    }

    public void v_Edge() {

    }

    public void e_Reset() {
        //Não faz nada :(
    }

    public void e_CreateGraph() {
        this.g = new MultiGraph("Test-Graph");
        this.helper = new GraphHelper();
    }

    public void v_MultiGraph() {
        //O grafo deve existir
        assertNotNull(this.g);
    }

    public void v_EdgeNotExists() {

    }

    public void e_GetNode() {
        //Pega um nó aleatóriamente
        //OBS:Pegar o último nó visitado é uma opção boa tbm
        this.nodeHelper = this.helper.getRandomNode();
        this.nodeGraph = this.g.getNode(nodeHelper.toString());
    }

    public void v_Start() {
        assertNull(this.g);
    }

    public void e_GetEdge() {
        //Esse aqui eu confiei

        this.edgeHelper = this.helper.getRandomEdge();
        // Edge.toSting return <edge-id>[node1--node2] so string must be parsed
        this.edgeGraph = this.g.getEdge(helper.getEdgeId(this.edgeHelper));
    }

    @Override
    public void e_RemoveNonexistentNode() {
        this.helper.setCapturedException(null);
        try
        {   
            //Remove um nó que não existe pois nextId não existe
            //Deve gerar erro
            this.g.removeNode(this.helper.nextId());
        }
        catch (Exception ex)
        {   //Salva a exceção capturada
            this.helper.setCapturedException(ex);
        }
    }

    @Override
    public void e_AddExistentNode() {
        //Pega um nó que já existe
        Node n = this.helper.getRandomNode();
        this.helper.setCapturedException(null);
        try
        {   //Tenta adicionar
            this.g.addNode(n.toString());
        }
        catch (Exception ex)
        {   
            this.helper.setCapturedException(ex);
        }
    }

    @Override
    public void e_AddExistentEdge() {
        Edge e = this.helper.getRandomEdge();
        this.helper.setCapturedException(null);

        try
        {
            String edgeID = helper.getEdgeId(e);
            this.g.addEdge(edgeID, e.getNode0(), e.getNode1());
        }
        catch (Exception ex)
        {
            this.helper.setCapturedException(ex);
        }
    }

    @Override
    public void e_RemoveNonexistentEdge() {
        this.helper.setCapturedException(null);
        try
        {
            this.g.removeEdge(this.helper.nextId());
        }
        catch (Exception ex)
        {
            this.helper.setCapturedException(ex);
        }
    }
    @Override
    public void v_NodeAlreadyExists() {

    }

    @Override
    public void v_NodeRemoved() {

    }

    @Override
    public void e_RemoveExistingNode() {
        //Escolhe um nó salvo no helper e remove
        Node n = this.helper.getRandomNode();

        this.helper.removeNode(this.g.removeNode(n));
    }

    @Override
    public void v_EdgeRemoved() {

    }

    @Override
    public void e_RemoveExistingEdge() {
        //Escolhe uma edge aleatória e remove
        Edge e = this.helper.getRandomEdge();

        this.helper.removeEdge(this.g.removeEdge(e));
    }

    @Override
    public void v_EdgeAlreadyExists() {

    }

    @Test
    public void modelTest() {
        v_Start();
        e_CreateGraph();
        v_MultiGraph();
        e_AddEdge();
        v_EdgeCreated();
        e_Reset();
        v_MultiGraph();
        e_AddNode();
        v_NodeCreated();
        e_Reset();
        v_MultiGraph();
        e_AddEdge();
        v_EdgeCreated();
        e_Reset();
        v_MultiGraph();
        e_GetNode();
        v_Node();
        e_Reset();
        v_MultiGraph();
        e_RemoveNode();
        v_NodeExists();
        e_Reset();
        v_MultiGraph();
        e_RemoveEdge();
        v_EdgeExists();
        e_Reset();
        v_MultiGraph();
        e_RemoveNode();
        v_NodeExists();
        e_Reset();
        v_MultiGraph();
        e_GetEdge();
        v_Edge();
        e_Reset();
        v_MultiGraph();
        e_AddEdge();
        v_EdgeCreated();
        e_Reset();
        v_MultiGraph();
        e_GetEdge();
        v_Edge();
        e_Reset();
        v_MultiGraph();
        e_RemoveNode();
        v_NodeExists();
        e_Reset();
        v_MultiGraph();
        e_AddNode();
        v_NodeExists();
        e_Reset();
        v_MultiGraph();
        e_AddEdge();
        v_EdgeCreated();
        e_Reset();
        v_MultiGraph();
        e_RemoveNode();
        v_NodeExists();
        e_Reset();
        v_MultiGraph();
        e_RemoveNode();
        v_NodeNotExist();
        e_Reset();
        v_MultiGraph();
        e_RemoveNode();
        v_NodeNotExist();
        e_Reset();
        v_MultiGraph();
        e_RemoveNode();
        v_NodeNotExist();
        e_Reset();
        v_MultiGraph();
        e_RemoveNode();
        v_NodeNotExist();
        e_Reset();
        v_MultiGraph();
        e_RemoveNode();
        v_NodeNotExist();
        e_Reset();
        v_MultiGraph();
        e_RemoveNode();
        v_NodeNotExist();
        e_Reset();
        v_MultiGraph();
        e_AddNode();
        v_NodeExists();
        e_Reset();
        v_MultiGraph();
        e_GetNode();
        v_Node();
        e_Reset();
        v_MultiGraph();
        e_RemoveEdge();
        v_EdgeExists();
        e_Reset();
        v_MultiGraph();
        e_RemoveNode();
        v_NodeNotExist();
        e_Reset();
        v_MultiGraph();
        e_RemoveNode();
        v_NodeExists();
        e_Reset();
        v_MultiGraph();
        e_AddNode();
        v_NodeExists();
        e_Reset();
        v_MultiGraph();
        e_GetEdge();
        v_Edge();
        e_Reset();
        v_MultiGraph();
        e_AddNode();
        v_NodeExists();
        e_Reset();
        v_MultiGraph();
        e_RemoveNode();
        v_NodeExists();
        e_Reset();
        v_MultiGraph();
        e_AddEdge();
        v_EdgeCreated();
        e_Reset();
        v_MultiGraph();
        e_AddEdge();
        v_EdgeCreated();
        e_Reset();
        v_MultiGraph();
        e_RemoveNode();
        v_NodeNotExist();
        e_Reset();
        v_MultiGraph();
        e_AddNode();
        v_NodeCreated();
        e_Reset();
        v_MultiGraph();
        e_AddEdge();
        v_EdgeCreated();
        e_Reset();
        v_MultiGraph();
        e_GetNode();
        v_Node();
        e_Reset();
        v_MultiGraph();
        e_GetEdge();
        v_Edge();
        e_Reset();
        v_MultiGraph();
        e_RemoveNode();
        v_EdgeNotExists();
        e_Reset();
        v_MultiGraph();



    }
}
