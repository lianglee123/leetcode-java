package joy.leetcode;

public class AddTwoNumber {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode sentinel = new ListNode(0);
        ListNode d = sentinel;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int digitSum = carry;
            digitSum += (l1 != null) ? l1.val : 0;
            digitSum += (l2 != null) ? l2.val : 0;
            carry = digitSum / 10;
            digitSum = digitSum % 10;
            d.next = new ListNode(digitSum);
            d = d.next;
        }

        if (carry != 0) {
            d.next = new ListNode(carry);
        }

        return sentinel.next;
    }

}
