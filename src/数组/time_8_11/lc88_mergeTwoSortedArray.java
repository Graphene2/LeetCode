package 数组.time_8_11;

/**
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/8/11 10:56
 */
public class lc88_mergeTwoSortedArray {
    public static void merge(int[] nums1, int m, int[] nums2, int n){
        int p1 = m - 1, p2 = n - 1;
        int p = m + n - 1;
        while ((p1 >= 0) && (p2 >= 0)) {
            nums1[p--] = (nums1[p1] > nums2[p2] ? nums1[p1--] : nums2[p2--]);

        }System.arraycopy(nums2,0,nums1,0,p2+1);
    }



    public static void main(String[] args) {
        int[] nums1 = new int[]{2,5,6,7,9,0,0,0};
        int[] nums2 = new int[]{1,2,3};
        for (int item:nums1){
            System.out.print(item+"\t");
        }
        System.out.println();
        merge(nums1,5,nums2,3);
        for (int item:nums1){
            System.out.print(item+"\t");
        }
    }
}
