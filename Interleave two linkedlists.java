// Given 1-2-3-4, 5-6, return 1-5-2-6-3-4

public ListNode interleave(ListNode head1, ListNode head2) {
    if(head1 == null && head2 == null) {
        return null;
    }
    if(head1 != null && head2 == null) {
        return head1;
    }
    if(head2 != null && head1 == null) {
        return head2;
    }
    ListNode result = new ListNode(0);
    ListNode cur = result;
    while(head1 != null && head2 != null) {
        ListNode next = head1.next;
        cur.next = head1;
        head1.next = head2;
        cur = cur.next.next;
        head1 = next;
        head2 = head2.next;       
    }
    if(head1 != null) {
        cur.next = head1;
    }
    if(head2 != null) {
        cur.next = head2;
    }
    return result.next;
}  
