package 排序问题;

/**
 * Description:冒泡排序 , 是稳定排序,通常认为平均时间复杂度为O(N2),最大为O(N2),最小情况为数组已经是正序,最小时间复杂度为O(N)
 * User: zhangcheng
 * Date: 2020-10-30
 * Time: 10:27
 */
public class BubbleSort {
    public static void BubbleSort(int [] arr){
        boolean flag = true;
        for (int i = 0; i < arr.length && flag; i++) {
            flag = false;               // 设置该标志位表示当某次后续数组中全部已经进行好了归并的排序，也就是整个数组已经排序好了。我们直接停止for循环
            for (int j = arr.length - 1; j > i ; j--) {
                if (arr[j] < arr[j - 1]){
                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                    flag = true;
                }
            }
        }
    }
}
