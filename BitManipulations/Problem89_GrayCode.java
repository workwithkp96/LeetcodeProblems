package BitManipulations;

import java.util.ArrayList;
import java.util.List;

public class Problem89_GrayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        result.add(0);

        int totalNumbers = (1<<n);

        for(int i=1;i<totalNumbers;i++)
            result.add(i^(i>>1));

        return result;
    }
}
