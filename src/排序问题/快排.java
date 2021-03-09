package 排序问题;

import 哈希表.time_8_28.QuickSort;

import java.util.Arrays;
import java.util.Queue;

/**
 * Description:
 * User: zhangcheng
 * Date: 2020-11-09
 * Time: 13:33
 */
public class 快排 {
    public static void QuickSort(int[] num, int left, int right){
        if (left >= right){
            return;
        }
        // 设置最左边元素为基准
        int key = num[left];
        // 数组中比key小的放在左边，比key大的放在右边，key值得下标i。
        int i = left;
        int j = right;
        while (i < j){
            // j向左移，直到遇到比key小的。
            while(num[j] >= key && i<j){
                j--;
            }
            // i向右移，直到遇到比key大的。
            while (num[i] >= key && i < j){
                i++;
            }
            if (i < j){
                int temp = num[i];
                num[i] = num[j];
                num[j] = temp;
            }
        }
        // 将基准左右的分别分开
        num[left] = num[i];
        num[i] = key;
        QuickSort(num,left,i-1);
        QuickSort(num,i+1,right);
    }
    private static void QKSourt(int[] a, int start, int end) {
        if (a.length < 0){
            return ;
        }
        if (start >= end){
            return ;
        }
        int left = start;
        int right = end;
        int temp = a[left];
        while (left < right){
            while (left < right && a[right] > temp){
                right -- ;
            }
            a[left] = a[right];
            while (left < right && a[left] < temp){
                left ++ ;
            }
            a[right] = a[left];
        }
        a[left] = temp;
        System.out.println(Arrays.toString(a));
        QKSourt(a, start, left -1);
        QKSourt(a,left+1,end);
    }

    public static void main(String[] args) {
        int[] num = new int[]{1,6,8,7,3,5,16,4,8,36,13,44};
        QKSourt(num,0,num.length-1);
        for (int i:num) {
            System.out.print(i + " ");
        }
    }
}
