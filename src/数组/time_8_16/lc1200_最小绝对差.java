package 数组.time_8_16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**leetcode1200: 最小绝对差
 * @author: cheneyzhang2018@gmail.com
 * @date: 2020/8/16,15:44-16:10
 * @version: 1.0
 */
public class lc1200_最小绝对差 {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> ans =  new ArrayList<>();
        int minGap = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++){
            int temp = arr[i] - arr[i - 1];
            minGap = Math.min(minGap, temp);
        }
        for (int i = 1; i < arr.length; i++){
            if (minGap == arr[i] - arr[i - 1]){
                List<Integer> item = new ArrayList<>(2);
                item.add(arr[i - 1]);
                item.add(arr[i]);
                ans.add(item);
            }
        }return ans;
    }
}
