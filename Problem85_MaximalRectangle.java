import java.util.Stack;

public class Problem85_MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] intArray = new int[rows][cols];
        int maxResult = Integer.MIN_VALUE;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                intArray[i][j] = matrix[i][j] - '0';
            }
        }

        maxResult = largestRectangleArea(intArray[rows-1], cols);

        for(int i=rows-2;i>=0;i--){
            for(int j=0;j<cols;j++){
                if(intArray[i][j]!=0){
                    intArray[i][j]+=intArray[i+1][j];
                }
            }
            maxResult = Math.max(maxResult,largestRectangleArea(intArray[i],cols));
        }
        return Math.max(0,maxResult);
    }

    public int largestRectangleArea(int[] heights, int N) {
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
