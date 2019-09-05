public class Ex {
//    O(h), h - максимальная глубина дерева
//    h^2 = n; O(log(n))
//    static class Node<T1, T2> {
//        T1 key;
//        T2 value;
//        Node<T1, T2> left, right;
//
//        Node(T1 key, T2 value) {
//            this.key = key;
//            this.value = value;
//        }
//
//        public T2 get(T1 k){
//            Node<T1, T2> x = root;//определяется в main, вершина
//            while(x!=null){
//                int cmp = k.compareTO(x.key); // описывается в интерфейсе ком.
//                if(cmp == 0){
//                    return x.value;
//                }
//                if(cmp<0){
//                    x=x.left;
//                } else{
//                    x = x.right;
//                }
//            }
//            return null;
//        }
//
//        public T2 add(T1 k, T2 value){
//            Node<T1, T2> x = root, y = null;//определяется в main, вершина
//            while(x!=null){
//                int cmp = k.compareTO(x.key); // описывается в интерфейсе ком.
//                if(cmp == 0){
//                    x.value = value;
//                    return;
//                } else {
//                    y = x;
//                    if(cmp<0){
//                        x=x.left;
//                    } else {
//                        x = x.right;
//                    }
//                }
//            }
//            Node<T1, T2> newNode = new Node<T1, T2>(k, value);
//            if(y==null){
//                root = newNode;
//            }else{
//                if(k.compareTO(y.key)<0){
//                    y.left = newNode;
//                } else{
//                    y.right = newNode;
//                }
//            }
//            return null;
//        }
//
//        public void remove(T1 k){
//            Node<T1, T2> x = root, y = null;//определяется в main, вершина
//            while(x!=null){
//                int cmp = k.compareTO(x.key); // описывается в интерфейсе ком.
//                if(cmp == 0){
//                    break;
//                } else {
//                    y = x;
//                    if(cmp<0){
//                        x=x.left;
//                    } else {
//                        x = x.right;
//                    }
//                }
//            }
//            if(x==null){
//                return;
//            }
//            if(x.right==null){
//                if(y == null){
//                    root = x.left;
//                } else{
//                    if(x==y.left){
//                        y.left = x.left;
//                    }else{
//                        y.right=x.left;
//                    }
//                }
//            }else{
//                Node<T1, T2> leftMost = x.right;
//                y = null;
//                while(leftMost.left !=null){
//                    y=leftMost;
//                    leftMost = leftMost.left;
//                }
//                if(y!=null){
//                    y.left = leftMost.right;
//                } else{
//                    x.right = leftMost.right;
//                }
//                x.key = leftMost.key;
//                x.value = leftMost.value;
//            }
//
//        }
//    }


}
