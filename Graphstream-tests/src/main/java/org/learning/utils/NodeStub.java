import java.util.List;

public class NodeStub {
    private String id;
    private List<Edge> inputEdges;
    private List<Edge> outputEdges;

    public NodeStub(Node node){
        NodeStub(node.toString());
    }
    public NodeStub(String id) {

        NodeStub(id,new List<Node>(),new List<Node>());
    }
    public NodeStub(String id, List<Node> inputEdges, List<Node> outputEdges) {
        this.id = id;
        this.inputEdges = inputEdges;
        this.outputEdges = outputEdges;
    }

    public String getId() {
        return id;
    }

    public List<Node> getinputEdges() {
        return inputEdges;
    }

    public List<Node> getoutputEdges() {
        return outputEdges;
    }

    public void addInEdge(Edge edge){

        inputEdges.push(edge);

    }
    public void addOutEdge(Edge edge){

        outputEdges.push(edge);
    }
    public boolean isSameEdge(Edge edge){

       boolean in = compareStreamToList(edge.leavingEdges() , this.outputEdges);
       boolean out = compareStreamToList(edge.enteringEdges() , this.inputEdges);

       return in && out;
    }

    public boolean compareStreamToList(Stream<Edge> adj, List<Edge> own) {
        List<Edge> adjList = adj.collect(Collectors.toList());
        
        // Verificar se os tamanhos das listas são diferentes
        if (adjList.size() != own.size()) {
            return false;
        }
        
        // Verificar se os elementos são os mesmos
        for (Edge edge : own) {
            if (!adjList.contains(edge)) {
                return false;
            }
        }
        
        return true;
    }
}
