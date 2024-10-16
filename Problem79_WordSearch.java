package Leetcode;

public class Problem79_WordSearch {
    public boolean exist(char[][] board, String word) {
        int M =  board.length;
        int N = board[0].length;
        int len = word.length();
        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                if(board[i][j]==word.charAt(0)){
                    if(wordFound(i,j,M,N,0,word, board)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean wordFound(int i, int j, int m, int n, int l, String word, char[][] board) {
        if(l==word.length())
            return true;

        if(i<0 || i>=m || j<0 ||j>=n || board[i][j]==' ')
            return false;

        if(board[i][j]==word.charAt(l)){
            board[i][j]=' ';
            boolean top = wordFound(i-1,j,m,n,l+1,word,board);
            if(top)
                return true;
            boolean bottom = wordFound(i+1,j,m,n,l+1,word,board);
            if(bottom)
                return true;
            boolean left = wordFound(i,j-1,m,n,l+1,word,board);
            if(left)
                return true;
            boolean right = wordFound(i,j+1,m,n,l+1,word,board);
            if(right)
                return true;
            board[i][j]=word.charAt(l);
        }
        return false;
    }
}
