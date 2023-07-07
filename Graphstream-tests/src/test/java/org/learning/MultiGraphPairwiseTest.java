package org.learning;

import org.graphstream.graph.Edge;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.MultiGraph;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MultiGraphPairwiseTest {
/*
*
* +---------+----------+---------+--------+-------------+-----------------+
* | ------- | Completo | Cíclico | Conexo | Direcionado | Aresta repatida |
* +---------+----------+---------+--------+-------------+-----------------+
* |       1 | Sim      | Sim     | Sim    | Sim         | Sim             |
* |       2 | Não      | Não     | Sim    | Não         | Sim             |
* |       3 | Não      | Sim     | Não    | Sim         | Não             |
* +---------+----------+---------+--------+-------------+-----------------+
*
 */

    @Test
    public void TC_1() {
        Graph g = new MultiGraph("TC_1");
        String[] nodeList = {"A", "B", "C", "D", "E"};
        Node a, b;

        // Creates nodes
        for (String node : nodeList) {
            g.addNode(node);
        }


        

        // Creates all edges
        for (String node1 : nodeList) {
            for (String node2 : nodeList) {
                if (node1.equals(node2)) continue;

                a = g.getNode(node1);
                b = g.getNode(node2);

                Edge e = g.addEdge(node1 + "-" + node2, a, b, true);

                // Checks if all edges are directed
                assertTrue(e.isDirected());
            }
        }

        Edge e1 = g.addEdge("AB_Copia", g.getNode("A"), g.getNode("B"), true);
        Edge e2 = g.addEdge("CD_Copia", g.getNode("C"), g.getNode("D"), true);

        assertTrue(e1.isDirected());
        assertTrue(e2.isDirected());

        // Checks if is all nodes are connected
        for (String node1 : nodeList) {
            for (String node2 : nodeList) {
                if (node1.equals(node2)) continue;

                a = g.getNode(node1);
                b = g.getNode(node2);

                // if (a --> b) and (b --> a) then cycle
                assertTrue(a.hasEdgeToward(node2));
                assertTrue(b.hasEdgeToward(node1));
            }
        }
        


    }

    @Test
    public void TC_2() {
        Graph g = new MultiGraph("TC_2");

        // Creates nodes
        Node A = g.addNode("A");
        Node B = g.addNode("B");
        Node C = g.addNode("C");
        Node D = g.addNode("D");
        Node E = g.addNode("E");

        // Creates Edges
        Edge AB = g.addEdge("A-B", A, B, false);
        Edge BC = g.addEdge("B-C", B, C, false);
        Edge CD = g.addEdge("C-D", C, D, false);
        Edge DE = g.addEdge("D-E", D, E, false);

        // Checks if there is a cycle
        assertFalse(E.hasEdgeToward(A));

        // Checks if all edges are directed
        assertFalse(AB.isDirected());
        assertFalse(BC.isDirected());
        assertFalse(CD.isDirected());
        assertFalse(DE.isDirected());

    }


    @Test
    public void TC_3() {
        Graph g = new MultiGraph("TC_3");

        // Creates nodes
        Node A = g.addNode("A");
        Node B = g.addNode("B");
        Node C = g.addNode("C");
        Node D = g.addNode("D");

        // Creates Edges
        Edge AB = g.addEdge("A->B", A, B, true);
        Edge BA = g.addEdge("B->A", B, A, true);

        Edge CD = g.addEdge("C->D", C, D, true);
        Edge DC = g.addEdge("D->C", D, C, true);

        // Checks if there is a cycle
        assertTrue(A.hasEdgeToward("B"));
        assertTrue(B.hasEdgeToward("A"));

        assertTrue(C.hasEdgeToward("D"));
        assertTrue(D.hasEdgeToward("C"));

        // Checks if all edges are directed
        assertTrue(AB.isDirected());
        assertTrue(BA.isDirected());

        assertTrue(CD.isDirected());
        assertTrue(DC.isDirected());
    }

}
