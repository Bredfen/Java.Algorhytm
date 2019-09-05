package Node;

public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insert(3,"aaaaaa");
        tree.insert(8, "qqqq");
        tree.insert(1, "zzzz");
        tree.insert(2,"gggg");

        Node findNode = tree.find(3);
        findNode.printNode();

        tree.print(findNode);
    }
}
