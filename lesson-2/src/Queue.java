import java.sql.Statement;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Vector;

public class Queue {
    private int[] queue;
    private int maxSize; // max count elements in Q
    private int nElem; // current E
    private int front;
    private int rear;

    public Queue(int maxSize) {
        this.maxSize = maxSize;
        queue = new int[maxSize];
        rear = -1;
        front = 0;
        nElem = 0;
    }

    public void insert(int elem){
        if(rear == maxSize-1){
            rear = -1;
        }
        queue[++rear] = elem;
        nElem++;
    }

    public int remove(){
        int temp = queue[front++]; // первый элемент из очереди
        if(front==maxSize){
            front = 0;
        }
        nElem--;
        return temp;
    }

    public boolean isEmpty(){
        return (nElem==0);
    }

    public static void main(String[] args) {
        Queue myQueue = new Queue(5);
        myQueue.insert(10);
        myQueue.insert(20);
        myQueue.insert(30);
        myQueue.insert(40);
        myQueue.insert(50);

        myQueue.remove();
        myQueue.remove();
        myQueue.remove();

        myQueue.insert(60);

        while (!myQueue.isEmpty()){
            int n = myQueue.remove();
            System.out.println(n);
        }
    }
}
