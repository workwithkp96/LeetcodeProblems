import java.util.ArrayList;
import java.util.List;

public class Problem118_PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> results = new ArrayList<>();
        int count=0;
        while(count<numRows){
            List<Integer> rows = new ArrayList<>();
            for(int i=0;i<=count;i++){
                if(i==0 || i==count){
                    rows.add(1);
                }else{
                    rows.add(results.get(count-1).get(i-1)+results.get(count-1).get(i));
                }
            }
            results.add(rows);
            count++;
        }
        return results;
    }
}
