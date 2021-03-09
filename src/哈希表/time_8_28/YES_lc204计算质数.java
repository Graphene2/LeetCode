package 哈希表.time_8_28;

import java.util.Arrays;

/**最优的算法比较经典！ 同时可以考虑怎么计算最优算法的时间复杂度！
 *  题目: 统计所有小于非负整数 n 的质数的数量。
 * 12.3 第二遍，全忘了
 * @author: cheneyzhang2018@gmail.com
 * @date: 2020/8/28,20:23
 * @version: 1.0
 */
public class YES_lc204计算质数 {
    // 该算法超时了！！！ 时间复杂度为O(n2)
    public int countPrimes(int n) {
        int count = 2;
        if (n == 0 || n == 1 || n == 2) return 0;
        if (n == 3) return 1;
        for (int i = 4; i <= n; i++){
            if (isZhishu(i)) count++;
        }
        return count;
    }

    private boolean isZhishu(int n) {
        int m = n / 2;
        while (m > 1){
            if (n % m == 0){
                return false;
            }else m--;
        }
        return true;
    }
    // 采用时间复杂度更低的算法，典型的用空间换时间。
    // 时间复杂度计算为O(NloglogN)
    public int countPrimes2(int n) {
        boolean[] isPrim = new boolean[n];
        // 将数组都初始化为 true
        Arrays.fill(isPrim, true);

        for (int i = 2; i * i < n; i++) // 这里是优化到sqrt(n),
            if (isPrim[i])
                // i 的倍数不可能是素数了
                for (int j = 2 * i; j < n; j += i) // 这里也可以优化到i*i再开始进行标记！
                    isPrim[j] = false;

        int count = 0;
        for (int i = 2; i < n; i++)
            if (isPrim[i]) count++;

        return count;
    }
    // 空间换时间  重写
    public int countPrimes4(int n) {
        boolean[] isPrimes = new boolean[n];
        Arrays.fill(isPrimes,true);
        for (int i = 2; i * i <= n; i++) {
            if (isPrimes[i]){
                // 这里原本是从2 * i 开始访问的，可以优化到i ^ 2;
                for (int j = i * i; j < n; j += i) {
                    isPrimes[j] = false;
                }
            }
        }
        int count = 0;
        for (int i = 2 ;i <= n ; i++) {
            if (isPrimes[i])
                count++;
        }
        return count;
    }
}
