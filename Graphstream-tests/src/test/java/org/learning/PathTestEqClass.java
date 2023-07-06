package org.learning;

import org.graphstream.graph.*;
import org.graphstream.graph.implementations.DefaultGraph;
import org.junit.jupiter.api.Test;
import org.learning.models.PathModel;
import org.learning.utils.PathHelper;
import org.learning.utils.SimpleTuple;

import javax.sound.midi.SysexMessage;
import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

public class PathTestEqClass {

    //Seria legal colocar uns laços/funções, mas por enquanto vai assim


    @Test
    public void TC_1(){
		
        Graph graph = new DefaultGraph("test");
		graph.setStrict(false);
		graph.setAutoCreate(true);


		Edge A = graph.addEdge("ab", "a", "b");
		Edge B = graph.addEdge("bc", "b", "c");
		Edge C = graph.addEdge("cd", "c", "d");
        Edge D = graph.addEdge("da", "d", "a");

        Path path = new Path();
        path.setRoot(graph.getNode("a"));
        path.add(graph.getEdge("ab"));
        path.add(graph.getEdge("bc"));
        path.add(graph.getEdge("cd"));
        path.add(graph.getEdge("da"));

        assertTrue(path.popEdge().equals(D));
        assertTrue(path.popEdge().equals(C));
        assertTrue(path.popEdge().equals(B));
        assertTrue(path.popEdge().equals(A));
    }

    @Test
    public void TC_2(){

        Graph graph = new DefaultGraph("test");
		graph.setStrict(false);
		graph.setAutoCreate(true);

		Edge A = graph.addEdge("ab", "a", "b");
		Edge B =graph.addEdge("bc", "b", "c");
		Edge C =graph.addEdge("cd", "c", "d");
        Edge D =graph.addEdge("de", "d", "e");

        Path path = new Path();
        path.setRoot(graph.getNode("a"));
        path.add(graph.getEdge("ab"));
        path.add(graph.getEdge("bc"));
        path.add(graph.getEdge("cd"));
        path.add(graph.getEdge("de"));

        assertTrue(path.popEdge().equals(D));
        assertTrue(path.popEdge().equals(C));
        assertTrue(path.popEdge().equals(B));
        assertTrue(path.popEdge().equals(A));
    }

    @Test
    public void TC_3(){
        // ¯\_(ツ)_/¯
        Path p = null;
        assertNull(p);
    }
}