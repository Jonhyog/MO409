import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NodeStub {
    private String id;
    private Node node;
    private ArrayList<String> inputEdges;
    private ArrayList<String> outputEdges;
    private AdjacencyListGraph g;

    public NodeStub(Node n, AdjacencyListGraph g) {
        this.g = g;
        this.id = n.toString();
        this.node = n;
        this.inputEdges = new ArrayList<>();
        this.outputEdges = new ArrayList<>();
    }

    public void addEdge(Node A, Node B, boolean directed, NodeStub B) {
        addEdge(A.toString() + B.toString(), A, B, directed, B);
    }

    public void addEdge(String id, Node A, Node B, boolean directed, NodeStub B) {
        this.g.addEdge(id, A, B, directed);
        this.addOutEdge(B);
        B.addInEdge(A);
    }

    public boolean isSameEdge(Edge edge) {
        boolean in = compareStreamToList(edge.leavingEdges(), this.outputEdges);
        boolean out = compareStreamToList(edge.enteringEdges(), this.inputEdges);
        return in && out;
    }

    public boolean compareStreamToList(Stream<Edge> adj, ArrayList<String> own) {
        ArrayList<String> adjList = adj.map(Edge::toString).collect(Collectors.toCollection(ArrayList::new));

        if (adjList.size() != own.size()) {
            return false;
        }

        for (String edge : own) {
            if (!adjList.contains(edge)) {
                return false;
            }
        }

        return true;
    }

    public void addInEdge(Edge edge) {
        inputEdges.add(edge.toString());
    }

    public void addOutEdge(Edge edge) {
        outputEdges.add(edge.toString());
    }
}
