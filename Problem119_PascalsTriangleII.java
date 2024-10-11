import java.util.ArrayList;
import java.util.List;

public class Problem119_PascalsTriangleII {
    public List<Integer> getRow(int rowIndex) {
        int count=0;
        List<Integer> results = new ArrayList<>();
        while(count<=rowIndex){
            List<Integer> rows = new ArrayList<>();
            for(int i=0;i<=count;i++){
                if(i==0 || i==count){
                    rows.add(1);
                }else{
                    rows.add(results.get(i-1)+results.get(i));
                }
            }
            results = rows;
            count++;
        }
        return results;
    }
}
