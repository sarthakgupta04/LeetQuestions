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
  public int[] nodesBetweenCriticalPoints(ListNode head) {
    int minDist = Integer.MAX_VALUE;
    int firstMaIndex = -1;
    int prevMaIndex = -1;
    int index = 1;
    ListNode prev = head;      
    ListNode curr = head.next;

    while (curr.next != null) {
      if (curr.val > prev.val && curr.val > curr.next.val ||
          curr.val < prev.val && curr.val < curr.next.val) {
        if (firstMaIndex == -1) 
          firstMaIndex = index;
        if (prevMaIndex != -1)
          minDist = Math.min(minDist, index - prevMaIndex);
        prevMaIndex = index;
      }
      prev = curr;
      curr = curr.next;
      ++index;
    }

    if (minDist == Integer.MAX_VALUE)
      return new int[] {-1, -1};
    return new int[] {minDist, prevMaIndex - firstMaIndex};
  }
}