package Node;
import java.util.ArrayList;
import java.util.List;
//здесь дз
public class TreeDz<T extends Comparable<T>> {
    private T val;
    private TreeDz left;
    private TreeDz right;
    private TreeDz parent;
    private List<T> listForPrint = new ArrayList<>();
    public T val() {
        return val;
    }
    public TreeDz left() {
        return left;
    }
    public TreeDz right() {
        return right;
    }
    public TreeDz parent() {
        return parent;
    }
    public TreeDz(T val, TreeDz parent) {
        this.val = val;
        this.parent = parent;
    }
    public void add(T...vals){
        for(T v : vals){
            add(v);
        }
    }
    public void add(T val){
        if(val.compareTo(this.val) < 0){
            if(this.left==null){
                this.left = new TreeDz(val, this);
            }
            else if(this.left != null)
                this.left.add(val);
        }
        else{
            if(this.right==null){
                this.right = new TreeDz(val, this);
            }
            else if(this.right != null)
                this.right.add(val);
        }
    }
    private TreeDz<T> _search(TreeDz<T> TreeDz, T val){
        if(TreeDz == null) return null;
        switch (val.compareTo(TreeDz.val)){
            case 1: return _search(TreeDz.right, val);
            case -1: return _search(TreeDz.left, val);
            case 0: return TreeDz;
            default: return null;
        }
    }
    public TreeDz<T> search(T val){
        return _search(this, val);
    }
    public boolean remove(T val){
        //Проверяем, существует ли данный узел
        TreeDz<T> TreeDz = search(val);
        if(TreeDz == null){
            //Если узла не существует, вернем false
            return false;
        }
        TreeDz<T> curTreeDz;
        //Если удаляем корень
        if(TreeDz == this){
            if(TreeDz.right!=null) {
                curTreeDz = TreeDz.right;
            }
            else curTreeDz = TreeDz.left;
            while (curTreeDz.left != null) {
                curTreeDz = curTreeDz.left;
            }
            T temp = curTreeDz.val;
            this.remove(temp);
            TreeDz.val = temp;
            return true;
        }
        //Удаление листьев
        if(TreeDz.left==null && TreeDz.right==null && TreeDz.parent != null){
            if(TreeDz == TreeDz.parent.left)
                TreeDz.parent.left = null;
            else {
                TreeDz.parent.right = null;
            }
            return true;
        }
        //Удаление узла, имеющего левое поддерево, но не имеющее правого поддерева
        if(TreeDz.left != null && TreeDz.right == null){
            //Меняем родителя
            TreeDz.left.parent = TreeDz.parent;
            if(TreeDz == TreeDz.parent.left){
                TreeDz.parent.left = TreeDz.left;
            }
            else if(TreeDz == TreeDz.parent.right){
                TreeDz.parent.right = TreeDz.left;
            }
            return true;
        }
        //Удаление узла, имеющего правое поддерево, но не имеющее левого поддерева
        if(TreeDz.left == null && TreeDz.right != null){
            //Меняем родителя
            TreeDz.right.parent = TreeDz.parent;
            if(TreeDz == TreeDz.parent.left){
                TreeDz.parent.left = TreeDz.right;
            }
            else if(TreeDz == TreeDz.parent.right){
                TreeDz.parent.right = TreeDz.right;
            }
            return true;
        }
        //Удаляем узел, имеющий поддеревья с обеих сторон
        if(TreeDz.right!=null && TreeDz.left!=null) {
            curTreeDz = TreeDz.right;
            while (curTreeDz.left != null) {
                curTreeDz = curTreeDz.left;
            }
            //Если самый левый элемент является первым потомком
            if(curTreeDz.parent == TreeDz) {
                curTreeDz.left = TreeDz.left;
                TreeDz.left.parent = curTreeDz;
                curTreeDz.parent = TreeDz.parent;
                if (TreeDz == TreeDz.parent.left) {
                    TreeDz.parent.left = curTreeDz;
                } else if (TreeDz == TreeDz.parent.right) {
                    TreeDz.parent.right = curTreeDz;
                }
                return true;
            }
            //Если самый левый элемент НЕ является первым потомком
            else {
                if (curTreeDz.right != null) {
                    curTreeDz.right.parent = curTreeDz.parent;
                }
                curTreeDz.parent.left = curTreeDz.right;
                curTreeDz.right = TreeDz.right;
                curTreeDz.left = TreeDz.left;
                TreeDz.left.parent = curTreeDz;
                TreeDz.right.parent = curTreeDz;
                curTreeDz.parent = TreeDz.parent;
                if (TreeDz == TreeDz.parent.left) {
                    TreeDz.parent.left = curTreeDz;
                } else if (TreeDz == TreeDz.parent.right) {
                    TreeDz.parent.right = curTreeDz;
                }
                return true;
            }
        }
        return false;
    }
    private void _print(TreeDz<T> node){
        if(node == null) return;
        _print(node.left);
        listForPrint.add(node.val);
        System.out.print(node + " ");
        if(node.right!=null)
            _print(node.right);
    }
    public void print(){
        listForPrint.clear();
        _print(this);
        System.out.println();
    }
    @Override
    public String toString() {
        return val.toString();
    }
    public static <T> boolean isBalanced(TreeDz root){
        return checkBalance(root) != -1;
    }

    private static <T> int checkBalance(TreeDz node){
        if(node == null) return 0;
        int left = checkBalance(node.left());

        if(left == -1) return -1;

        int right = checkBalance(node.right());

        if(right == -1) return -1;

        if(Math.abs(left - right) > 1){
            return -1;
        }else{
            return 1 + Math.max(left, right);
        }
    }

}
class Sttt{
    public static void main(String[] args) {
        //Создадим дерево с корневым элементом 33
        ArrayList arrayofTree = new ArrayList<TreeDz>();
        for (int i = 0; i < 10; i++) {
            int d = -100 + (int)(Math.random() * 100);
            TreeDz<Integer> tree = new TreeDz<>(d, null);
            for (int j = 0; j < 63; j++) {
                d = -100 + (int)(Math.random() * 100);
                tree.add(Integer.valueOf(d));
            }
            arrayofTree.add(tree);
        }
        int counter = 0;
        for (int i = 0; i < arrayofTree.size(); i++) {
            TreeDz irr = (TreeDz) arrayofTree.get(i);
            counter += (irr.isBalanced(irr))?0:1;
        }
        System.out.println("Percent of imbalanced trees is "+(double) (counter/arrayofTree.size())*100d + "%");
    }
}