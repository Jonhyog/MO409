package org.learning;

import org.graphstream.graph.*;
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
    private void TC_1(){
		
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


        if(!path.pop().equals(D)){throw new Exception("Erro");}
        if(!path.pop().equals(C)){throw new Exception("Erro");}
        if(!path.pop().equals(B)){throw new Exception("Erro");}
        if(!path.pop().equals(A)){throw new Exception("Erro");}

    }

    @Test
    private void TC_2(){

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

        if(!path.pop().equals(D)){throw new Exception("Erro");}
        if(!path.pop().equals(C)){throw new Exception("Erro");}
        if(!path.pop().equals(B)){throw new Exception("Erro");}
        if(!path.pop().equals(A)){throw new Exception("Erro");}

    
        

    }

    @Test
    private void TC_3(){
        " ¯\_(ツ)_/¯"
        Path p;
        assertNull(p);

    }
}