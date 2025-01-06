import java.util.Arrays;

public class Problem72_EditDistance {
    int[][] dp;
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        dp = new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            Arrays.fill(dp[i],-1);
        }

        for(int i=0;i<=m;i++){
            dp[i][0]=n;
        }

        for(int i=0;i<=n;i++){
            dp[0][i]=m;
        }

        return getMinDistance(word1,word2,m,n);
    }

    private int getMinDistance(String w1, String w2, int m, int n) {
        if(m==0) //if the length of w1 is 0 then we need to insert n characters.
            return n;
        if(n==0)//if the length of w2 is 0 then we need to delete m characters
            return m;

        if(dp[m][n]!=-1)
            return dp[m][n];

        if(w1.charAt(m-1)==w2.charAt(n-1)){
            dp[m][n]=getMinDistance(w1,w2,m-1,n-1);
        }else{
            dp[m][n] = 1+Math.min(getMinDistance(w1,w2,m-1,n) //delete
                    ,Math.min(getMinDistance(w1,w2,m-1,n-1) //replace
                            ,getMinDistance(w1,w2,m,n-1))); //insert
        }

        return dp[m][n];
    }


    public int minDistanceBottomUpApproach(String w1, String w2) {
        int m = w1.length();
        int n = w2.length();
        dp = new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            Arrays.fill(dp[i],-1);
        }

        for(int i=0;i<=m;i++){
            dp[i][0]=n;
        }

        for(int i=0;i<=n;i++){
            dp[0][i]=m;
        }

        for(int i=1;i<=m;i++){
            for(int j=1;j<n;j++){
                if(w1.charAt(i-1)==w2.charAt(j-1))
                    dp[i][j]=dp[i-1][j-1];
                else{
                    dp[i][j]=1+ Math.min(dp[i][j-1],Math.min(dp[i-1][j-1],dp[i-1][j]));
                }
            }
        }
        return dp[m][n];
    }
}
