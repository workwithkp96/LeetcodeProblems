import java.util.Stack;

public class Problem84_LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        int N = heights.length;
        int[] firstSmallestElementToLeft = getFirstSmallestElementToLeft(heights,N);
        int[] firstSmallestElementToRight = getFirstSmallestElementToRight(heights,N);

        int maxResult= Integer.MIN_VALUE;
        for(int i=0;i<N;i++){
            int area = heights[i]*((i-firstSmallestElementToLeft[i])+(firstSmallestElementToRight[i]-i)+1);
            maxResult=Math.max(maxResult,area);
        }
        return maxResult;
    }

    private int[] getFirstSmallestElementToLeft(int[] heights, int N) {
        int[] firstSmallest = new int[N];
        Stack<Integer> st= new Stack<>();
        firstSmallest[0]=0;
        st.push(0);
        for(int i=1;i<N;i++){
            while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
                st.pop();
            }
            if(st.isEmpty()){
                firstSmallest[i]=0;
            }else{
                firstSmallest[i]=st.peek()+1;
            }
            st.push(i);
        }
        return firstSmallest;
    }


    private int[] getFirstSmallestElementToRight(int[] heights, int N) {
        int[] firstSmallest = new int[N];
        Stack<Integer> st= new Stack<>();
        firstSmallest[N-1]=N-1;
        st.push(N-1);
        for(int i=N-2;i>=0;i--){
            while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
                st.pop();
            }
            if(st.isEmpty()){
                firstSmallest[i]=N-1;
            }else{
                firstSmallest[i]=st.peek()-1;
            }
            st.push(i);
        }
        return firstSmallest;
    }
}
