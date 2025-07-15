import java.util.*;

public class eighth {
    public static int stoneGameII(int[] piles) {
        int n = piles.length;
        int[] suffixSum = new int[n];
        suffixSum[n - 1] = piles[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            suffixSum[i] = piles[i] + suffixSum[i + 1];
        }

        int[][] dp = new int[n + 1][n + 1];

        for (int i = n - 1; i >= 0; i--) {
            for (int m = 1; m <= n; m++) {
                for (int x = 1; x <= 2 * m && i + x <= n; x++) {
                    dp[i][m] = Math.max(dp[i][m], suffixSum[i] - dp[i + x][Math.max(m, x)]);
                }
            }
        }

        return dp[0][1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] piles = new int[n];
        for (int i = 0; i < n; i++) {
            piles[i] = sc.nextInt();
        }
        System.out.println(stoneGameII(piles));
    }
}
