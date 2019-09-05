package nerd;

import java.util.ArrayList;

public class BinaryTree {
    private static class BinaryTreeElement {
        public Comparable object;
        public BinaryTreeElement leftChild;
        public BinaryTreeElement rightChild;

    }
    private BinaryTreeElement root;

    public boolean isEmpty(){
        return root==null;
    }
    public boolean add(Comparable o){
        while(true) {
            try {
                root = add(o, root);
                break;
            }catch(ArrayStoreException e){
                continue;
            }
        }
        return true;
    }

    private BinaryTreeElement add(Comparable o,BinaryTreeElement element){
        if(element==null){
            element=new BinaryTreeElement();
            element.object=o;
            return element;
        }
        else {
            //номер элементов не должен совпадать
            while(o.CompareTo(element.object) == 0) {
                o.nextNumber();
                //исключение используется для сброса стека (рекурсия) и сортировки элемента по его новому номеру с начала дерева
                throw new ArrayStoreException();
            }
            if (o.CompareTo(element.object) > 0) {
                //добавить справа
                element.rightChild = add(o, element.rightChild);
                return element;
            } else {
                //добавить слева
                element.leftChild = add(o, element.leftChild);
                return element;
            }
        }
    }

    private void add(BinaryTreeElement element,boolean b){
        if(element.leftChild!=null) add(element.leftChild,true);
        if(element.rightChild!=null) add(element.rightChild,true);
        if(b) add(element.object);
    }

    public Comparable delete(int number)throws NullPointerException {
        if (root == null) throw new NullPointerException();
        //объект, данные которого будут предоставлены в отчете об удалении
        Comparable object;
        //рекурсивный метод работает с детьми заданной точки, следовательно будет лучше вынести раьоту с корнем а данный метод
        if (root.object.getNumber() == number) {
            object = root.object;
            if (root.leftChild == null) {
                if (root.rightChild == null) root = null;
                else root = root.rightChild;
            }
            else {
                if (root.rightChild == null) {
                    if (root.leftChild == null) root = null;
                    else root = root.leftChild;
                }
                else {
                    if (root.leftChild != null && root.rightChild != null) {
                        try {
                            BinaryTreeElement element=deleteMinChild(root.rightChild);
                            root.object = element.object;
                            add(element,false);
                        }catch(NullPointerException e){
                            //это значит, что левой ветки у правого узла нет, и он сам минимальный
                            root.rightChild.leftChild=root.leftChild;
                            root=root.rightChild;
                        }
                    }
                }
            }
            return object;
        }
        object=delete(number, root);
        return object;
    }

    private BinaryTreeElement deleteMinChild(BinaryTreeElement element){
        if(element.leftChild.leftChild==null){
            BinaryTreeElement find=element.leftChild;
            element.leftChild=null;
            return find;
        }
        return deleteMinChild(element.leftChild);
    }


    private Comparable delete(int number, BinaryTreeElement element) throws NullPointerException{
        //это возвращаемый объект
        Comparable result=null;

        //необходимо идти вправо
        if(element.object.getNumber() < number) {
            //если правый потомок подходит
            if (element.rightChild.object.getNumber() == number) {
                //правый узел-искомый элемент
                result = element.rightChild.object;

                //если у узла-потомка нет дочерних узлов, его требуется удалить
                if (element.rightChild.leftChild == null && element.rightChild.rightChild == null) element.rightChild = null;
                else {
                    if(element.rightChild.leftChild!=null && element.rightChild.rightChild!=null){
                        try {
                            BinaryTreeElement newElement = deleteMinChild(element.rightChild.rightChild);
                            element.rightChild.object=newElement.object;
                            add(newElement,false);
                        }catch(NullPointerException e){
                            //это значит, что в левой ветке правого узла элемента нет элементов и он сам минимальный
                            element.rightChild.rightChild.leftChild=element.rightChild.leftChild;
                            element.rightChild=element.rightChild.rightChild;
                        }
                    }
                    else {
                        if (element.rightChild.leftChild == null) element.rightChild = element.rightChild.rightChild;
                        else {
                            if (element.rightChild.rightChild == null)
                                element.rightChild = element.rightChild.leftChild;
                        }
                    }
                }
            }
            else{
                result=delete(number,element.rightChild);
            }
        }
        //необходимо идти влево
        else {
            if (element.leftChild.object.getNumber() == number) {
                //левый узел-искомый элемент
                result = element.leftChild.object;

                //если у узла-потомка нет дочерних узлов, его требуется удалить
                if (element.leftChild.leftChild == null && element.leftChild.rightChild == null) element.leftChild = null;
                else {
                    if (element.leftChild.leftChild!=null && element.leftChild.rightChild!=null){
                        try{
                            BinaryTreeElement newElement = deleteMinChild(element.leftChild.rightChild);
                            element.leftChild.object=newElement.object;
                            add(newElement,false);

                        }catch(NullPointerException e){
                            //это значит, что в левой ветке правого узла элемента нет элементов и он сам минимальный
                            element.leftChild.rightChild.leftChild=element.leftChild.leftChild;
                            element.leftChild=element.leftChild.rightChild;
                        }
                    }
                    else{
                        if(element.leftChild.rightChild==null) element.leftChild=element.leftChild.leftChild;
                        else{
                            if(element.leftChild.leftChild==null) element.leftChild=element.leftChild.rightChild;
                        }
                    }
                }
            }
            else{
                result=delete(number,element.leftChild);
            }
        }
        return result;
    }

    public Object[] output(){
        /*if(root==null) throw new NullPointerException();
        Object[] result=this.toArray();
        if(result.length==0) return new String[]{"Бинарное дерево не содержит элементов"};
        for(int i=0;i<result.length;i++){
            Comparable c=(Comparable)result[i];
            result[i]=c.toString();
        }
        return result;*/
        if(root!=null)
            return output(root);
        return new String[]{"Бинарное дерево не содержит элементов"};
    }

    private Object[] output(BinaryTreeElement element) {
        ArrayList<String> result = new ArrayList<>();
        if (element.leftChild != null) {
            Object[] temp = output(element.leftChild);
            for (int i = 0; i < temp.length; i++) {
                result.add("    "+ temp[i]);
            }
        }
        result.add(element.object.toString());
        if (element.rightChild != null) {
            Object[] temp = output(element.rightChild);
            for (int i = 0; i < temp.length; i++) {
                result.add("    " + temp[i]);
            }
        }
        return result.toArray();
    }

    public Object[] toArray(){
        if(root==null) throw new NullPointerException();
        return toArray(root);
    }

    private Object[] toArray(BinaryTreeElement element){
        ArrayList<Comparable> result=new ArrayList<>();
        if (element.leftChild != null) {
            Object[] temp = toArray(element.leftChild);
            for (int i = 0; i < temp.length; i++) {
                Comparable object=(Comparable)temp[i];
                result.add(object);
            }
        }
        result.add(element.object);
        if (element.rightChild != null) {
            Object[] temp = toArray(element.rightChild);
            for (int i = 0; i < temp.length; i++) {
                Comparable object=(Comparable)temp[i];
                result.add(object);
            }
        }
        return result.toArray();
    }
}
