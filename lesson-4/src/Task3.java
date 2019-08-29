import java.util.Iterator;
import java.util.ArrayList;
import java.util.LinkedList;

public class Task3 {
    private static int max = 20;
    private static int min = 11;
    public static void main(String[] args) {

        // Задание 3 (сделано в отдельном классе чтобы не пересекались с системными LinkedList и ArrayList)

        LinkedList<Integer> linkedList = new LinkedList<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 50000; i++) {
            linkedList.add(Integer.valueOf((int)(Math.random() * (max - min) + min)));
        }

        long time = System.currentTimeMillis();
        Iterator<Integer> iter = linkedList.iterator();
        while (iter.hasNext()) {
            arrayList.add(iter.next());
        }
        System.out.println("Runtime of reload LinkedList->ArrayList using an iterator was " + (System.currentTimeMillis()-time));
        arrayList = new ArrayList<>();
        time = System.currentTimeMillis();
        for (int i = 0; i < linkedList.size(); i++) {
            arrayList.add(linkedList.get(i));
        }
        System.out.println("Runtime of reload LinkedList->ArrayList using a regular cycle was " + (System.currentTimeMillis()-time));
        linkedList = new LinkedList<>();
        time = System.currentTimeMillis();
        for (int i = 0; i < arrayList.size(); i++) {
            linkedList.add(arrayList.get(i));
        }
        System.out.println("Runtime of reload ArrayList->LinkedList using a regular cycle was " + (System.currentTimeMillis()-time));
        linkedList = new LinkedList<>();
        iter = arrayList.iterator();
        time = System.currentTimeMillis();
       while (iter.hasNext()){
            linkedList.add(iter.next());
        }
        System.out.println("Runtime of reload ArrayList->LinkedList using an iterator was " + (System.currentTimeMillis()-time));
    }
}
