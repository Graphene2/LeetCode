package time_NOV;

import java.util.*;

/**
 * Description:
 * User: zhangcheng
 * Date: 2020-11-06
 * Time: 13:03
 */
public class lc1356根据数字二进制下1的数目排序 {
    public int[] sortByBits(int[] arr) {
        int[] num = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            num[i] = Integer.bitCount(arr[i]) * 10000000 + arr[i];
        }
        Arrays.sort(num);
        for (int i = 0; i < num.length; i++){
            num[i] = num[i] % 10000000;
        }
        return num;
    }
    // 暴力方法！
    public int[] sortByBits2(int[] arr) {
        int[] bis = new int[10001];
        List<Integer> list = new ArrayList<>();
        for (int x : arr){
            list.add(x);
            bis[x] = get(x);
            // bit[i] = bit[i >> 1] + (i & 1);
        }
        Collections.sort(list, new Comparator<Integer>() {
            public int compare(Integer x, Integer y){
                if (bis[x] != bis[y]){
                    return bis[x] - bis[y];
                }else {
                    return x - y;
                }
            }
        });
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    private int get(int x) {
        int res = 0;
        while (x != 0){
            res += x % 2;
            x /= 2;
        }
        return res;
    }
    // 判断x中1的数量如下:
    private   int bitCount(int n){
        int count = 0;
        while(n != 0){
            n = n & (n - 1);
            count++;
        }
        return count;
    }
}
