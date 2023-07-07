public class SingleGraphUt extends SingleGraph {


   public SingleGraphUt(String id, boolean strictChecking, boolean autoCreate, int initialNodeCapacity, int initialEdgeCapacity) {	
		super(id,strictChecking, autoCreate,initialNodeCapacity,initialEdgeCapacity);
   }

   public int getMaxNode(){
    return this.nodeArray.length;
   }
   public int getMaxEdge(){
    return this.edgeArray.length;
   }
   
   public HashMap<String, AbstractNode>  getNodeMap(){
    return this.nodeMap;
   }
   public HashMap<String, AbstractEdge>  getEdgeMap(){
    return this.edgeMap;
   }

   public AbstractNode[] getNodeList(){
    return this.nodeArray;
   }
   public AbstractEdge[] getEdgeList(){
    return this.edgeArray;
   }

}