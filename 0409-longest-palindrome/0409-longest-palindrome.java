class Solution {
  public int longestPalindrome(String s) {
    int ans = 0;
    int[] count = new int[128];
    boolean hasOddCount = false;

    for (final char c : s.toCharArray())
      ++count[c];

    for (final int freq : count) {
      ans += freq / 2 * 2; // Adds the largest even part of freq to ans
      if (freq % 2 == 1) {
        hasOddCount = true;
      }
    }

    if (hasOddCount) {
      ans += 1;
    }

    return ans;
  }
}
