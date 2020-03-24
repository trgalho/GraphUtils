import java.util.Set;

abstract class GraphUtilsTest {

    /** Inner counter to track tests */
    private static int counter=0;

    /** Inner method to execute and print all sub graphs for base graph. */
    private static Set<Graph> testAllSubGraphs(Graph baseGraph)
    {
        System.out.println("Test #" + ++counter);

        Set<Graph> allSubGraphsOfBaseGraph = GraphUtils.allSubGraphsOf(baseGraph);

        for( Graph subGraph : allSubGraphsOfBaseGraph )
        {
            System.out.println(subGraph.toString());
        }

        System.out.println();

        return allSubGraphsOfBaseGraph;
    }

    public static void main(String[] args)
    {
        Graph graph = new Graph();

        testAllSubGraphs(graph);

        graph.addNode(10);
        testAllSubGraphs(graph);

        graph.addNode(11);
        testAllSubGraphs(graph);

        graph.addNode(12);
        testAllSubGraphs(graph);

        graph.addNode(13);
        testAllSubGraphs(graph);

        graph.addEdge(20,10,10);
        testAllSubGraphs(graph);

        graph.addEdge(21,10,10);
        testAllSubGraphs(graph);

        graph.addEdge(22,11,12);
        testAllSubGraphs(graph);
    }
}
