import java.util.*;

public class first {
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> Heap = new PriorityQueue<>();
        for (int num : nums) {
            Heap.offer(num);
            if (Heap.size() > k) {
                Heap.poll();
            }
        }
        return Heap.peek();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        System.out.println(findKthLargest(nums, k));
    }
}
