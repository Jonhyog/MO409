package org.learning;

import org.graphstream.graph.ElementNotFoundException;
import org.graphstream.graph.IdAlreadyInUseException;
import org.graphstream.graph.Node;
import org.graphstream.graph.Edge;
import org.graphstream.graph.implementations.SingleGraph;
import org.junit.jupiter.api.Test;
import org.learning.models.SingleGraphModel;
import org.learning.utils.GraphHelper;
import org.learning.utils.SimpleTuple;

import java.util.List;
import java.util.Vector;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.*;

public class SingleGraphTest implements SingleGraphModel {
    SingleGraph g;
    GraphHelper helper;
    Node nodeHelper, nodeGraph;
    Edge edgeHelper, edgeGraph;


    public void e_AddNode() {
        String nodeID = helper.nextId();

        helper.addNode(this.g.addNode(nodeID));
    }

    public void v_NodeNotExists() {
        Exception ex = this.helper.getCapturedException();

        assertThrows(ElementNotFoundException.class, () -> { throw ex; });
    }

    public void v_NodeCreated() {
        Node vertex = this.helper.getLastNode();

        assertNotNull(vertex);
        // assertEquals(vertex.toString(), nodeId) TODO: Verificar IDsMultiGrapaddE
    }

    public void v_EdgeCreated() {
        Edge edge = this.helper.getLastEdge();

        assertNotNull(edge);
    }

    public void e_AddEdge() {
        SimpleTuple<Node, Node> tuple = this.helper.generateRandomEdge();
        String edgeID = this.helper.nextId();

        this.helper.addEdge(this.g.addEdge(edgeID, tuple.x, tuple.y, false));
    }

    public void v_Node() {
        assertEquals(this.nodeGraph, this.nodeHelper);
    }

    public void v_Edge() {
        assertEquals(this.edgeGraph, this.edgeHelper);
    }

    public void e_Reset() {

    }

    public void e_CreateGraph() {
        this.g = new SingleGraph("Test-Graph");
        this.helper = new GraphHelper();
    }

    public void v_SingleGraph() {
        assertNotNull(this.g);
    }

    public void v_EdgeNotExists() {
        Exception ex = this.helper.getCapturedException();

        assertThrows(ElementNotFoundException.class, () -> { throw ex; });
    }

    public void e_GetNode() {
        this.nodeHelper = this.helper.getRandomNode();
        this.nodeGraph = this.g.getNode(nodeHelper.toString());
    }

    public void v_Start() {
        assertNull(this.g);
    }

    public void e_GetEdge() {
        this.edgeHelper = this.helper.getRandomEdge();
        // Edge.toString return <edge-id>[node1--node2] so string must be parsed
        this.edgeGraph = this.g.getEdge(helper.getEdgeId(this.edgeHelper));
    }

    @Override
    public void e_RemoveNonexistentNode() {
        try
        {
            this.g.removeNode(this.helper.nextId());
        }
        catch (Exception ex)
        {
            this.helper.setCapturedException(ex);
        }
    }

    @Override
    public void e_AddExistentNode() {
        Node n = this.helper.getRandomNode();

        try
        {
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
        Exception ex = this.helper.getCapturedException();

        assertThrows(IdAlreadyInUseException.class, () -> { throw ex; });
    }

    @Override
    public void v_NodeRemoved() {
        // FIX-ME?
        assertNotNull(this.helper.getLastRemovedNode());
    }

    @Override
    public void e_RemoveExistingNode() {
        Node n = this.helper.getRandomNode();

        this.helper.removeNode(this.g.removeNode(n));
    }

    @Override
    public void v_EdgeRemoved() {
        // FIX-ME?
        assertNotNull(this.helper.getLastRemovedEdge());
    }

    @Override
    public void e_RemoveExistingEdge() {
        Edge e = this.helper.getRandomEdge();

        this.helper.removeEdge(this.g.removeEdge(e));
    }

    @Override
    public void v_EdgeAlreadyExists() {
        Exception ex = this.helper.getCapturedException();

        assertThrows(IdAlreadyInUseException.class, () -> { throw ex; });
    }

    @Test
    public void modelTest() {
        v_Start();
        e_CreateGraph();
        v_SingleGraph();
        e_AddNode();
        v_NodeCreated();
        e_Reset();
        v_SingleGraph();
        e_GetNode();
        v_Node();
        e_Reset();
        v_SingleGraph();
        e_RemoveNonexistentNode();
        v_NodeNotExists();
        e_Reset();
        v_SingleGraph();
        e_AddNode();
        v_NodeCreated();
        e_Reset();
        v_SingleGraph();
        e_AddNode();
        v_NodeCreated();
        e_Reset();
        v_SingleGraph();
        e_RemoveNonexistentNode();
        v_NodeNotExists();
        e_Reset();
        v_SingleGraph();
        e_GetNode();
        v_Node();
        e_Reset();
        v_SingleGraph();
        e_RemoveExistingNode();
        v_NodeRemoved();
        e_Reset();
        v_SingleGraph();
        e_RemoveNonexistentEdge();
        v_EdgeNotExists();
        e_Reset();
        v_SingleGraph();
        e_RemoveExistingNode();
        v_NodeRemoved();
        e_Reset();
        v_SingleGraph();
        e_GetNode();
        v_Node();
        e_Reset();
        v_SingleGraph();
        e_RemoveNonexistentEdge();
        v_EdgeNotExists();
        e_Reset();
        v_SingleGraph();
        e_RemoveExistingNode();
        v_NodeRemoved();
        e_Reset();
        v_SingleGraph();
        e_AddNode();
        v_NodeCreated();
        e_Reset();
        v_SingleGraph();
        e_RemoveNonexistentNode();
        v_NodeNotExists();
        e_Reset();
        v_SingleGraph();
        e_RemoveNonexistentEdge();
        v_EdgeNotExists();
        e_Reset();
        v_SingleGraph();
        e_GetNode();
        v_Node();
        e_Reset();
        v_SingleGraph();
        e_RemoveNonexistentNode();
        v_NodeNotExists();
        e_Reset();
        v_SingleGraph();
        e_AddExistentNode();
        v_NodeAlreadyExists();
        e_Reset();
        v_SingleGraph();
        e_RemoveNonexistentEdge();
        v_EdgeNotExists();
        e_Reset();
        v_SingleGraph();
        e_AddExistentNode();
        v_NodeAlreadyExists();
        e_Reset();
        v_SingleGraph();
        e_RemoveExistingNode();
        v_NodeRemoved();
        e_Reset();
        v_SingleGraph();
        e_AddNode();
        v_NodeCreated();
        e_Reset();
        v_SingleGraph();
        e_RemoveNonexistentEdge();
        v_EdgeNotExists();
        e_Reset();
        v_SingleGraph();
        e_RemoveExistingNode();
        v_NodeRemoved();
        e_Reset();
        v_SingleGraph();
        e_RemoveNonexistentEdge();
        v_EdgeNotExists();
        e_Reset();
        v_SingleGraph();
        e_RemoveNonexistentEdge();
        v_EdgeNotExists();
        e_Reset();
        v_SingleGraph();
        e_RemoveNonexistentNode();
        v_NodeNotExists();
        e_Reset();
        v_SingleGraph();
        e_RemoveNonexistentEdge();
        v_EdgeNotExists();
        e_Reset();
        v_SingleGraph();
        e_AddNode();
        v_NodeCreated();
        e_Reset();
        v_SingleGraph();
        e_RemoveExistingNode();
        v_NodeRemoved();
        e_Reset();
        v_SingleGraph();
        e_RemoveNonexistentNode();
        v_NodeNotExists();
        e_Reset();
        v_SingleGraph();
        e_RemoveNonexistentEdge();
        v_EdgeNotExists();
        e_Reset();
        v_SingleGraph();
        e_RemoveNonexistentEdge();
        v_EdgeNotExists();
        e_Reset();
        v_SingleGraph();
        e_RemoveNonexistentEdge();
        v_EdgeNotExists();
        e_Reset();
        v_SingleGraph();
        e_RemoveNonexistentNode();
        v_NodeNotExists();
        e_Reset();
        v_SingleGraph();
        e_AddNode();
        v_NodeCreated();
        e_Reset();
        v_SingleGraph();
        e_RemoveNonexistentNode();
        v_NodeNotExists();
        e_Reset();
        v_SingleGraph();
        e_AddNode();
        v_NodeCreated();
        e_Reset();
        v_SingleGraph();
        e_AddEdge();
        v_EdgeCreated();
        e_Reset();
        v_SingleGraph();
        e_AddNode();
        v_NodeCreated();
        e_Reset();
        v_SingleGraph();
        e_AddExistentNode();
        v_NodeAlreadyExists();
        e_Reset();
        v_SingleGraph();
        e_AddExistentNode();
        v_NodeAlreadyExists();
        e_Reset();
        v_SingleGraph();
        e_AddExistentNode();
        v_NodeAlreadyExists();
        e_Reset();
        v_SingleGraph();
        e_GetEdge();
        v_Edge();
        e_Reset();
        v_SingleGraph();
        e_RemoveNonexistentEdge();
        v_EdgeNotExists();
        e_Reset();
        v_SingleGraph();
        e_AddExistentNode();
        v_NodeAlreadyExists();
        e_Reset();
        v_SingleGraph();
        e_GetNode();
        v_Node();
        e_Reset();
        v_SingleGraph();
        e_AddExistentNode();
        v_NodeAlreadyExists();
        e_Reset();
        v_SingleGraph();
        e_GetNode();
        v_Node();
        e_Reset();
        v_SingleGraph();
        e_GetEdge();
        v_Edge();
        e_Reset();
        v_SingleGraph();
        e_RemoveExistingEdge();
        v_EdgeRemoved();
        e_Reset();
        v_SingleGraph();
        e_AddExistentNode();
        v_NodeAlreadyExists();
        e_Reset();
        v_SingleGraph();
        e_RemoveNonexistentEdge();
        v_EdgeNotExists();
        e_Reset();
        v_SingleGraph();
        e_GetNode();
        v_Node();
        e_Reset();
        v_SingleGraph();
        e_RemoveExistingNode();
        v_NodeRemoved();
        e_Reset();
        v_SingleGraph();
        e_AddNode();
        v_NodeCreated();
        e_Reset();
        v_SingleGraph();
        e_GetNode();
        v_Node();
        e_Reset();
        v_SingleGraph();
        e_RemoveExistingNode();
        v_NodeRemoved();
        e_Reset();
        v_SingleGraph();
        e_AddExistentNode();
        v_NodeAlreadyExists();
        e_Reset();
        v_SingleGraph();
        e_AddExistentNode();
        v_NodeAlreadyExists();
        e_Reset();
        v_SingleGraph();
        e_RemoveExistingNode();
        v_NodeRemoved();
        e_Reset();
        v_SingleGraph();
        e_GetNode();
        v_Node();
        e_Reset();
        v_SingleGraph();
        e_RemoveExistingNode();
        v_NodeRemoved();
        e_Reset();
        v_SingleGraph();
        e_AddNode();
        v_NodeCreated();
        e_Reset();
        v_SingleGraph();
        e_RemoveNonexistentEdge();
        v_EdgeNotExists();
        e_Reset();
        v_SingleGraph();
        e_AddNode();
        v_NodeCreated();
        e_Reset();
        v_SingleGraph();
        e_RemoveNonexistentNode();
        v_NodeNotExists();
        e_Reset();
        v_SingleGraph();
        e_RemoveExistingNode();
        v_NodeRemoved();
        e_Reset();
        v_SingleGraph();
        e_AddNode();
        v_NodeCreated();
        e_Reset();
        v_SingleGraph();
        e_AddEdge();
        v_EdgeCreated();
        e_Reset();
        v_SingleGraph();
        e_AddEdge();
        v_EdgeCreated();
        e_Reset();
        v_SingleGraph();
        e_AddNode();
        v_NodeCreated();
        e_Reset();
        v_SingleGraph();
        e_GetNode();
        v_Node();
        e_Reset();
        v_SingleGraph();
        e_RemoveNonexistentEdge();
        v_EdgeNotExists();
        e_Reset();
        v_SingleGraph();
        e_AddEdge();
        v_EdgeCreated();
        e_Reset();
        v_SingleGraph();
        e_RemoveExistingEdge();
        v_EdgeRemoved();
        e_Reset();
        v_SingleGraph();
        e_AddEdge();
        v_EdgeCreated();
        e_Reset();
        v_SingleGraph();
        e_AddNode();
        v_NodeCreated();
        e_Reset();
        v_SingleGraph();
        e_GetEdge();
        v_Edge();
        e_Reset();
        v_SingleGraph();
        e_RemoveNonexistentNode();
        v_NodeNotExists();
        e_Reset();
        v_SingleGraph();
        e_AddNode();
        v_NodeCreated();
        e_Reset();
        v_SingleGraph();
        e_GetNode();
        v_Node();
        e_Reset();
        v_SingleGraph();
        e_AddEdge();
        v_EdgeCreated();
        e_Reset();
        v_SingleGraph();
        e_RemoveNonexistentNode();
        v_NodeNotExists();
        e_Reset();
        v_SingleGraph();
        e_AddNode();
        v_NodeCreated();
        e_Reset();
        v_SingleGraph();
        e_GetNode();
        v_Node();
        e_Reset();
        v_SingleGraph();
        e_AddExistentNode();
        v_NodeAlreadyExists();
        e_Reset();
        v_SingleGraph();
        e_AddExistentEdge();
        v_EdgeAlreadyExists();
        e_Reset();
        v_SingleGraph();

    }
}
