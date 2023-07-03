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
    private Node getPathHead(){
    }

    public void PeekEdge(Edge e){
        this.lastPeekEdge = e;
    }
    public void PeekNode(Node n){
        this.lastPeekNode = n;
    }
    public void PopEdge(Edge e){
        this.lastPopNode = this.nodePath.pop();
        this.lastPopEdge = this.edgePath.pop();
        
    }
    public void PopNode(){
        this.lastPopEdge = this.edgePath.pop();
        this.lastPopNode = this.nodePath.pop();
    }

    }
}