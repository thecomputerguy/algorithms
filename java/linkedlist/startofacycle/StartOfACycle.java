package linkedlist.startofacycle;

public class StartOfACycle {

    public static ListNode findCycleStart(ListNode head) {
        if (head == null)
            return null;

        ListNode slow = head;
        ListNode fast = head;
        int cycleLength = 0;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                cycleLength = lengthOfACycle(slow);
                break;
            }
        }

        return findStart(head, cycleLength);
    }

    public static ListNode findStart(ListNode head, int cycleLength) {
        System.out.println("cycle length is " + cycleLength);
        ListNode pointer1 = head;
        ListNode pointer2 = head;
        int len = cycleLength;
        while (len > 0) {
            pointer2 = pointer2.next;
            len--;
        }

        while (pointer1 != pointer2) {
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
        }
        return pointer1;
    }

    public static int lengthOfACycle(ListNode slow) {
        ListNode current = slow;
        int count = 0;
        do {
            current = current.next;
            count++;
        } while (current != slow);
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
        System.out.println("LinkedList cycle start: " + StartOfACycle.findCycleStart(head).value);

        head.next.next.next.next.next.next = head.next.next.next;
        System.out.println("LinkedList cycle start: " + StartOfACycle.findCycleStart(head).value);

        head.next.next.next.next.next.next = head;
        System.out.println("LinkedList cycle start: " + StartOfACycle.findCycleStart(head).value);
    }

}

class ListNode {
    int value = 0;
    ListNode next;

    ListNode(int value) {
        this.value = value;
    }
}