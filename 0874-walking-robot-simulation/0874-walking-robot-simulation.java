import java.util.HashSet;
import java.util.Set;

class Solution {
  public int robotSim(int[] commands, int[][] obstacles) {
    final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // north, east, south, west
    int ans = 0;
    int d = 0; // 0 := north, 1 := east, 2 := south, 3 := west
    int x = 0; // starting x coordinate
    int y = 0; // starting y coordinate
    Set<String> obstaclesSet = new HashSet<>();

    // Storing obstacles as strings for easier comparison
    for (int[] o : obstacles) {
      obstaclesSet.add(o[0] + "," + o[1]);
    }

    for (final int c : commands) {
      if (c == -1) {
        d = (d + 1) % 4;  // turn right
      } else if (c == -2) {
        d = (d + 3) % 4;  // turn left (equivalent to -1 mod 4)
      } else {
        for (int step = 0; step < c; ++step) {
          int nextX = x + dirs[d][0];
          int nextY = y + dirs[d][1];
          
          // Check if the next position is an obstacle
          if (obstaclesSet.contains(nextX + "," + nextY)) {
            break;  // stop moving if there's an obstacle
          }
          
          x = nextX;
          y = nextY;
        }
      }
      ans = Math.max(ans, x * x + y * y);  // keep track of max distance squared
    }

    return ans;
  }
}
