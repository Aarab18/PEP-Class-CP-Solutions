import java.util.*;

public class second {
    public static long waysToBuyPensPencils(int total, int cost1, int cost2) {
        long ways = 0;
        for (long i = 0; i * cost1 <= total; i++) {
            long remaining = total - i * cost1;
            ways += (remaining / cost2) + 1;
        }
        return ways;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total = sc.nextInt();
        int cost1 = sc.nextInt();
        int cost2 = sc.nextInt();
        System.out.println(waysToBuyPensPencils(total, cost1, cost2));
    }
}
