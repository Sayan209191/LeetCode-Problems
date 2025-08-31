class Solution {
    public void solveSudoku(char[][] board) {
        if(board == null || board.length == 0) {
            return;
        }
        isSudukuSolve(board, 0, 0);
            
    }
    public static char[][] isSudukuSolve(char[][] board, int row, int col) {
        if(row == 9) {
            return board;
        }

        int nextRow=row, nextCol = col+1;
        if(col+1 == 9) {
            nextRow = row+1;
            nextCol = 0;
        }
        if(board[row][col] != '.') {
            return isSudukuSolve(board, nextRow, nextCol);
        }

        for(int digit=1; digit<=9; digit++) {
            char ch = (char)(digit+'0');
            if(isSafe(board, row, col, ch)) {
                board[row][col] = ch;
                char[][] result =isSudukuSolve(board, nextRow, nextCol);
                if(result != null) {
                    return result;
                }
                board[row][col] = '.';
            }
        }
        return null;
    }
    public static boolean isSafe(char suduko[][],int row,int col,char digit){
        // For Row
        for(int j=0;j<9;j++){
            if(suduko[row][j]==digit){
                return false;
            }
        }
        // For Column
        for(int i=0;i<9;i++){
            if(suduko[i][col]==digit){
                return false;
            }
        }
        // For Grid
        int sr=(row/3)*3;
        int sc=(col/3)*3;
        for(int i=sr;i<sr+3;i++){
            for(int j=sc;j<sc+3;j++){
                if(suduko[i][j]==digit){
                    return false;
                }
            }
        }
        return true;
    }
}