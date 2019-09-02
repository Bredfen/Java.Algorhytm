import java.util.ArrayList;
import java.util.List;

public class Knapsack {
    static int[] values = new int[] {600, 5000, 1500, 40000, 500};
    static int[] weights = new int[] {1, 2, 4, 2, 1};
    static int W = 15;

    private static int knapsack(int i, int W) {
        if (i < 0) {
            return 0;
        }
        if (weights[i] > W) {
            return knapsack(i-1, W);
        } else {
            return Math.max(knapsack(i-1, W), knapsack(i-1, W - weights[i]) + values[i]);
        }
    }

    public static void main(String[] args) {
        System.out.println(knapsack(values.length - 1, W));
    }
}

