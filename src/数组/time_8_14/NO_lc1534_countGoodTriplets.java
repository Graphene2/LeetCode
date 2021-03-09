package 数组.time_8_14;

/**leetcode1534: 统计好三元数组  多重循环加剪枝，无新意！
 * @author: cheneyzhang2018@gmail.com
 * @date: 2020/8/14,14:57-15:15
 * @version: 1.0
 */
public class NO_lc1534_countGoodTriplets {
    public static int countGoodTriplets(int[] arr, int a, int b, int c){
        int len = arr.length;
        int cnt = 0;
        for (int i = 0; i < len - 2; i++) {
            for (int j = i + 1; j < len - 1; j++){
                if (Math.abs(arr[i] - arr[j]) <= a){
                    for(int k=j+1;k<len;++k){
                        if (Math.abs(arr[j] - arr[k]) <= b && Math.abs(arr[i] - arr[k]) <= c){
                            cnt++;
                        }
                    }
                }else
                    continue;
            }
        }
        return cnt;

    }
}
