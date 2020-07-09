package linkedlist.rearrangelist;

public class RearrangeList {

    public static void reorder(ListNode head) {
        if (head == null)
            return;
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;
        ListNode reverseHead = reverse(slow);
        ListNode first = head;
        ListNode second = reverseHead;

        rearrangeNodes(first, second);
    }

    public static void rearrangeNodes(ListNode first, ListNode second) {
        while (first != null && second != null) {
            ListNode firstNext = first.next;
            ListNode secondNext = second.next;
            first.next = second;
            second.next = firstNext;
            first = firstNext;
            second = secondNext;
        }
        if (second != null)
            first.next = second;
    }

    public static void display(ListNode node) {
        ListNode current = node;
        while (current != null) {
            System.out.println(current.value);
            current = current.next;
        }
    }

    public static ListNode reverse(ListNode slow) {
        ListNode current = slow;
        ListNode prev = null;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(8);
        head.next.next.next.next = new ListNode(10);
        head.next.next.next.next.next = new ListNode(12);
        RearrangeList.reorder(head);
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
    }

}

class ListNode {
    int value = 0;
    ListNode next;

    ListNode(int value) {
        this.value = value;
    }
}
