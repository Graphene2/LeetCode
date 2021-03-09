package 排序问题;

/**
 * Description:选择排序,逐个选取当前和后续的数字，找到其中最小的并与之交换。最好和最差情况的比较次数一样多,时间复杂度为 O(N2),适用于数组个数不多，但每个数组元素较大
 * User: zhangcheng
 * Date: 2020-10-30
 * Time: 11:16
 */
public class selectSort {
    public static void selectSort(int[] A){
        for (int i = 0; i < A.length - 1; i++) {
            int min = i;

            for (int j = i + 1; j < A.length; j++) {
                if (A[min] > A[j]){
                    min = j;
                }
            }
            if (i != min){
                int temp = A[i];
                A[i] = A[min];
                A[min] = temp;
            }
        }
    }
}
