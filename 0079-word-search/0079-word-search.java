public class Solution {
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (bcsFunc(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean bcsFunc(char[][] board, String word, int x, int y, int z) {
        if (z == word.length()) return true;

        int row = board.length;
        int col = board[0].length;

        if (x < 0 || x >= row || y < 0 || y >= col || word.charAt(z) != board[x][y]) {
            return false;
        }

        char visited = board[x][y];
        board[x][y] = '.';

        boolean result = bcsFunc(board, word, x + 1, y, z + 1) ||
                         bcsFunc(board, word, x - 1, y, z + 1) ||
                         bcsFunc(board, word, x, y + 1, z + 1) ||
                         bcsFunc(board, word, x, y - 1, z + 1);

        board[x][y] = visited;
        return result;
    }
}
