import java.util.HashMap;
import java.util.HashSet;

public class Graph {
    private HashSet<Integer> nodes;
    private HashMap<Integer, Integer> edgeTargetMap;
    private HashMap<Integer, Integer> edgeSourceMap;

    public Graph(){
        this.nodes = new HashSet<Integer>();
        this.edgeTargetMap = new HashMap<Integer,Integer>();
        this.edgeSourceMap = new HashMap<Integer,Integer>();
    }
    /*
     * Este construtor garante o encapsulamento do parâmentro n
     */
    public Graph(HashSet<Integer> n){
        this.nodes = new HashSet<Integer>(n);
        this.edgeTargetMap = new HashMap<Integer,Integer>();
        this.edgeSourceMap = new HashMap<Integer,Integer>();
    }
    public boolean addNode(Integer node){
        return this.nodes.add(node);
    }
    public boolean addNode(int node){
        return this.nodes.add(node);
    }
    public boolean addEdge(int edg, int src, int tgt){
        if(this.nodes.contains(src) && this.nodes.contains(tgt)){
            this.edgeSourceMap.put(edg, src);
            this.edgeTargetMap.put(edg, tgt);
            return true;
        }
        return false;
    }

    public HashSet<Integer> getNodes(){
        return new HashSet<Integer>(this.nodes);
    }
    public HashSet<Integer> getEdges(){
        return new HashSet<Integer>(this.edgeSourceMap.keySet());
    }
}
