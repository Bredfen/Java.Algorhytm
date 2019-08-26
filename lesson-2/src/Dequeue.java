public class Dequeue {
    int size;
    int head;
    int tail;
    String[] date;

    Dequeue(int size){
        date = new String[this.size = size];
    }

    void pushBack(String value){
        if(++tail == size){
            tail = 0;
        }
        date[tail] = value;
    }

    String popBack(){
        String ret = date[tail];
        if(--tail<0){
            tail = size-1;
        }
        return ret;
    }

    String popFront(){
        if(++head==size){
            head = 0;
        }
        return date[head];
    }

    void pushFront(String value){
        date[head] = value;
        if(--head<0){
            head = size-1;
        }
    }

    boolean isEmpty(){
        return head==tail;
    }

    public static void main(String[] args) {
        //для теста
        Dequeue mDequeue = new Dequeue(10);
        String someString = "some_text";
        for (int i = 0; i < someString.length(); i++) {
            mDequeue.pushFront(Character.toString(someString.charAt(i)));
        }
        someString = "";
        while (!mDequeue.isEmpty()){
            someString += mDequeue.popBack();
        }
        System.out.println(someString);
    }

}
