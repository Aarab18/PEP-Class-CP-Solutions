import java.util.*;

public class fourth {
    public static int nextGreaterElement(int n) {
        char[] arr = Integer.toString(n).toCharArray();
        int i = arr.length - 2;
        while (i >= 0 && arr[i] >= arr[i + 1]) i--;
        if (i == -1) return -1;
        int j = arr.length - 1;
        while (arr[j] <= arr[i]) j--;
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        Arrays.sort(arr, i + 1, arr.length);
        long val = Long.parseLong(new String(arr));
        return val > Integer.MAX_VALUE ? -1 : (int) val;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(nextGreaterElement(n));
    }
}
