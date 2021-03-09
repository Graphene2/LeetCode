package time_NOV;

/**
 * Description:
 * User: zhangcheng
 * Date: 2020-11-13
 * Time: 16:40
 */
public class lc461汉明距离 {
    public int hammingDistance(int x, int y) {
        int count = 0;
        while (x > 0 || y > 0){
            int m = x % 2;
            int n = y % 2;
            count += m ^ n;
            x /= 2;
            y /= 2;
        }
        return count;
    }
    public int hammingDistance2(int x, int y) {
        int xor = x ^ y;
        int distance = 0;
        while (xor != 0) {
            if (xor % 2 == 1)
                distance += 1;
            xor = xor >> 1;
        }
        return distance;
    }
    // 当我们在 number 和 number-1 上做 AND 位运算时，原数字 number 的最右边等于 1 的比特会被移除。
    public int hammingDistance3(int x, int y) {
        int xor = x ^ y;
        int distance = 0;
        while (xor != 0) {
            distance += 1;
            xor = xor & (xor - 1);
        }
        return distance;
    }
}
