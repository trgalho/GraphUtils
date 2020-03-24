import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Graph implements Cloneable {

    /** Set of nodes */
    private HashSet<Integer> nodes;

    /** Map relating the egdes id to source node id */
    private HashMap<Integer, Integer> edgeSourceMap;

    /** Map relating the egdes id to target node id */
    private HashMap<Integer, Integer> edgeTargetMap;

    /** Creates a empty graph */
    public Graph(){
        this.nodes = new HashSet<Integer>();
        this.edgeTargetMap = new HashMap<Integer,Integer>();
        this.edgeSourceMap = new HashMap<Integer,Integer>();
    }

    /**
     * Creates a graph using the node set provided. but with a empty set of edges.
     *
     * IMPORTANT: The node set is copied before it's used.
     * @param nodesSet - Node set for the graph.
     */
    public Graph(Set<Integer> nodesSet){
        this.nodes = new HashSet<Integer>(nodesSet);
        this.edgeTargetMap = new HashMap<Integer,Integer>();
        this.edgeSourceMap = new HashMap<Integer,Integer>();
    }

    /**
     * Adds a new node to the graph.
     *
     * Do nothing if a node with specified id already exists.
     *
     * @param node - Identifier for added node.
     * @return True, if node was added. Otherwise, false.
     */
    public boolean addNode(int node){
        return this.nodes.add(node);
    }

    /**
     * Adds edge to the graph.
     *
     * If an edge with specified id already exists, the edge is remapped for
     * these nodes.
     *
     * If source or target node not exists in this graph, the is not added.
     *
     * @param edg - Id for the new edge.
     * @param src - Source node id
     * @param tgt - Target node id.
     * @return False, if any of source or target node not exists in this graph. True, is the edge was added or modified.
     */
    public boolean addEdge(int edg, int src, int tgt){
        boolean booEdgeWasAdded = false;

        if( this.nodes.contains(src) && this.nodes.contains(tgt) )
        {
            this.edgeSourceMap.put(edg, src);
            this.edgeTargetMap.put(edg, tgt);
            booEdgeWasAdded = true;
        }

        return booEdgeWasAdded;
    }

    /**
     *
     * @param edgeId
     * @return The node id for the source node for referenced edge, or null if edge doesn't have a source node.
     */
    public int getEdgeSource( int edgeId )
    {
        return this.edgeSourceMap.get(edgeId);
    }

    /**
     *
     * @param edgeId
     * @return The node id for the target node for referenced edge, or null if edge doesn't have a target node.
     */
    public int getEdgeTarget( int edgeId )
    {
        return this.edgeTargetMap.get(edgeId);
    }

    /**
     * Verify if the node with specified id existsin this graph.
     * @param nodeId - Node id
     * @return True, if graph contains a node with the specified id. Otherwise false.
     */
    public boolean containsNode( int nodeId )
    {
        return this.nodes.contains(nodeId);
    }

    /**
     * Generate a new Set for this graph nodes.
     * @return A new Set of nodes (nodes ids)
     */
    public HashSet<Integer> getNodes()
    {
        return new HashSet<Integer>(this.nodes);
    }

    /**
     * Generate a new Set for this graph edges ids.
     * @return A new Set of edges id.
     */
    public HashSet<Integer> getEdgesIds()
    {
        return new HashSet<Integer>(this.edgeSourceMap.keySet());
    }

    /**
     * Generate a new Set of this graph edges.
     * @return A new set of edges.
     */
    public Set<Edge> getEdges() {

        HashSet<Edge> edgesSet = new HashSet<>();

        for( Integer edgeId : this.getEdgesIds() )
        {
            Integer srcNodeId = this.getEdgeSource(edgeId);
            Integer tgtNodeId = this.getEdgeTarget(edgeId);

            Edge edge = new Edge();

            edge.id = edgeId;
            edge.sourceId = srcNodeId;
            edge.targetId = tgtNodeId;

            edgesSet.add(edge);
        }

        return edgesSet;
    }

    /**
     * Creates a clone of current graph preserving his set of nodes and edges.
     *
     * @return A new Graph instance with the equivalent set of nodes and edges of this graph.
     */
    public Graph clone()
    {
        Graph graph = new Graph(this.nodes);

        for( int edgeId : this.getEdgesIds() )
        {
            int srcNode = this.getEdgeSource(edgeId);
            int tgtNode = this.getEdgeTarget(edgeId);

            graph.addEdge(edgeId, srcNode, tgtNode);
        }

        return graph;
    }

    @Override
    public String toString() {
        return "Graph{ " +
                "nodes=" + nodes +
                ", edgeTargetMap=" + edgeTargetMap +
                ", edgeSourceMap=" + edgeSourceMap +
                " }";
    }
}
