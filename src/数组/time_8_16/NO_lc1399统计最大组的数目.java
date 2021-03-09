package 数组.time_8_16;

/**leetcode1399 统计最大组的数目 比较简单
 * @author: cheneyzhang2018@gmail.com
 * @date: 2020/8/16,20:13
 * @version: 1.0
 */
public class NO_lc1399统计最大组的数目 {
    public int countLargestGroup(int n) {
        if(n < 9) return n;
        int[] arr = new int[37];
        for (int i = 1; i <= n; i++){
            int temp = i;
            int sum = 0;
            while (temp > 0){
                sum += temp % 10;
                temp /= 10;
            }
            arr[sum]++;
        }
        // 寻找arr中最大值
        int max = 1;
        int ans = 1;
        for (int i =1; i < 38;i++){
            if (arr[i] > max){
                max = arr[i];
                ans = 1;
            }else if (arr[i] == max){
                ans++;
            }
        }
        return ans;
    }
}
