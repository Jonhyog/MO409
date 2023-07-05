package org.learning;

import org.graphstream.graph.*;
import org.junit.jupiter.api.Test;
import org.learning.models.PathModel;
import org.learning.utils.PathHelper;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

public class PathTest implements PathModel {

    protected PathHelper helper = new PathHelper();
    protected Path p;

    protected Node lastPeekNode;
    protected Edge lastPeekEdge;

    protected Node lastPopNode;
    protected Edge lastPopEdge;


    protected Node lastAddedNode;
    protected Node lastAddedEdge;

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
        assertEquals(this.lastPopEdge, this.helper.getLastPopEdge());
    }

    public void v_EmptyNodePopException() {
        Exception ex = this.helper.getCapturedException();
        assertThrows(EmptyStackException.class, () -> { throw ex; });
    }

    public void v_PopNode(){
        assertEquals(this.lastPopNode, this.helper.getLastPopNode());
    }

    public void v_Path(){
        //Transitório
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
        assertEquals(this.lastPeekEdge, this.helper.getLastPeekEdge());
    }

    @Override
    public void e_PeekWhileEmptyNode() {
            
            this.helper.setCapturedException(null);
            try
            { 
                p.peekNode();
            }
            catch (Exception ex)
            {
                this.helper.setCapturedException(ex);
            }
    }

    @Override
    public void v_NodePeeked() {
        assertEquals(this.lastPeekNode, this.helper.getLastPeekNode());
    }

    public void e_Reset(){
        //Estado de transição
    }

    public void e_AddNodeEdge() {
        //Fé
        SimpleTuple<char,char> t = helper.getNewEdge();

        char a = t.x;
        char b = t.y;

        StringBuilder sb = new StringBuilder();
        sb.append(a);
        sb.append(b);
        str = sb.toString();
        g.addEdge(str, a, b);

        Edge edge = g.getEdge(str);

        p.add(edge);
        this.lastAddedEdge = edge;


    }

    public void e_AddWithNullRoot() {
        //Precisa que root != NULL
        Node n = p.getRoot();
        p.setRoot(null);
        this.helper.setCapturedException(null);
            try
            { 
                p.add(null);
            }
            catch (Exception ex)
            {   p.setRoot(n);
                this.helper.setCapturedException(ex);
            }
    }

    public void e_AddNotContainsEdge() {
        //Fé²

        SimpleTuple<char,char> t = helper.getNewEdge();

        char a = t.x;
        char b = t.y;

        StringBuilder sb = new StringBuilder();
        sb.append(a);
        sb.append(b);
        str = sb.toString();
        g.addEdge(str, a, b);

        Edge edge = g.getEdge(str);

        p.add(edge);
        this.lastAddedEdge = edge;

    }

    @Override
    public void v_Add() {
        assertEquals(p.peekEdge() this.helper.getLastAddedAdge());
    }

    public void e_InvalidHead() {
        Graph graph = createSimpleGraph();
        //Não sei se isso funciona
        graph.addEdge("ixiz", "ix", "iz");
        //graph.addEdge("xz", "x", "z");

        //XZ não faz parte de p;
        this.helper.setCapturedException(null);
        try
        {   
            path.add(graph.getEdge("xz"));

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
        helper.PeekNode();
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

    @Override
    public void e_AddNodeEdge() {

        String e = helper.getNewEdge();

    }

    @Test
    public void modelTest() {
        v_Start();
        e_CreatePath();
        v_Path();
        e_PopWhileEmptyNode();
        v_EmptyNodePopException();
        e_Reset();
        v_Path();
        e_AddWithNullRoot();
        v_NullRoot();
        e_Reset();
        v_Path();
        e_PeekWhileEmptyEdge();
        v_EmptyStack();
        e_Reset();
        v_Path();
        e_PopWhileEmptyNode();
        v_EmptyNodePopException();
        e_Reset();
        v_Path();
        e_AddNodeEdge();
        v_Add();
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
        e_InvalidHead();
        v_InvalidHead();
        e_Reset();
        v_Path();
        e_InvalidHead();
        v_InvalidHead();
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
        e_PeekEdge();
        v_EdgePeeked();
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
        e_AddNodeEdge();
        v_Add();
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
        e_AddNotContainsEdge();
        v_NotContainsEdge();
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
        e_InvalidHead();
        v_InvalidHead();
        e_Reset();
        v_Path();
        e_AddNodeEdge();
        v_Add();
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
        e_PeekEdge();
        v_EdgePeeked();
        e_Reset();
        v_Path();
        e_AddNodeEdge();
        v_Add();
        e_Reset();
        v_Path();
        e_AddNotContainsEdge();
        v_NotContainsEdge();
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
        e_PeekEdge();
        v_EdgePeeked();
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
        e_AddNodeEdge();
        v_Add();
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
        e_AddNotContainsEdge();
        v_NotContainsEdge();
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
        e_PeekNode();
        v_NodePeeked();
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
        e_PopEdge();
        v_PopEdge();
        e_Reset();
        v_Path();
        e_PopEdge();
        v_PopEdge();
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
        e_PeekEdge();
        v_EdgePeeked();
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
        e_AddNotContainsEdge();
        v_NotContainsEdge();
        e_Reset();
        v_Path();
        e_PeekNode();
        v_NodePeeked();
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
        e_AddNotContainsEdge();
        v_NotContainsEdge();
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
        e_PopEdge();
        v_PopEdge();
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
        e_PopEdge();
        v_PopEdge();
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
        e_AddNodeEdge();
        v_Add();
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
        e_AddNotContainsEdge();
        v_NotContainsEdge();
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
        e_PopEdge();
        v_PopEdge();
        e_Reset();
        v_Path();
        e_PeekNode();
        v_NodePeeked();
        e_Reset();
        v_Path();
        e_PopWhileEmptyEdge();
        v_EmptyEdgePopException();
        e_Reset();
        v_Path();
    }

}