public class SegregateZeroOneTwo {

    public static void main(String[] args) {

    }

    static Node segregate(Node head) {
        Node zeros = new Node(0);
        Node tempZ = zeros;

        Node ones = new Node(0);
        Node tempO = ones;

        Node twos = new Node(0);
        Node tempT = twos;

        Node prev = head;
        while (head != null) {
            if (head.data == 0) {
                tempZ.next = head;
                tempZ = tempZ.next;
            }
            if (head.data == 1) {
                tempO.next = head;
                tempO = tempO.next;
            }
            if (head.data == 2) {
                tempT.next = head;
                tempT = tempT.next;
            }
            prev = head.next;
            head.next = null;
            head = prev;
        }
        tempO.next = twos.next;
        tempZ.next = ones.next;

        return zeros.next;

    }
}
