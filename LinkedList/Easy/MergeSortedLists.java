public class MergeSortedLists {
    public static void main(String[] args) {

    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode newHead = new ListNode();

        ListNode tempHead = newHead;

        while (list1 != null && list2 != null) {

            if (list1.val < list2.val) {
                tempHead.next = list1;
                list1 = list1.next;
            } else {
                tempHead.next = list2;
                list2 = list2.next;
            }
            ;

            tempHead = tempHead.next;

        }

        if (list1 != null)
            tempHead.next = list1;
        else if (list2 != null)
            tempHead.next = list2;

        return newHead.next;
    }
}
