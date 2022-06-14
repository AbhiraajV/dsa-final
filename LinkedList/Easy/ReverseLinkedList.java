public class ReverseLinkedList {
    public static void main(String[] args) {

    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode prev = null;

        ListNode cur = head;

        ListNode next = head.next;

        while (cur != null) {
            cur.next = prev;
            prev = cur;
            cur = next;
            if (next != null)
                next = next.next;
        }

        head = prev;
        return head;
    }
}
