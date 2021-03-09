package 数组.time_8_14;

/**leetcode1385: 两个数组之间的距离值 此为暴力法，还可以用二分法将arr2排序。
 * @author: cheneyzhang2018@gmail.com
 * @date: 2020/8/14,15:35-15:49
 * @version: 1.0
 */
public class NO_lc1385_findTheDistanceValue {
    public static int findTheDistanceValue(int[] arr1, int[] arr2, int d){
        int count = arr1.length;
        for (int i = 0; i < arr1.length; i++){
            for (int j = 0; j < arr2.length; j++){
                if (arr1[i] - d <= arr2[j] && arr2[j] <= arr1[i] + d){
                    count--;
                    break;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{2,1,100,3};
        int[] arr2 = new int[]{-5,-2,10,-3,7};
        int m = findTheDistanceValue(arr1,arr2,6);
        System.out.println(m);
    }
}
