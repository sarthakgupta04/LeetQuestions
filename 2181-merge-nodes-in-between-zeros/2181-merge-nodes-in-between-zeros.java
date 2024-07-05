/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
  public ListNode mergeNodes(ListNode head) {
    ListNode curr = head.next;

    while (curr != null) {
      ListNode running = curr;
      int sum = 0;
      while (running.val > 0) {
        sum += running.val;
        running = running.next;
      }
      curr.val = sum;
      curr.next = running.next;
      curr = running.next;
    }

    return head.next;
  }
}