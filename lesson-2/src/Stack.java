

public class Stack {
    private int mSize;
    private String[] stackArray;
    private int top;

    public Stack(int m){
        this.mSize = m;
        stackArray = new String[mSize];
        top = -1;
    }

    public void addElement(String element){
        stackArray[++top] = element;
    }

    public String deleteElement(){
        return stackArray[top--];
    }

    public String readTop(){
        return stackArray[top];
    }

    public boolean isEmpty(){
        return (top==-1);
    }

    public boolean isFull(){
        return (top==mSize-1);
    }
}
