import nerd.Three;

public class Test {
    public static void main(String[] args) {
        double d = Math.sqrt(-1);
        System.out.println(Double.NaN == d);
        d = d / 0;
        System.out.println(Double.isNaN(d));
    }
}
