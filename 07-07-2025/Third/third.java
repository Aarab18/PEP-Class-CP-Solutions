import java.util.Scanner;

public class third {
    public static int countDigitOne(int n) {
        int count = 0;
        for (long i = 1; i <= n; i *= 10) {
            long div = i * 10;
            count += (n / div) * i + Math.min(Math.max(n % div - i + 1, 0), i);
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(countDigitOne(n));
    }
}
