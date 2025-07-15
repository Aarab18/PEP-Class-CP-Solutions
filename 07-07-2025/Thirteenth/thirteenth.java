import java.util.*;

public class thirteenth {
    public static int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int hold = -prices[0];
        int cash = 0;

        for (int i = 1; i < n; i++) {
            int prevHold = hold;
            hold = Math.max(hold, cash - prices[i]);
            cash = Math.max(cash, prevHold + prices[i] - fee);
        }

        return cash;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] prices = new int[n];
        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextInt();
        }
        int fee = sc.nextInt();
        System.out.println(maxProfit(prices, fee));
    }
}
