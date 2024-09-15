class Solution {
  public int longestSubarray(int[] nums) {
    int maxNum = Integer.MIN_VALUE;
    int ans = 0;
    int currentLength = 0;

    for (int num : nums) {
      if (num > maxNum) {
        maxNum = num;
      }
    }

    for (int num : nums) {
      if (num == maxNum) {
        currentLength++;
        ans = Math.max(ans, currentLength);
      } else {
        currentLength = 0;
      }
    }

    return ans;
  }
}
