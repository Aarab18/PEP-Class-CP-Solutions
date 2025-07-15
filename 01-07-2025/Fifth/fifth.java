import java.util.*;

class Skiplist {
    static class Node {
        int val;
        List<Node> forward;
        Node(int val, int level) {
            this.val = val;
            forward = new ArrayList<>();
            for (int i = 0; i < level; i++) {
                forward.add(null);
            }
        }
    }

    Node head;
    int maxLevel = 16;
    double p = 0.5;
    Random rand = new Random();

    public Skiplist() {
        head = new Node(-1, maxLevel);
    }

    private int randomLevel() {
        int level = 1;
        while (rand.nextDouble() < p && level < maxLevel) {
            level++;
        }
        return level;
    }

    public boolean search(int target) {
        Node curr = head;
        for (int i = maxLevel - 1; i >= 0; i--) {
            while (curr.forward.get(i) != null && curr.forward.get(i).val < target) {
                curr = curr.forward.get(i);
            }
        }
        curr = curr.forward.get(0);
        return curr != null && curr.val == target;
    }

    public void add(int num) {
        Node curr = head;
        Node[] update = new Node[maxLevel];
        for (int i = maxLevel - 1; i >= 0; i--) {
            while (curr.forward.get(i) != null && curr.forward.get(i).val < num) {
                curr = curr.forward.get(i);
            }
            update[i] = curr;
        }
        int level = randomLevel();
        Node newNode = new Node(num, level);
        for (int i = 0; i < level; i++) {
            newNode.forward.set(i, update[i].forward.get(i));
            update[i].forward.set(i, newNode);
        }
    }

    public boolean erase(int num) {
        Node curr = head;
        Node[] update = new Node[maxLevel];
        boolean found = false;
        for (int i = maxLevel - 1; i >= 0; i--) {
            while (curr.forward.get(i) != null && curr.forward.get(i).val < num) {
                curr = curr.forward.get(i);
            }
            update[i] = curr;
        }
        curr = curr.forward.get(0);
        if (curr == null || curr.val != num) return false;
        for (int i = 0; i < maxLevel; i++) {
            if (update[i].forward.get(i) != curr) break;
            update[i].forward.set(i, curr.forward.get(i));
        }
        return true;
    }
}

public class fifth {
    public static void main(String[] args) {
        Skiplist skiplist = new Skiplist();
        skiplist.add(1);
        skiplist.add(2);
        skiplist.add(3);
        System.out.println(skiplist.search(0));
        skiplist.add(4);
        System.out.println(skiplist.search(1));
        System.out.println(skiplist.erase(0));
        System.out.println(skiplist.erase(1));
        System.out.println(skiplist.search(1));
    }
}
