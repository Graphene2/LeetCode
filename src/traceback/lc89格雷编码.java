package traceback;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * User: zhangcheng
 * Date: 2020-10-22
 * Time: 10:17-10:25
 */
public class lc89格雷编码 {
    public List<Integer> grayCode(int n){
        List<Integer> res = new ArrayList<>(){{add(0);}};
        int head = 1;
        for (int i = 0; i < n; i++) {
            for (int j = res.size() - 1; j >= 0; j--){
                res.add(head + res.get(j));
            }
            head = head << 1;
        }
        return res;
    }
}
