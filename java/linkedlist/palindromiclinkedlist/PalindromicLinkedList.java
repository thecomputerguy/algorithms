package linkedlist.palindromiclinkedlist;

public class PalindromicLinkedList {

    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;
        // Find the middle of the linked list.
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode reverseHead = reverse(slow);
        ListNode second = reverseHead;
        ListNode first = head;
        while (first != null && second != null && first.value == second.value) {
            first = first.next;
            second = second.next;
        }
        reverse(reverseHead);
        return first == null || second == null;
    }

    public static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
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
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(2);
        System.out.println("Is palindrome: " + PalindromicLinkedList.isPalindrome(head));

        head.next.next.next.next.next = new ListNode(2);
        System.out.println("Is palindrome: " + PalindromicLinkedList.isPalindrome(head));
    }

}

class ListNode {
    int value = 0;
    ListNode next;

    ListNode(int value) {
        this.value = value;
    }
}
