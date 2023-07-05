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

    protected Node lastAddedNode;
    protected Edge lastAddedEdge;

    protected Graph g;


    protected Exception capturedException;
    public PathHelper() {

        this.autoIncrement = 0;
        this.g = createSimpleGraph();
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


    public void addEdge(String a, String b){


        StringBuilder sb = new StringBuilder();
        sb.append(a);
        sb.append(b);
        String str = sb.toString();
        g.addEdge(str, a, b);

        Edge edge = g.getEdge(str);
        Node from = g.getNode(a);
        //nodePath.push(edge.getOpposite(from));
        if (nodePath.size() == 0) {
            this.nodePath.push(from);
        }

        this.nodePath.push(edge.getOpposite(from));
		this.edgePath.push(edge);
        this.lastAddedEdge = edge;
        this.lastAddedNode = edge.getOpposite(from);

        System.out.println("Helper:" + edge);
    }

    public SimpleTuple<String, String> getNewEdge(){
        String a;
        if (nodePath.size() == 0) {
            a = Integer.toString(autoIncrement);
        }
        else
        {
            a = nodePath.peek().toString();
        }
//        String a = Integer.toString(autoIncrement);
        String b = Integer.toString(++autoIncrement);
        SimpleTuple<String, String> t = new SimpleTuple<String, String>(a,b);

        return t;
    }

    public Edge getLastAddedEdge() {
        return this.lastAddedEdge;
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
        this.lastPopEdge = this.edgePath.pop();

        
    }
    public void PopNode() {
        this.lastPopNode = this.nodePath.pop();
        this.lastPopEdge = this.edgePath.pop();

    }

    public void clear() {
        this.nodePath.clear();
        this.edgePath.clear();
    }

    public void setCapturedException(Exception ex) {
        this.capturedException = ex;
    }

    public Exception getCapturedException() {
        return this.capturedException;
    }
}
