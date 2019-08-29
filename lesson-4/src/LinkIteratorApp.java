
public class LinkIteratorApp {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        LinkIterator itr = new LinkIterator(list);

        itr.insertAfter("Artem", 20);
        itr.insertBefore("Sergey", 10);

        list.display();
        System.out.println();
        System.out.println(itr.getCurrent().name);
        itr.deleteCurrent();
        list.display();
        System.out.println(itr.atEnd());
        itr.insertBefore("Majira Strawberry",23);
        itr.insertAfter("BetaEtaDelota",25);
        list.display();
        System.out.println(itr.getCurrent().name);
        itr.nextLink();
        itr.deleteCurrent();
        System.out.println();
        list.display();
        itr.reset();
        System.out.println(itr.getCurrent().name);



    }

}
