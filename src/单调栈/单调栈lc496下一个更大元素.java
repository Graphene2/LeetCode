package 单调栈;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**单调栈lc496下一个更大元素
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/8/20 15:25
 */
public class 单调栈lc496下一个更大元素 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> s = new Stack<>();
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++){
            while (!s.isEmpty() && nums2[i] > nums2[s.peek()]){
                map.put(nums2[s.peek()], nums2[i]);
                s.pop();
            }
            s.push(i);
        }
        for (int i = 0; i < nums1.length; i++){
            if (map.containsKey(nums1[i])){
                nums1[i] = map.get(nums1[i]);
            }else nums1[i] = -1;
        }
        return nums1;
    }
}
