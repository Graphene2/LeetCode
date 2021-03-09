package 排序问题;

/**
 * Description:归并排序，先分割再排序，分割后对比两个数组，从前往后比较较小值放在前面、
 * User: zhangcheng
 * Date: 2020-11-08
 * Time: 10:18
 */
public class 归并排序 {
    public void merge_sort(int[] arr) {
        int len = arr.length;
        int[] res = new int[len];
        int block, start;
        for (block = 1; block < len * 2; block *= 2) {
            for (start = 0; start < len; start += 2) {
                int low = start;

            }
        }

    }
}