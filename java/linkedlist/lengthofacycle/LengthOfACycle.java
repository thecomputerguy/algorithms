package linkedlist.lengthofacycle;

public class LengthOfACycle {

    public static int lengthOfACycleIfExists(ListNode head) {
        if (head == null)
            return 0;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return lengthOfACycle(slow);
            }
        }
        return 0;
    }

    public static int lengthOfACycle(ListNode node) {
        ListNode current = node;
        int count = 0;
        do {
            current = current.next;
            count++;
        } while (current != node);
        return count;
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = head.next.next;
        System.out.println("LinkedList cycle length: " + lengthOfACycleIfExists(head));

        head.next.next.next.next.next.next = head.next.next.next;
        System.out.println("LinkedList cycle length: " + lengthOfACycleIfExists(head));
    }
}

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}