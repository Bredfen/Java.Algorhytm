package Graf.Library;


import Graf.Library.Interfaces.Edge;


public class DirectEdge implements Edge {

    private Vertex firstVertex;
    private Vertex secondVertex;

    public DirectEdge(Vertex firstVertex, Vertex secondVertex){
        this.firstVertex = firstVertex;
        this.secondVertex = secondVertex;
    }

    @Override
    public boolean isLeadingVertex(Vertex vertex) {
        return vertex.equals(firstVertex);
    }

    @Override
    public Vertex getSlaveVertex(Vertex leadingVertex) {
        return secondVertex;
    }

    @Override
    public Vertex getLeadingVertex(Vertex slaveVertex) {
        return firstVertex;
    }

    @Override
    public String toString(){
        return firstVertex.toString() + " -> " + secondVertex.toString();
    }
}
