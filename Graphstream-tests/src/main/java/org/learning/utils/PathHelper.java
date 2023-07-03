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

    Stack<Node> nodePath = new Stack<Node>();
    Stack<Edge> edgePath = new Stack<Edge>();


    Node lastPeekNode;
    Edge lastPeekEdge;

    Node lastPopNode;
    Edge lastPopEdge;
    public PathHelper() {

        this.autoIncrement = 0;
    }

    public String nextId() {
        return Integer.toString(this.autoIncrement++);
    

        private Graph createSimpleGraph() {
		Graph graph = new DefaultGraph("test");
		graph.setStrict(false);
		graph.setAutoCreate(true);


		return graph;
	}
    public void addEdge(Edge edge){

    }
    private Node getPathHead(){
    }

    public void PeekEdge(){
        this.lastPeekEdge = edgePath.peek();
    }
    public void PeekNode(){
        this.lastPeekNode = nodePath.peek();
    }
    public void PopEdge(){
        this.lastPopNode = this.nodePath.pop();
        this.lastPopEdge this.edgePath.pop();

        
    }
    public void PopNode(){
        this.lastPopNode = this.nodePath.pop();
        this.lastPopEdge this.edgePath.pop();

    }

    }
}