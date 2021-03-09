package binarySearch;

/**
 * Description:
 * User: zhangcheng
 * Date: 2020-10-17
 * Time: 17:08
 */
public class lc287寻找重复数 {
    // 使用空间换时间的方法，首先了解抽屉原理,复杂度: 时间为NlogN,空间为1
    public int findDuplicate(int[] nums) {
        int len = nums.length;
        int left = 1;
        int right = len - 1;
        while (left < right){
            int mid = (left + right) / 2;
            int cnt = 0;
            for (int num:nums){
                if (num <= mid){
                    cnt++;
                }
            }
            if (cnt > mid){
                right = mid;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }
    // 双指针，快慢指针跳跃前进
    public int findDuplicate2(int[] nums){
        int slow = 0, fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while (slow != fast);
        slow = 0;
        while (slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
