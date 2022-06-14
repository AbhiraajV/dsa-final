public class ReOrderLinkedList {
    public static void main(String[] args) {

    }

    public void reorderList(ListNode head) {
        ListNode temp = head;
        int mid = (int) getLen(temp) / 2;

        while (mid > 1) {
            temp = temp.next;
            mid--;
        }

        ListNode revStart = temp.next;
        temp.next = null;
        head = mergeTwoLists(head, reverse(revStart));
    }

    static ListNode reverse(ListNode head) {

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

    static int getLen(ListNode head) {
        if (head == null)
            return 0;
        return 1 + getLen(head.next);
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode newHead = new ListNode();

        ListNode tempHead = newHead;

        while (list1 != null && list2 != null) {
            tempHead.next = list1;
            list1 = list1.next;

            tempHead = tempHead.next;

            tempHead.next = list2;
            list2 = list2.next;

            tempHead = tempHead.next;

        }

        if (list1 != null)
            tempHead.next = list1;
        else if (list2 != null)
            tempHead.next = list2;

        return newHead.next;
    }
}
