class seventh {
    private final int SIZE = 1000;
    private Node[] buckets;

    private static class Node {
        int key;
        Node next;

        Node(int key) {
            this.key = key;
        }
    }

    public seventh() {
        buckets = new Node[SIZE];
    }

    private int hash(int key) {
        return key % SIZE;
    }

    public void add(int key) {
        int index = hash(key);
        Node head = buckets[index];
        Node curr = head;
        while (curr != null) {
            if (curr.key == key) return;
            curr = curr.next;
        }
        Node newNode = new Node(key);
        newNode.next = head;
        buckets[index] = newNode;
    }

    public void remove(int key) {
        int index = hash(key);
        Node curr = buckets[index];
        Node prev = null;
        while (curr != null) {
            if (curr.key == key) {
                if (prev == null) buckets[index] = curr.next;
                else prev.next = curr.next;
                return;
            }
            prev = curr;
            curr = curr.next;
        }
    }

    public boolean contains(int key) {
        int index = hash(key);
        Node curr = buckets[index];
        while (curr != null) {
            if (curr.key == key) return true;
            curr = curr.next;
        }
        return false;
    }

    public static void main(String[] args) {
        seventh set = new seventh();
        set.add(1);
        set.add(2);
        System.out.println(set.contains(1));
        System.out.println(set.contains(3));
        set.add(2);
        System.out.println(set.contains(2));
        set.remove(2);
        System.out.println(set.contains(2));
    }
}
