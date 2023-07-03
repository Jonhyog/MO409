package org.learning;

import org.graphstream.graph.ElementNotFoundException;
import org.graphstream.graph.IdAlreadyInUseException;
import org.graphstream.graph.Node;
import org.graphstream.graph.Edge;
import org.graphstream.graph.implementations.Path;
import org.junit.jupiter.api.Test;
import org.learning.models.PathModel;

import java.util.List;
import java.util.Vector;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.*;

public class PathTest implements PathModel {

        PathHelper helper = new PathHelper();
        Path p;




        
        Node lastPeekNode;
        Edge lastPeekEdge;

        Node lastPopNode;
        Edge lastPopEdge;

        Graph graph;

        Exception lastExcp = null;

        public void v_Start() {
           
            assertNull(this.g);

        }
        public void v_NullRoot(){
            Exception ex = this.helper.getCapturedException();
            assertThrows(IllegalArgumentException.class, () -> { throw ex; });
        }
        public void v_NotContainsEdge(){}
        public void v_InvalidHead(){

        }
        public void v_EmptyStack(){
            Exception ex = this.helper.getCapturedException();
            assertThrows(EmptyStackException.class, () -> { throw ex; });
        }
        public void v_Peeked(){
            //Eu não me orgulho disso
            if(this.lastPeekEdge == helper.lastPeekEdge && this.lastPeekNode == this.lastPeekNode){
                assertTrue(true);
            }

            assertTrue(false);
        }
        public void v_EmptyEdgePopException(){}
        public void v_PopEdge(){
            assertEquals(this.lastPopEdge,helper.lastPopEdge);
        }
        public void v_EmptyNodePopException(){}
        public void v_PopNode(){
            assertEquals(this.lastPopNode,helper.lastPopNode);
        }
        public void v_Start(){
            assertNull(this.p);
        }
        public void v_Path(){
            //Transitório
        }

        public void e_CreatePath(){
            this.p = new Path();
            this.graph = helper.createSimpleGraph();
        }
        public void e_Reset(){
            //Estado de transição
        }


        public void e_NodeAddEdge() {
            //Gera tupla de vértices aleatórios
            Edge _edge = this.helper.generateRandomEdge();
            //Adiciona a adge nova no helper
            this.helper.addEdge(this.p.add(_edge));

         }
         
        public void e_AddWithNullRoot(){

        }

        public void e_AddNotContainsEdge(){
        
        }
        public void e_InvalidHead(){

        }
        public void e_PeekEdge(){
 
            this.lastPeekEdge =p.peekEdge();
            helper.PeekEdge();

        }
        public void e_PeekNode(){

            this.lastPeekNode = p.peekNode();
            helper.PeekNode();

        }
        public void e_PopEdge(){
            

            this.lastPopEdge = p.popEdge();
            helper.PopEdge();
    

        }
        public void e_PopNode(){

            this.lastPopNode =p.popNode();
            helper.PopNode();

        }
        public void e_PopWhileEmptyEdge(){
            this.helper.setCapturedException(null);
            try
            {   
                p.popEdge();
            }
            catch (Exception ex)
            {
                this.helper.setCapturedException(ex);
            }

        }
        public void e_PopWhileEmptyNode(){

            this.helper.setCapturedException(null);
            try
            {   
                p.popNode();
            }
            catch (Exception ex)
            {
                this.helper.setCapturedException(ex);
            }

        }


        
    


    @Test
    public void modelTest() {
        v_Start();
        e_CreatePath();
        v_Path();
        e_PeekEdge();
        v_EmptyStack();
        e_Reset();
        v_Path();
        e_InvalidHead();
        v_InvalidHead();
        e_Reset();
        v_Path();
        e_AddWithNullRoot();
        v_NullRoot();
        e_Reset();
        v_Path();
        e_InvalidHead();
        v_InvalidHead();
        e_Reset();
        v_Path();
        e_AddWithNullRoot();
        v_NullRoot();
        e_Reset();
        v_Path();
        e_AddNodeEdge();
        v_Add();
        e_Reset();
        v_Path();
        e_PeekNode();
        v_Peeked();
        e_Reset();
        v_Path();
        e_PeekEdge();
        v_Peeked();
        e_Reset();
        v_Path();
        e_PopNode();
        v_PopNode();
        e_Reset();
        v_Path();
        e_AddNodeEdge();
        v_Add();
        e_Reset();
        v_Path();
        e_AddNotContainsEdge();
        v_NotContainsEdge();
        e_Reset();
        v_Path();
        e_PopNode();
        v_PopNode();
        e_Reset();
        v_Path();
        e_PeekEdge();
        v_Peeked();
        e_Reset();
        v_Path();
        e_AddNodeEdge();
        v_Add();
        e_Reset();
        v_Path();
        e_AddNotContainsEdge();
        v_NotContainsEdge();
        e_Reset();
        v_Path();
        e_PeekEdge();
        v_Peeked();
        e_Reset();
        v_Path();
        e_AddNodeEdge();
        v_Add();
        e_Reset();
        v_Path();
        e_AddNotContainsEdge();
        v_NotContainsEdge();
        e_Reset();
        v_Path();
        e_AddNotContainsEdge();
        v_NotContainsEdge();
        e_Reset();
        v_Path();
        e_InvalidHead();
        v_InvalidHead();
        e_Reset();
        v_Path();
        e_PopEdge();
        v_PopEdge();
        e_Reset();
        v_Path();
        e_PeekEdge();
        v_Peeked();
        e_Reset();
        v_Path();
        e_PopEdge();
        v_PopEdge();
        e_Reset();
        v_Path();
        e_PopEdge();
        v_PopEdge();
        e_Reset();
        v_Path();
        e_PeekNode();
        v_Peeked();
        e_Reset();
        v_Path();
        e_PeekNode();
        v_Peeked();
        e_Reset();
        v_Path();
        e_PeekNode();
        v_Peeked();
        e_Reset();
        v_Path();
        e_PopEdge();
        v_PopEdge();
        e_Reset();
        v_Path();
        e_AddNotContainsEdge();
        v_NotContainsEdge();
        e_Reset();
        v_Path();
        e_PeekNode();
        v_Peeked();
        e_Reset();
        v_Path();
        e_PopNode();
        v_PopNode();
        e_Reset();
        v_Path();
        e_AddNotContainsEdge();
        v_NotContainsEdge();
        e_Reset();
        v_Path();
        e_InvalidHead();
        v_InvalidHead();
        e_Reset();
        v_Path();
        e_InvalidHead();
        v_InvalidHead();
        e_Reset();
        v_Path();
        e_PopWhileEmptyEdge();
        v_EmptyEdgePopException();
        e_Reset();
        v_Path();
        e_AddNotContainsEdge();
        v_NotContainsEdge();
        e_Reset();
        v_Path();
        e_AddNotContainsEdge();
        v_NotContainsEdge();
        e_Reset();
        v_Path();
        e_PopNode();
        v_PopNode();
        e_Reset();
        v_Path();
        e_PopWhileEmptyNode();
        v_EmptyNodePopException();
        e_Reset();
        v_Path();
        e_PopWhileEmptyNode();
        v_EmptyNodePopException();
        e_Reset();
        v_Path();
        e_PopWhileEmptyNode();
        v_EmptyNodePopException();
        e_Reset();
        v_Path();
        e_PopWhileEmptyNode();
        v_EmptyNodePopException();
        e_Reset();
        v_Path();
        e_PeekNode();
        v_EmptyStack();


    }

}