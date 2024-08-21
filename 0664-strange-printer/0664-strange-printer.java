class Solution {
  public int strangePrinter(String s) {
    final int n = s.length();
    int[][] num = new int[n][n];
    return strangePrinter(s, 0, n - 1, num);
  }
 //using recursion
  private int strangePrinter(String s, int i, int j, int[][] num) {
    if (i > j)
      return 0;
    if (num[i][j] > 0)
      return num[i][j];

    num[i][j] = strangePrinter(s, i + 1, j, num) + 1;

    for (int k = i + 1; k <= j; k++)
      if (s.charAt(k) == s.charAt(i))
        num[i][j] = Math.min(num[i][j], strangePrinter(s, i, k - 1, num) + //
                                            strangePrinter(s, k + 1, j, num));

    return num[i][j];
  }
}