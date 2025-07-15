import java.util.*;

public class seventh {
    public static boolean stoneGame(int[] piles) {
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] piles = new int[n];
        for (int i = 0; i < n; i++) {
            piles[i] = sc.nextInt();
        }
        boolean result = stoneGame(piles);
        System.out.println(result);
    }
}
