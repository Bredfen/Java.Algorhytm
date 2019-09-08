package Graf;

import Graf.Library.DirectedGraph;
import Graf.Library.Interfaces.Edge;
import Graf.Library.Interfaces.Graph;
import Graf.Library.UnDirectedGraph;
import Graf.Library.Vertex;

import java.util.List;

public class Program {

    public static void main(String [] args){

        Graph graph = new DirectedGraph();
        Vertex<Integer> _1 = new Vertex<Integer>(1);
        Vertex<Integer> _2 = new Vertex<Integer>(2);
        Vertex<Integer> _3 = new Vertex<Integer>(3);
        Vertex<Integer> _4 = new Vertex<Integer>(4);
        Vertex<Integer> _5 = new Vertex<Integer>(5);
        Vertex<Integer> _6 = new Vertex<Integer>(6);
        Vertex<Integer> _7 = new Vertex<Integer>(7);
        Vertex<Integer> _8 = new Vertex<Integer>(8);
        Vertex<Integer> _9 = new Vertex<Integer>(9);
        Vertex<Integer> _10 = new Vertex<Integer>(10);

        graph.addEdge(_1,_2);
        graph.addEdge(_2,_4);
        graph.addEdge(_2,_3);
        graph.addEdge(_3,_5);
        graph.addEdge(_4,_5);
        graph.addEdge(_5,_6);
        graph.addEdge(_5,_9);
        graph.addEdge(_5,_7);
        graph.addEdge(_9,_10);
        graph.addEdge(_10,_7);
        graph.addEdge(_7,_8);
        graph.addEdge(_8,_7);




        List<Edge> path = graph.getPath(_1, _8);

        for (Edge edge : path){
            System.out.println(edge.toString());
        }

        path = graph.getPath(_2, _10);
        System.out.println();

        for (Edge edge : path){
            System.out.println(edge.toString());
        }
    }

}
