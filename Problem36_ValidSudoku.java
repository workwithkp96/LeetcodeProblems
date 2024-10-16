package Leetcode;

public class Problem36_ValidSudoku {
    public boolean isValidSudoku(char[][] board) {

        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                char ch = board[i][j];
                if(checkRow_Col(ch,j,i,board) && checkGrid(ch,(i/3)*3,(j/3)*3, i, j, board))
                    return false;
            }
        }

        return true;
    }

    private boolean checkGrid(char ch, int r, int c, int row, int col, char[][]board) {
        for(int i=r;i<r+3;i++){
            for(int j=c;j<c+3;j++){
                if(i!=row && j!=col && ch==board[i][j])
                    return true;
            }
        }
        return false;
    }

    private boolean checkRow_Col(char ch, int row, int col, char[][] board) {
        for(int i=0;i<9;i++){
            if(i!=row && ch==board[i][col])
                return true;
        }

        for(int j=0;j<9;j++){
            if(j!=col && ch==board[row][j])
                return true;
        }

        return false;
    }
}
