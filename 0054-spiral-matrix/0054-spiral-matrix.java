class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int stRow = 0;
        int stCol = 0;
        int endRow = matrix.length-1;
        int endCol = matrix[0].length-1;
        
        while(stRow<=endRow && stCol<=endCol) {
            // Top boundary
            for(int j=stCol;j<=endCol;j++){
                ans.add(matrix[stRow][j]);
            }
            // Right boundary
            for(int i=stRow+1;i<=endRow;i++){
                ans.add(matrix[i][endCol]);
            }
            // Bottom Boundary
            for(int j=endCol-1;j>=stCol;j--){
                if(stRow==endRow) break;
                ans.add(matrix[endRow][j]);
            }
            // Left Boundary
            for(int i=endRow-1;i>=stRow+1;i--){
                if(stCol==endCol) break;
                ans.add(matrix[i][stCol]);
            }
            // Update boundary values
            stRow++;
            endRow--;
            stCol++;
            endCol--;
        }
        return ans;
    }
    
}