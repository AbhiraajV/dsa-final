public class RemoveLoop {
    public static void main(String[] args) {

    }

    public static void removeLoop(Node head) {
        Node slow = head, fast = head, prev = null;

        boolean flag = false;

        while (fast != null && fast.next != null) {
            prev = fast;
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                flag = true;
                break;
            }
        }
        if (!flag)
            return;

        slow = head;

        if (slow == fast) {
            prev.next.next = null;
            return;
        }

        while (slow.next != fast.next) {
            slow = slow.next;
            fast = fast.next;
        }

        fast.next = null;

    }
}
