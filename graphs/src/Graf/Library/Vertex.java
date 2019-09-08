package Graf.Library;


public class Vertex<T> {

    private T vertex;

    public Vertex(T vertex){
        this.vertex = vertex;
    }

    public T getVertex() {
        return vertex;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Vertex))
            return false;
        if (obj == this)
            return true;

        Vertex _vertex = (Vertex) obj;
        return (this.vertex != null && this.vertex.equals(_vertex.vertex));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((vertex == null) ? 0 : vertex.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return vertex.toString();
    }
}
