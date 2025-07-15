class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
    }
}

public class sixth {
    public static ListNode reverseEvenLengthGroups(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevGroupEnd = dummy;
        ListNode curr = head;
        int groupSize = 1;
        while (curr != null) {
            ListNode groupStart = curr;
            int count = 0;
            while (curr != null && count < groupSize) {
                curr = curr.next;
                count++;
            }
            if (count % 2 == 0) {
                ListNode reversed = reverse(groupStart, count);
                prevGroupEnd.next = reversed;
                prevGroupEnd = groupStart;
                groupStart.next = curr;
            } else {
                prevGroupEnd = groupStart;
                for (int i = 1; i < count; i++) {
                    prevGroupEnd = prevGroupEnd.next;
                }
            }
            groupSize++;
        }
        return dummy.next;
    }

    private static ListNode reverse(ListNode head, int k) {
        ListNode prev = null;
        ListNode curr = head;
        while (k-- > 0) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] values = {1, 2, 3, 4, 5, 6};
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int val : values) {
            current.next = new ListNode(val);
            current = current.next;
        }
        ListNode result = reverseEvenLengthGroups(dummy.next);
        printList(result);
    }
}
