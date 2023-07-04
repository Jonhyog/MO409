package org.learning.utils;

import org.graphstream.graph.Edge;
import org.graphstream.graph.Node;

import org.graphstream.graph.Graph;
import org.graphstream.graph.Path;
import org.graphstream.graph.implementations.DefaultGraph;

import java.lang.reflect.Executable;
import java.util.*;
import java.util.stream.Stream;

public class PathHelper {
    protected int autoIncrement;

    protected Stack<Node> nodePath = new Stack<Node>();
    protected Stack<Edge> edgePath = new Stack<Edge>();


    protected Node lastPeekNode;
    protected Edge lastPeekEdge;

    protected Node lastPopNode;
    protected Edge lastPopEdge;

    protected Exception capturedException;
    public PathHelper() {

        this.autoIncrement = 0;
    }

    public String nextId() {
        return Integer.toString(this.autoIncrement++);
	}

    public Graph createSimpleGraph() {
        Graph graph = new DefaultGraph("test");
        graph.setStrict(false);
        graph.setAutoCreate(true);


        return graph;
    }

    public Edge getLastPeekEdge() {
        return this.lastPeekEdge;
    }

    public Node getLastPeekNode() {
        return this.lastPeekNode;
    }

    public Node getLastPopNode() {
        return this.lastPopNode;
    }

    public Edge getLastPopEdge() {
        return this.lastPopEdge;
    }


    public void addEdge(Edge edge){

    }
    private Node getPathHead(){
        return null;
    }

    public void PeekEdge() {
        this.lastPeekEdge = edgePath.peek();
    }
    public void PeekNode() {
        this.lastPeekNode = nodePath.peek();
    }
    public void PopEdge() {
        this.lastPopNode = this.nodePath.pop();
        this.lastPopEdge =this.edgePath.pop();

        
    }
    public void PopNode() {
        this.lastPopNode = this.nodePath.pop();
        this.lastPopEdge = this.edgePath.pop();

    }

    public void setCapturedException(Exception ex) {
        this.capturedException = ex;
    }

    public Exception getCapturedException() {
        return this.capturedException;
    }
}