class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> seen=new HashSet<>();

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='.')continue;
                
                String row=board[i][j]+" in row "+i;
                String col=board[i][j]+" in col "+j;
                String square=board[i][j]+" in square "+(i/3)+","+(j/3);

                if(seen.contains(row) || seen.contains(col) || seen.contains(square)){
                    return false;
                }

                seen.add(row);
                seen.add(col);
                seen.add(square);
            }
        }
        return true;

    }
}
