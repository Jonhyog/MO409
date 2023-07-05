package org.learning.utils;

import org.graphstream.graph.Edge;
import org.graphstream.graph.Node;

import java.lang.reflect.Executable;
import java.util.*;
import java.util.stream.Stream;

public class GraphHelper {
    protected Random r;
    protected HashMap<String, Node> nodeMap;
    protected HashMap<String, Edge> edgeMap;
    protected List<Node> nodes;
    protected List<Edge> edges;
    protected Node lastRemovedNode;
    protected Edge lastRemovedEdge;
    protected Exception capturedException;
    protected int autoIncrement;

    public GraphHelper() {
        this.r = new Random();
        this.nodeMap = new HashMap<>();
        this.edgeMap = new HashMap<>();
        this.nodes = new Vector<>();
        this.edges = new Vector<>();
        this.lastRemovedNode = null;
        this.lastRemovedEdge = null;
        this.autoIncrement = 0;
    }

    public String nextId() {
        return Integer.toString(this.autoIncrement++);
    }

    public void addNode(Node n) {
        this.nodes.add(n);
        this.nodeMap.put(n.toString(), n);
    }

    public void removeNode(Node n) {
        List<String> edgesKeys = new Vector<>();

        this.nodes.remove(n);
        this.nodeMap.remove(n.toString());

        for (Map.Entry<String, Edge> set : this.edgeMap.entrySet()) {
            Edge e = set.getValue();

            if (e.getNode0() == n || e.getNode1() == n) {
                edgesKeys.add(e.toString());
            }
        }

        for (String s : edgesKeys) {
            this.edgeMap.remove(s);
        }

        this.lastRemovedNode = n;

    }

    public void addEdge(Edge e) {
        this.edges.add(e);
        this.edgeMap.put(e.toString(), e);
    }

    public void removeEdge(Edge e) {
        this.edges.remove(e);
        this.edgeMap.remove(e.toString());

        this.lastRemovedEdge = e;
    }

    public Node getLastNode() {
        return this.nodes.get(this.nodes.size() - 1);
    }

    public Node getNode(String id) {
        return this.nodeMap.get(id);
    }

    public Node getLastRemovedNode() {
        return  this.lastRemovedNode;
    }

    public Edge getLastEdge() {
        return this.edges.get(this.edges.size() - 1);
    }

    public Edge getEdge(String id) {
        return this.edgeMap.get(id);
    }

    public Edge getLastRemovedEdge() {
        return this.lastRemovedEdge;
    }

    public Node getRandomNode() {
        int randomIDX = this.r.nextInt(this.nodeMap.size());
        int i = 0;

        for (Map.Entry<String, Node> set : this.nodeMap.entrySet()) {
            if (i == randomIDX) {
                return set.getValue();
            }
            i++;
        }

        return null;
    }

    public Edge getRandomEdge() {
        int randomIDX = this.r.nextInt(this.edgeMap.size());
        int i = 0;

        for (Map.Entry<String, Edge> set : this.edgeMap.entrySet()) {
            if (i == randomIDX) {
                return set.getValue();
            }
            i++;
        }

        return null;
    }

    public SimpleTuple<Node, Node> generateRandomEdge(boolean repeat) {
        Node vertex1 = this.getRandomNode();
        Node vertex2 = this.getRandomNode();

        Stream<Node> neighbours = vertex1.neighborNodes();

        if (repeat) {
            return new SimpleTuple<>(vertex1, vertex2);
        }

        if (neighbours.anyMatch(n -> { return n == vertex2; })) {
            return this.generateRandomEdge();
        }

        return new SimpleTuple<>(vertex1, vertex2);
    }

    public SimpleTuple<Node, Node> generateRandomEdge() {
        return this.generateRandomEdge(false);
    }

    public void setCapturedException(Exception ex) {
        this.capturedException = ex;
    }

    public Exception getCapturedException() {
        return this.capturedException;
    }
    public String getEdgeId(Edge e){
        return e.toString().split("\\[")[0];
    }
}
