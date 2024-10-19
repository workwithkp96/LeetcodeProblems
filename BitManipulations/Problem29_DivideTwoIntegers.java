package BitManipulations;

public class Problem29_DivideTwoIntegers {
    public static int divide(int dividend, int divisor) {
//        System.out.println((1L<<31));
        long ans=0;
        boolean checkBothNegative = dividend<0 == divisor<0;
        long a = Math.abs(1L*dividend);
        long b = Math.abs(1L*divisor);
        if(a==b){
            return checkBothNegative ? 1:-1;
        }
        while(a>=b){

            int count=0;
            while(a>(b<<(count+1)))
                count++;
            ans = ans + (1L<<(count));
            a -= (b<<(count));
        }
        System.out.println(ans);
        if(ans >= (1L<<31) && checkBothNegative)
            return Integer.MAX_VALUE;
        return checkBothNegative ? (int)ans : (int)-ans;
    }

    public static void main(String[] args) {
        System.out.println(divide(-2147483648,-1));
    }
}
