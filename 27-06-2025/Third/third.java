import java.util.*;

public class third {
    public static int minPatches(int[] coins, int V) {
        int patches = 0;
        long miss = 1;
        int i = 0;
        while (miss <= V) {
            if (i < coins.length && coins[i] <= miss) {
                miss += coins[i++];
            } else {
                miss += miss;
                patches++;
            }
        }
        return patches;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }
        int V = sc.nextInt();
        System.out.println(minPatches(coins, V));
    }
}
