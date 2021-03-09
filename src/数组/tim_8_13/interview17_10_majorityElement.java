package 数组.tim_8_13;

import java.util.HashMap;
import java.util.Map;

/**面试题17.10： 主要元素：数组中占比超过一半的元素称之为主要元素。给定一个整数数组，找到它的主要元素。若没有，返回-1。
 *思路一：哈希表+暴力搜索，时间复杂度为O(N)，但是空间复杂度也为O(N).
 * 思路二： 摩尔投票法：
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/8/13 13:29-14:42
 */
public class interview17_10_majorityElement {
    public static int majorityElement(int[] nums){
        Map<Integer,Integer> map = new HashMap<>();
        for (int item:nums){
            if (map.containsKey(item)){
                map.put(item,map.get(item)+1);
            }else map.put(item,1);
            if (map.get(item) > nums.length / 2) {
                return item;
            }

        }
        return -1;
    }
    // 方法二：摩尔投票法：关键在于抵消了就把当前值赋值给res
    public static int majorityElement2(int[] nums){
        int res = nums[0];
        int count = 1;
        if(nums == null){
            return -1;
        }
        for (int i = 1 ; i < nums.length ; i++){
            if (res != nums[i]){
                count--;
            }else count++;
            if(count == 0){
                res = nums[i];
                count = 1;
            }
        }
        // 结果验证算法：
        int temp = 0;
        for (int i=0 ; i < nums.length ; i++){
            if (nums[i] == res) temp++;
        }
        if (temp > nums.length / 2) return res;
        else return -1;

    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,2,1,1,2,2,1};
        int m = majorityElement2(arr);
        System.out.println(m);
    }
}
