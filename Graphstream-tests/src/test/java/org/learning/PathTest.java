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

    protected Graph g;

    public void v_Start() {
        assertNull(this.g);
    }

    public void v_NullRoot(){
        Exception ex = this.helper.getCapturedException();
        assertThrows(IllegalArgumentException.class, () -> { throw ex; });
    }

    public void v_NotContainsEdge() {}
    public void v_InvalidHead() {

    }
    public void v_EmptyStack(){
        Exception ex = this.helper.getCapturedException();
        assertThrows(EmptyStackException.class, () -> { throw ex; });
    }

    public void v_EmptyEdgePopException() {}
    public void v_PopEdge() {
        assertEquals(this.lastPopEdge, this.helper.getLastPopEdge());
    }

    public void v_EmptyNodePopException() {}

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

    }

    @Override
    public void v_EdgePeeked() {
        assertEquals(this.lastPeekEdge, this.helper.getLastPeekEdge());
    }

    @Override
    public void e_PeekWhileEmptyNode() {

    }

    @Override
    public void v_NodePeeked() {
        assertEquals(this.lastPeekNode, this.helper.getLastPeekNode());
    }

    public void e_Reset(){
        //Estado de transição
    }

    public void e_NodeAddEdge() {
        //Gera tupla de vértices aleatórios
        Edge _edge = this.helper.generateRandomEdge();
        //Adiciona a adge nova no helper
        this.p.add(_edge);
        this.helper.addEdge(_edge);
    }

    public void e_AddWithNullRoot() {

    }

    public void e_AddNotContainsEdge() {

    }

    @Override
    public void v_Add() {

    }

    public void e_InvalidHead() {

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
            p.popEdge();
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
            p.popNode();
        }
        catch (Exception ex)
        {
            this.helper.setCapturedException(ex);
        }

    }

    @Override
    public void e_AddNodeEdge() {

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