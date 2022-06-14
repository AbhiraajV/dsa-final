public class RemoveNthNode {
    public static void main(String[] args) {

    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
        int len = getLen(temp);
        System.out.println(len);
        return remove(temp, len - n);
    }

    static ListNode remove(ListNode head, int index) {
        if (index < 1)
            return head.next;
        ListNode temp = head;
        for (int i = index; i > 1 && temp != null; i--)
            temp = temp.next;
        if (temp != null && temp.next != null)
            temp.next = temp.next.next;
        return head;
    }

    static int getLen(ListNode head) {
        if (head == null)
            return 0;
        return 1 + getLen(head.next);
    }
}
