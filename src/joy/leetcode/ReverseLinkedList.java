package joy.leetcode;

class ListNode {
    int val;

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }

    ListNode next;
    ListNode(int x) {
        val = x;
    }
    ListNode(int x, ListNode nxt) {
        val = x;
        next = nxt;
    }
}

public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode pre = head;
        ListNode current = head.next;
        while (current != null) {
            ListNode temp = current.next;
            current.next = pre;
            pre = current;
            current = temp;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode header = new ListNode(10, new ListNode(9, new ListNode(8)));
        System.out.println(header);
        ReverseLinkedList r = new ReverseLinkedList();
        header = r.reverseList(header);
        System.out.println(header.val);
        System.out.println(header.next.val);
        System.out.println(header.next.next.val);

//        System.out.println(header.val);
//        System.out.println(header);
    }
}
