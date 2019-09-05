package Node;

public class Node {
    public int key; //ключ
    public String data; //данные
    public Node leftChild;
    public Node rightChild;

    public void printNode(){
        System.out.println(key + " - " + data);
    }
}
