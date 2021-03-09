package hot100;

/**
 * Description:
 * User: zhangcheng
 * Date: 2020-11-18
 * Time: 14:39
 */
public class lc338比特位计数 {
    // 时间复杂度为n * sizeof(Integer)
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        for (int i = 1; i < num + 1; i++) {
            res[i] = length(i);
        }
        return res;
    }
    private int length(int x) {
        int count = 0;
        for (count = 0; x != 0; count++) {
            x &= (x - 1);
        }
        return count;
    }
    // 动态规划 +
    public int[] countBits2(int num) {
        int[] res = new int[num + 1];
        int i = 0, b = 1;
        while (b <= num){
            while (i < b && i + b <= num){
                res[i + b] = res[i] + 1;
                ++i;
            }
            i = 0;
            b <<= 1;
        }
        return res;
    }
}
