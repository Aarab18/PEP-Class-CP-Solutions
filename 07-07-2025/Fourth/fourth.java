import java.util.*;

public class fourth {
    public static int countSpecialNumbers(int n) {
        List<Integer> digits = new ArrayList<>();
        while (n > 0) {
            digits.add(n % 10);
            n /= 10;
        }
        Collections.reverse(digits);
        int len = digits.size();
        int ans = 0;
        for (int i = 1; i < len; i++) {
            ans += 9 * perm(9, i - 1);
        }
        Set<Integer> seen = new HashSet<>();
        for (int i = 0; i < len; i++) {
            for (int d = (i == 0 ? 1 : 0); d < digits.get(i); d++) {
                if (seen.contains(d)) continue;
                ans += perm(9 - i, len - i - 1);
            }
            if (seen.contains(digits.get(i))) break;
            seen.add(digits.get(i));
            if (i == len - 1) ans++;
        }
        return ans;
    }

    private static int perm(int m, int n) {
        int res = 1;
        for (int i = 0; i < n; i++) {
            res *= (m - i);
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(countSpecialNumbers(n));
    }
}
