import java.util.HashSet;
import java.util.Set;

public class GraphUtils {

    /**
     * Generate all sub graphs of a base graph.
     *
     * All sub graphs are generated using the power set of nodes combined with the power set of its respective edges.
     *
     * @param baseGraph - A base graph.
     *
     * @return A set containing all sub graphs of G.
     */
    public static HashSet<Graph> allSubGraphsOf(Graph baseGraph){

        /** Set  to store all generated subgraph */
        HashSet allSubGraphsSet = new HashSet<Graph>();

        /** Generate de power set for the nodes on the base Graph */
        Set<Set<Integer>> nodesPowerSet = SetUtils.powerSet(baseGraph.getNodes());

        /**
         * Foreach subSet find the respective subset of edges
         *
         * For this subset of edges, generate all possibles combinations of edges.
         *
         * Then mix this all possible combinations with the subset of nodes.
         *
         * Thus, generating the all possibles subgraph of base graph with this set of nodes.
         */
        for( Set<Integer> nodeSet : nodesPowerSet)
        {
            /** Initialize the base set of possible edges */
            Set<Edge> baseSubGraphEdges = new HashSet<>();

            /** Generate the base subgraph using the current subset of nodes */
            Graph baseSubGraph = new Graph(nodeSet);

            /** Find the possible edges of the set of edges existing on the base graph */
            for( Integer edgeId : baseGraph.getEdgesIds() )
            {
                Integer srcNodeId = baseGraph.getEdgeSource(edgeId);
                Integer tgtNodeId = baseGraph.getEdgeTarget(edgeId);

                if( baseSubGraph.containsNode(srcNodeId) && baseSubGraph.containsNode(tgtNodeId) )
                {
                    Edge edge = new Edge();

                    edge.id = edgeId;
                    edge.sourceId = srcNodeId;
                    edge.targetId = tgtNodeId;

                    baseSubGraphEdges.add(edge);
                }
            }

            /** Generated de power set for the set of possible edges (all possibilities ) */
            Set<Set<Edge>> edgesPowerSet = SetUtils.powerSet(baseSubGraphEdges);

            /**
             * Mix the subset of possible edges with the subset of nodes generating N subgraphs
             * Where N is the size of nodes subsets times the size of the power set of possible edges.
             */
            for( Set<Edge> edgesSubSet : edgesPowerSet)
            {
                Graph subGraph = baseSubGraph.clone();

                for( Edge edge : edgesSubSet )
                {
                    subGraph.addEdge( edge.id, edge.sourceId, edge.targetId);
                }

                allSubGraphsSet.add(subGraph);
            }
        }

        return allSubGraphsSet;
    }

}
