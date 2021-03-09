package January;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * User: zhangcheng
 * Date: 2021-01-14
 * Time: 9:12
 */
public class lc1018可被5整除的二进制前缀 {
    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> res = new ArrayList<>();
        int prefix = 0;
        for (int i = 0; i < A.length; i++) {
            prefix = ((prefix << 1)+ A[i]) % 5;
            res.add(prefix == 0);
        }
        return res;
    }
}
