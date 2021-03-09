package 数组.tim_8_13;

/**leetcode1122: 数组的相对排序 该题涉及到桶排序问题，相对比较难，需要详细了解分配排序和桶排序相关知识。
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/8/13 10:47
 */
public class lc1122_relativeSortArray {
    public static int[] relativeSortArray(int[] arr1, int[] arr2){
        int[] bucket = new int[1001];
        int[] ref = new int[arr1.length];
        // 分配排序——先将arr1中数据分配到桶中
        for (int i=0; i < arr1.length ; i++){
            bucket[arr1[i]]++;
        }
        // cnt为ref数组的指针，存放最终结果。
        // 将arr2中对应元素从数组中逐个取出到ref
        int cnt = 0;
        for (int i = 0 ; i < arr2.length ; i++){
            while (bucket[arr2[i]] > 0){
                ref[cnt++] = arr2[i];
                bucket[arr2[i]]--;
            }
        }
        for (int i = 0; i < 1001; i++){
            while (bucket[i] > 0){
                ref[cnt++] = i;
                bucket[i]--;
            }
        }
        return ref;
    }
}
