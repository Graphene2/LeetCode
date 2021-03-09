package March;

/**
 * Description:
 * User: zhangcheng
 * Date: 2021-03-01
 * Time: 16:36
 */
public class lc191_EAZY {
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0){
            count++;
            n &= (n - 1);
        }
        return count;
    }
}
