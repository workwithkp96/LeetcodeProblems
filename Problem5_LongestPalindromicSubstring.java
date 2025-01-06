public class Problem5_LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int n = s.length();
        String res = "";
        int resLen = 0;

        for(int i=0;i<n;i++){
            // calculating for odd palindrome
            int l=i,r=i;
            while(l>=0 && r<n && s.charAt(l)==s.charAt(r)){
                if((r-l+1)>resLen){
                    res = s.substring(l,r+1);
                    resLen = r-l+1;
                }
                l--;
                r++;
            }

            //calculating for the even palindrome
            l=i;r=i+1;
            while(l>=0 && r<n && s.charAt(l)==s.charAt(r)){
                if((r-l+1)>resLen){
                    res = s.substring(l,r+1);
                    resLen = r-l+1;
                }
                l--;
                r++;
            }
        }
        return res;
    }

    public String longestPalindromeManacherAlgo(String s) {
        int n = s.length();
        int C=0,R=0;
        int[] P = new int[2*n+1];
        int maxLen=0;
        s = "$"+s.replaceAll("","#")+"@";
        String result="";
        P[0]=0;

        for(int i=1;i<(2*n+1);i++){
            int mirror = 2*C-i;

            if(i<R){
                P[i]=Math.min(R-i,P[mirror]);
            }

            while(s.charAt(i+(1+P[i]))==s.charAt(i-(1+P[i])))
                P[i]++;
            if(i+P[i]>R){
                C=i;
                R=i+P[i];
            }
            if(P[i]>maxLen){
                maxLen = P[i];
                result = s.substring(C-P[i],R).replaceAll("#","");
            }
        }
        return result;
    }

}
