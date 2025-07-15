import java.util.*;

class eighth {
    private static class Node {
        int key, value;
        Node next;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int SIZE = 1000;
    private Node[] map;

    public eighth() {
        map = new Node[SIZE];
    }

    private int hash(int key) {
        return key % SIZE;
    }

    public void put(int key, int value) {
        int index = hash(key);
        if (map[index] == null) {
            map[index] = new Node(-1, -1);
        }
        Node prev = find(map[index], key);
        if (prev.next == null) {
            prev.next = new Node(key, value);
        } else {
            prev.next.value = value;
        }
    }

    public int get(int key) {
        int index = hash(key);
        if (map[index] == null) return -1;
        Node prev = find(map[index], key);
        if (prev.next == null) return -1;
        return prev.next.value;
    }

    public void remove(int key) {
        int index = hash(key);
        if (map[index] == null) return;
        Node prev = find(map[index], key);
        if (prev.next == null) return;
        prev.next = prev.next.next;
    }

    private Node find(Node head, int key) {
        Node curr = head, prev = null;
        while (curr != null && curr.key != key) {
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }

    public static void main(String[] args) {
        eighth obj = new eighth();
        obj.put(1, 1);
        obj.put(2, 2);
        System.out.println(obj.get(1));
        System.out.println(obj.get(3));
        obj.put(2, 1);
        System.out.println(obj.get(2));
        obj.remove(2);
        System.out.println(obj.get(2));
    }
}
