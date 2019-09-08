package Graf.Library;


import Graf.Library.Interfaces.Edge;

public class UnDirectedEdge implements Edge {

    private Vertex firstVertex;
    private Vertex secondVertex;

    public UnDirectedEdge(Vertex firstVertex, Vertex secondVertex){
        this.firstVertex = firstVertex;
        this.secondVertex = secondVertex;
    }

    @Override
    public boolean isLeadingVertex(Vertex vertex) {
        return vertex.equals(firstVertex) || vertex.equals(secondVertex);
    }

    @Override
    public Vertex getSlaveVertex(Vertex leadingVertex) {
        return leadingVertex.equals(firstVertex) ? secondVertex : firstVertex;
    }

    @Override
    public Vertex getLeadingVertex(Vertex slaveVertex) {
        return slaveVertex.equals(firstVertex) ? secondVertex : firstVertex;
    }

    @Override
    public String toString(){
        return firstVertex.toString() + " - " + secondVertex.toString();
    }
}

