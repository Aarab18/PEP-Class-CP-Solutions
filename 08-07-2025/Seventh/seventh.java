import java.util.*;

public class seventh {
    public static int[] frequencySort(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) freq.put(num, freq.getOrDefault(num, 0) + 1);

        Integer[] boxed = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(boxed, (a, b) -> {
            int fa = freq.get(a), fb = freq.get(b);
            if (fa != fb) return fa - fb;
            return b - a;
        });

        return Arrays.stream(boxed).mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = sc.nextInt();
        int[] result = frequencySort(nums);
        for (int num : result) System.out.print(num + " ");
    }
}
