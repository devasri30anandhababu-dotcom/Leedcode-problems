class Solution {
    public ListNode sortList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        // Find middle
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Split into two lists
        ListNode left = head;
        ListNode right = slow.next;
        slow.next = null;

        // Sort both halves
        left = sortList(left);
        right = sortList(right);

        // Merge
        return merge(left, right);
    }

    private ListNode merge(ListNode a, ListNode b) {

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (a != null && b != null) {

            if (a.val <= b.val) {
                curr.next = a;
                a = a.next;
            } else {
                curr.next = b;
                b = b.next;
            }

            curr = curr.next;
        }

        if (a != null) {
            curr.next = a;
        } else {
            curr.next = b;
        }

        return dummy.next;
    }
}
