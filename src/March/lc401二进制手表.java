package March;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * User: zhangcheng
 * Date: 2021-03-29
 * Time: 9:03
 */
public class lc401二进制手表 {
    List<String> res = new ArrayList<>();
    int[] a = new int[]{1,2,4,8,1,2,4,8,16,32};
    public List<String> readBinaryWatch(int num){
        dfs(num, 0 , 0, 0);
        return res;
    }
    // h 为时， m 为分， index 为位置。
    private void dfs(int cnt, int h, int m, int index) {
        if (cnt == 0){
            res.add(h + ":" + (m > 9 ? m : "0" + m));
            return;
        }
        for (int i = index; i < 10 && cnt > 0; i++) {
            if (i < 4 && h + a[i] < 12){
                dfs(cnt - 1,h + a[i],m,i + 1);
            }
            if (i >= 4 && m + a[i] < 60){
                dfs(cnt - 1, h, m + a[i], i + 1);
            }
        }

    }

}
