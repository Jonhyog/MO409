package org.learning;

import org.graphstream.graph.*;
import org.junit.jupiter.api.Test;
import org.learning.models.PathModel;
import org.learning.utils.PathHelper;
import org.learning.utils.SimpleTuple;

import javax.sound.midi.SysexMessage;
import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

public class PathTest implements PathModel {

    protected PathHelper helper = new PathHelper();
    protected Path p;

    protected Node lastAddedNode;
    protected Edge lastAddedEdge;
    protected Node lastPeekNode;
    protected Edge lastPeekEdge;

    protected Node lastPopNode;
    protected Edge lastPopEdge;

    protected Graph g;

    public void v_Start() {
        assertNull(this.g);
    }

    public void v_NullRoot(){

        Exception ex = this.helper.getCapturedException();
        assertThrows(IllegalArgumentException.class, () -> { throw ex; });

    }

    public void v_NotContainsEdge() {

        Exception ex = this.helper.getCapturedException();
        assertThrows(IllegalArgumentException.class, () -> { throw ex; });

    }
    public void v_InvalidHead() {

        Exception ex = this.helper.getCapturedException();
        assertThrows(IllegalArgumentException.class, () -> { throw ex; });

    }
    public void v_EmptyStack(){
        Exception ex = this.helper.getCapturedException();
        assertThrows(EmptyStackException.class, () -> { throw ex; });
    }

    public void v_EmptyEdgePopException() {
        Exception ex = this.helper.getCapturedException();
        assertThrows(EmptyStackException.class, () -> { throw ex; });
    }
    public void v_PopEdge() {
        assertEquals(this.lastPopEdge.toString(), this.helper.getLastPopEdge().toString());
    }

    public void v_EmptyNodePopException() {
        Exception ex = this.helper.getCapturedException();
        assertThrows(EmptyStackException.class, () -> { throw ex; });
    }

    public void v_PopNode(){
        assertEquals(this.lastPopNode.toString(), this.helper.getLastPopNode().toString());
    }

    public void v_Path(){
       assertNotNull(this.p);
    }

    public void e_CreatePath(){
        this.p = new Path();
        this.g = helper.createSimpleGraph();
    }

    @Override
    public void e_PeekWhileEmptyEdge() {
            this.helper.setCapturedException(null);
            try
            { 
                p.peekEdge();
            }
            catch (Exception ex)
            {
                this.helper.setCapturedException(ex);
            }
    }

    @Override
    public void v_EdgePeeked() {
        assertEquals(this.lastPeekEdge.toString(), this.helper.getLastPeekEdge().toString());
    }

    @Override
    public void e_PeekWhileEmptyNode() {
            
            this.helper.setCapturedException(null);
            try
            { 
                p.peekNode();
                System.out.println(p.size());
            }
            catch (Exception ex)
            {
                this.helper.setCapturedException(ex);
            }
    }

    @Override
    public void v_NodePeeked() {
        assertEquals(this.lastPeekNode.toString(), this.helper.getLastPeekNode().toString());
    }

    public void e_Reset(){
        //Estado de transição
    }

    public void e_AddNodeEdge() {
        //Fé
        SimpleTuple<String, String> t = this.helper.getNewEdge();
        System.out.println(t);
        String a = t.x;
        String b = t.y;

        this.helper.addEdge(a, b);

        StringBuilder sb = new StringBuilder();
        sb.append(a);
        sb.append(b);
        String str = sb.toString();
//        System.out.println(str);
        g.addEdge(str, a, b);

        Node from = g.getNode(a);
//        System.out.println(System.identityHashCode(from));

        Edge edge = g.getEdge(str);

//        System.out.println(edge);

        p.add(from, edge);
        System.out.println("Test:" + edge);

        this.lastAddedEdge = edge;
    }

    public void e_AddWithNullRoot() {
        //Precisa que root != NULL
        p.clear();
        this.helper.clear();
//        Node n = p.getRoot();
//        p.setRoot(null);
        this.helper.setCapturedException(null);
            try
            { 
                p.add(null);
            }
            catch (Exception ex)
            {
                this.helper.setCapturedException(ex);
            }
    }

    public void e_AddNotContainsEdge() {
        //Fé²
        try
        {
            SimpleTuple<String, String> t = helper.getNewEdge();
            SimpleTuple<String, String> z = helper.getNewEdge();

            String a = t.x;
            String b = t.y;

            String c = z.x + "magic";
            String d = z.y + "magic";

            StringBuilder sb1 = new StringBuilder();
            sb1.append(a);
            sb1.append(b);
            String str1 = sb1.toString();

            StringBuilder sb2 = new StringBuilder();
            sb2.append(c);
            sb2.append(d);
            String str2 = sb2.toString();

            g.addEdge(str1, a, b);
            g.addEdge(str2, c, d);

            Node from = g.getNode(a);
            Edge edge = g.getEdge(str2);

            System.out.println(a);
            System.out.println(b);
            System.out.println(c);
            System.out.println(d);
            System.out.println(edge.getSourceNode());
            System.out.println(edge.getTargetNode());
            p.add(from, edge);
            this.lastAddedEdge = edge;
            System.out.println("Exception:" + edge);
        }
        catch (Exception ex)
        {
          this.helper.setCapturedException(ex);
        }

    }

    @Override
    public void v_Add() {
        assertEquals(p.peekEdge(), this.lastAddedEdge);
    }

    public void e_InvalidHead() {
        Graph graph = this.helper.createSimpleGraph();

        //Não sei se isso funciona
        graph.addEdge("ixiz", "ix", "iz");
        //graph.addEdge("xz", "x", "z");

        //XZ não faz parte de p;
        this.helper.setCapturedException(null);
        try
        {   
            this.p.add(graph.getEdge("ixiz"));

        }
        catch (Exception ex)
        {
            this.helper.setCapturedException(ex);
        }
    }
    public void e_PeekEdge() {
        this.lastPeekEdge = p.peekEdge();
        helper.PeekEdge();
    }

    public void e_PeekNode() {
        this.lastPeekNode = p.peekNode();
        this.helper.PeekNode();
    }

    public void e_PopEdge() {
        this.lastPopEdge = p.popEdge();
        helper.PopEdge();
    }

    public void e_PopNode() {
        this.lastPopNode = p.popNode();
        helper.PopNode();
    }

    public void e_PopWhileEmptyEdge() {
        this.helper.setCapturedException(null);
        try
        {
            this.lastPopEdge = p.popEdge();
        }
        catch (Exception ex)
        {
            this.helper.setCapturedException(ex);
        }

    }

    public void e_PopWhileEmptyNode() {

        this.helper.setCapturedException(null);
        try
        {
            this.lastPeekNode = p.popNode();
        }
        catch (Exception ex)
        {
            this.helper.setCapturedException(ex);
        }

    }

    @Test
    public void modelTest() {
        v_Start();
        e_CreatePath();
        v_Path();
        e_AddNodeEdge();
        v_Add();
        e_Reset();
        v_Path();
        e_InvalidHead();
        v_InvalidHead();
        e_Reset();
        v_Path();
        e_PeekNode();
        v_NodePeeked();
        e_Reset();
        v_Path();
        e_PeekNode();
        v_NodePeeked();
        e_Reset();
        v_Path();
        e_PopNode();
        v_PopNode();
        e_Reset();
        v_Path();
        e_AddNodeEdge();
        v_Add();
        e_Reset();
        v_Path();
        e_InvalidHead();
        v_InvalidHead();
        e_Reset();
        v_Path();
        e_AddNodeEdge();
        v_Add();
        e_Reset();
        v_Path();
        e_InvalidHead();
        v_InvalidHead();
        e_Reset();
        v_Path();
        e_AddNodeEdge();
        v_Add();
        e_Reset();
        v_Path();
        e_InvalidHead();
        v_InvalidHead();
        e_Reset();
        v_Path();
        e_PeekNode();
        v_NodePeeked();
        e_Reset();
        v_Path();
        e_PeekEdge();
        v_EdgePeeked();
        e_Reset();
        v_Path();
        e_AddNotContainsEdge();
        v_NotContainsEdge();
        e_Reset();
        v_Path();
        e_InvalidHead();
        v_InvalidHead();
        e_Reset();
        v_Path();
        e_PopEdge();
        v_PopEdge();
        e_Reset();
        v_Path();
        e_AddNodeEdge();
        v_Add();
        e_Reset();
        v_Path();
        e_PeekNode();
        v_NodePeeked();
        e_Reset();
        v_Path();
        e_InvalidHead();
        v_InvalidHead();
        e_Reset();
        v_Path();
        e_PeekNode();
        v_NodePeeked();
        e_Reset();
        v_Path();
        e_PeekEdge();
        v_EdgePeeked();
        e_Reset();
        v_Path();
        e_PeekEdge();
        v_EdgePeeked();
        e_Reset();
        v_Path();
        e_AddNotContainsEdge();
        v_NotContainsEdge();
        e_Reset();
        v_Path();
        e_PeekEdge();
        v_EdgePeeked();
        e_Reset();
        v_Path();
        e_PeekNode();
        v_NodePeeked();
        e_Reset();
        v_Path();
        e_PeekEdge();
        v_EdgePeeked();
        e_Reset();
        v_Path();
        e_AddNotContainsEdge();
        v_NotContainsEdge();
        e_Reset();
        v_Path();
        e_PopNode();
        v_PopNode();
        e_Reset();
        v_Path();
        e_AddNodeEdge();
        v_Add();
        e_Reset();
        v_Path();
        e_PopEdge();
        v_PopEdge();
        e_Reset();
        v_Path();
        e_PopEdge();
        v_PopEdge();
        e_Reset();
        v_Path();
        e_AddNotContainsEdge();
        v_NotContainsEdge();
        e_Reset();
        v_Path();
        e_PeekNode();
        v_NodePeeked();
        e_Reset();
        v_Path();
        e_PeekNode();
        v_NodePeeked();
        e_Reset();
        v_Path();
        e_AddNodeEdge();
        v_Add();
        e_Reset();
        v_Path();
        e_PeekEdge();
        v_EdgePeeked();
        e_Reset();
        v_Path();
        e_PeekNode();
        v_NodePeeked();
        e_Reset();
        v_Path();
        e_AddNotContainsEdge();
        v_NotContainsEdge();
        e_Reset();
        v_Path();
        e_InvalidHead();
        v_InvalidHead();
        e_Reset();
        v_Path();
        e_AddNodeEdge();
        v_Add();
        e_Reset();
        v_Path();
        e_PeekEdge();
        v_EdgePeeked();
        e_Reset();
        v_Path();
        e_PopNode();
        v_PopNode();
        e_Reset();
        v_Path();
        e_PopEdge();
        v_PopEdge();
        e_Reset();
        v_Path();
        e_PopNode();
        v_PopNode();
        e_Reset();
        v_Path();
        e_AddNodeEdge();
        v_Add();
        e_Reset();
        v_Path();
        e_InvalidHead();
        v_InvalidHead();
        e_Reset();
        v_Path();
        e_InvalidHead();
        v_InvalidHead();
        e_Reset();
        v_Path();
        e_PeekEdge();
        v_EdgePeeked();
        e_Reset();
        v_Path();
        e_AddNodeEdge();
        v_Add();
        e_Reset();
        v_Path();
        e_AddNodeEdge();
        v_Add();
        e_Reset();
        v_Path();
        e_PeekNode();
        v_NodePeeked();
        e_Reset();
        v_Path();
        e_PeekEdge();
        v_EdgePeeked();
        e_Reset();
        v_Path();
        e_PopNode();
        v_PopNode();
        e_Reset();
        v_Path();
        e_PopEdge();
        v_PopEdge();
        e_Reset();
        v_Path();
        e_AddNodeEdge();
        v_Add();
        e_Reset();
        v_Path();
        e_PopNode();
        v_PopNode();
        e_Reset();
        v_Path();
        e_PopNode();
        v_PopNode();
        e_Reset();
        v_Path();
        e_PeekWhileEmptyNode();
        v_EmptyStack();
        e_Reset();
        v_Path();
        e_AddWithNullRoot();
        v_NullRoot();
        e_Reset();
        v_Path();
        e_PopWhileEmptyNode();
        v_EmptyNodePopException();
        e_Reset();
        v_Path();
        e_PopWhileEmptyEdge();
        v_EmptyEdgePopException();
        e_Reset();
        v_Path();
        e_PeekWhileEmptyEdge();
        v_EmptyStack();
    }
}