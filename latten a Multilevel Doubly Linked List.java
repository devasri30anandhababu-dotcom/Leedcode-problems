class Solution {
    public Node flatten(Node head) {
        if (head == null) {
            return null;
        }

        Node curr = head;
        while(curr != null) {
            if (curr.child != null) {
                Node nextNode = curr.next;
                
                // find the tail of the child
                Node childTail = curr.child;
                while (childTail.next != null) {
                    childTail = childTail.next;
                }
                
                // connect child tail with the nextNode
                if(nextNode != null) {
                    childTail.next = nextNode;
                    nextNode.prev = childTail;
                }

                // connect child with current
                curr.next = curr.child;
                curr.child.prev = curr;
                curr.child = null;
            }
            curr = curr.next;
        }
        return head;
    }
}
