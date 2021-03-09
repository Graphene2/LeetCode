package 数组.time_8_14;

/**leetcode27 移除元素 双指针，有优雅！
 * @author: cheneyzhang2018@gmail.com
 * @date: 2020/8/14,19:04
 * @version: 1.0
 */
public class YES_lc27_removeElement {
    public static int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++){
            if (nums[j] != val){
                nums[i] = nums[j];
                i++;
            }
        }return i;
    }
    public static int removeElement2(int[] nums, int val) {
        int n = nums.length;
        int i = 0;
        while (i < n){
            if (nums[i] == val){
                nums[i] = nums[n-1];
                n--;
            }else {
                i++;
            }
        }return n;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{0,1,2,2,3,0,4,2};
        int m = removeElement2(arr,2);
        System.out.println();
        for (int item:arr){
            System.out.print(item+"\t");
        }
    }
}
