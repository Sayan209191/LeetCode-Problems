class Solution {
    private int[] dx = new int[]{0, 1, 0, -1}; // Directions: right, down, left, up
    private int[] dy = new int[]{1, 0, -1, 0}; // Directions: right, down, left, up
    
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean[][] visited = new boolean[m][n]; // To track visited cells
                    if (canPossible(board, word, i, j, 0, visited)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    private boolean canPossible(char[][] board, String word, int row, int col, int index, boolean[][] visited) {
        if (index == word.length()) { // Base case: word found
            return true;
        }
        
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || visited[row][col] || board[row][col] != word.charAt(index)) {
            return false;
        }
        
        // Mark current cell as visited
        visited[row][col] = true;
        
        // Explore in all four directions
        for (int d = 0; d < 4; d++) {
            int nextRow = row + dx[d];
            int nextCol = col + dy[d];
            if (canPossible(board, word, nextRow, nextCol, index + 1, visited)) {
                return true;
            }
        }
        
        // Backtrack: mark current cell as unvisited
        visited[row][col] = false;
        
        return false;
    }
}
