package January;

import LinkedList.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 双指针
 * User: zhangcheng
 * Date: 2021-01-11
 * Time: 9:52
 */
public class lc228汇总区间 {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums == null) return res;
        int i = 0;
        int n = nums.length;
        while (i < n){
            int left = i;
            i++;
            while (i < n && nums[i - 1] + 1 == nums[i]){
                i++;
            }
            int right = i - 1;
            StringBuilder temp = new StringBuilder(Integer.toString(nums[left]));
            if (left < right){
                temp.append("->");
                temp.append(nums[right]);
            }
            res.add(temp.toString());
        }
        return res;
    }

    public List<String> summaryRanges2(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums == null) return res;
        if (nums.length == 1){
            res.add(Integer.toString(nums[0]));
        }
        int i = 0;
        int n = nums.length;
        for (int j = 0; j < n ; j++) {
            if (j + 1 == n || nums[j] + 1 != nums[j + 1]){
                StringBuilder sb = new StringBuilder();
                sb.append(nums[i]);
                if (i != j){
                    sb.append("->").append(nums[j]);
                }
                res.add(sb.toString());
                i = j + 1;
            }
        }
        return res;
    }

}
