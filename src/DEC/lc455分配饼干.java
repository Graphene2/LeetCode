package DEC;

import java.util.Arrays;


/**
 * Description: 贪心算法
 * User: zhangcheng
 * Date: 2020-12-25
 * Time: 9:00
 */
public class lc455分配饼干 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int sLen = s.length, gLen = g.length;
        int i = 0, j = 0;
        int count = 0 ;
        while (i < gLen && j < sLen){
            if (g[i] <= s[j]){
                count++;
                i++;j++;
            }else {
                j++;
            }
        }
        return count;
    }
}
