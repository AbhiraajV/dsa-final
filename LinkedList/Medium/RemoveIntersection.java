public class RemoveLoop {
    public static void main(String[] args) {

    }

    int intersectPoint(Node head1, Node head2) {
        int len1 = getLen(head1);
        int len2 = getLen(head2);
        int headStart = Math.abs(len1 - len2);

        if (len1 > len2)
            for (int i = 0; i < headStart; i++)
                head1 = head1.next;
        else
            for (int i = 0; i < headStart; i++)
                head2 = head2.next;

        while (head1 != head2) {
            head1 = head1.next;
            head2 = head2.next;
        }
        return head1.data;
    }

    static int getLen(Node head) {
        if (head == null)
            return 0;
        return 1 + getLen(head.next);
    }
}
