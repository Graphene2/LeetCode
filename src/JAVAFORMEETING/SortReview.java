package JAVAFORMEETING;

import LinkedList.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description:
 * User: zhangcheng
 * Date: 2021-03-12
 * Time: 9:18
 */
public class SortReview {
    // 1. 冒泡排序，属于稳定排序，时间复杂度 O(n2) 最好情况出现在已排序好，最差情况出现在完全反序。
    // 其中的重点是设置交换标志，如果遍历一遍没有交换直接结束，此为最好情况时间为O(n)
    public int[] bubbleSort(int[]  array){
        if (array == null || array.length < 2){
            return array;
        }
        int len = array.length;
        for (int i = 0; i < len; i++) {
            boolean hasSwap = false;
            for (int j = 0; j < len - i - 1; j++) {
                if (array[j] > array[j + 1]){
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    hasSwap = true;
                }
            }
            if (!hasSwap){
                break;
            }
        }
        return array;
    }

    // 2. 选择排序，属于不稳定排序，每次选择后续元素中最小的与当前的进行交换。
    //
    // 交换的次数少。
    public int[] selectSort(int[] array){
        if (array == null || array.length < 2){
            return array;
        }
        int len = array.length;
        for (int i = 0; i < len; i++) {
            int minIndex = i;
            for (int j = i + 1; j < len; j++) {
                if (array[j] < array[minIndex]){
                    minIndex = j;
                }
            }
            // 将后续找到的最小值和 i 位置进行交换。
            if (minIndex != i){
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
        }
        return array;
    }

    // 3. 插入排序，属于稳定排序，存在最好和最坏情况。
    // 选择当前 i  为 index，并向前查找， 如果元素的值比当前 index 大，那么将该元素往后移动，
    // 碰到比当前 index 对应的值小，将最开始保存的值进行复制给 index + 1;
    public  int[] insertionSort(int[] array){
        if (array == null || array.length < 2){
            return array;
        }
        int len = array.length;
        for (int i = 0; i < len - 1; i++) {
            int index = i;
            int temp = array[index + 1];
            while (index >= 0 && temp < array[index]){
                array[index + 1] = array[index];
                index--;
            }
            array[index + 1] = temp;
        }
        return array;
    }

    // 4. 快速排序，不稳定，存在最好和最坏情况。 最好 nlog(n), 最坏情况 n2 ，最坏情况为每次找到的都是最大或者最小值，直接退化成一个冒泡排序，形成一个单斜树
    // 最好情况是每次都能够正好均分，递归深度为log2n + 1，仅需要递归log2n次。
    public void quickSort(int[] arr,int low,int high){
        if (arr == null || arr.length < 2){
            return;
        }
        if (low >= high){
            return;
        }
        int left = low;
        int right = high;
        // 保存基准值
        int pivot = arr[left];
        while (left < right){
            // 从后向前找比基准小的元素，其中碰到比基准值大的元素直接略过，碰到比pivot小的元素直接复制到 left 上。
            while (left < right && arr[right] >= pivot){
                right--;
            }
            arr[left] = arr[right];
            // 从前往后找比基准大的元素，碰到比 pivot 小的元素直接略过，比 pivot 大的元素复制到 right 上。
            while (left < right && arr[left] <= pivot){
                left++;
            }
            arr[right] = arr[left];
        }
        // 最后一步特别关键，一定要将 pivot 复制回最后停留的位置 left。
        arr[left] = pivot;
        quickSort(arr,low,left - 1);
        quickSort(arr,left + 1, high);
    }

    // 5. 希尔排序， 也是一种插入排序。也称为缩小增量排序。非稳定性排序
    // 将数组按照步长进行分组，然后将每组的元素利用插入排序进行排序，每次再将gap减半，当gap = 1时，直接插入排序完成排序。
    public  int[] heerSort(int[] arr){
        if (arr == null || arr.length < 2){
            return arr;
        }
        int len = arr.length;
        // step 为步长
        for (int step = len / 2; step > 0; step /= 2) {
            // 对每个步长的区间进行比较
            for (int i = step; i < len; i++) {
                int value = arr[i];
                int j;
                for ( j = i - step; j >= 0 && arr[j] > value; j = j - step) {
                    // j 为左区间的取值， j + step 为右区间对应的取值。
                    arr[j + step] = arr[j];
                }
                //此时step为一个负数，[j + step]为左区间上的初始交换值
                arr[j + step] = value;
            }
        }
        return arr;
    }

    // 6. 计数排序，需要一个额外数组存放数字出现频次，然后根据频次填充。
    // 稳定排序，时间复杂度O(n+k)，空间为O(k),k为max-min
    // 在最大值和最小值相差较大的情况下不适合使用。
    public  int[] countingSort(int[] arr){
        if (arr == null || arr.length < 2){
            return arr;
        }
        int len = arr.length;
        int min = arr[0];
        int max = arr[0];
        for (int i = 0; i < len; i++) {
            if (arr[i] < min){
                min = arr[i];
            }
            if (arr[i] > max){
                max = arr[i];
            }
        }
        int[] countArr = new int[max - min + 1];
        Arrays.fill(countArr,0);
        for (int i = 0; i < len; i++) {
            countArr[arr[i] - min]++;
        }
        int index = 0;
        for (int i = 0; i < countArr.length; i++) {
            while (countArr[i] > 0){
                arr[index++] = min + i;
                countArr[i]--;
            }
        }
        return arr;
    }

    // 7. 归并排序，分为各个子序列，先将子序列有序后慢慢合并
    // 时间O(nlogn),空间O(n)
    // 稳定排序。
    public int[] mergeSort(int[] arr){
        if (arr == null || arr.length < 2){
            return arr;
        }
        int len = arr.length;
        int mid = len / 2;
        int[] leftArr = Arrays.copyOfRange(arr,0,mid);
        int[] rightArr = Arrays.copyOfRange(arr,mid,len);
        return merge(mergeSort(leftArr),mergeSort(rightArr));
    }

    private int[] merge(int[] lArr, int[] rArr) {
        int[] res = new int[lArr.length + rArr.length];
        // 合并两个有序数组
        int index = 0, left = 0, right = 0;
        while (index < res.length && left < lArr.length && right < rArr.length){
            if (lArr[left] < rArr[right]){
                res[index++] = lArr[left++];
            }else {
                res[index++] = rArr[right++];
            }
        }
        if (left == lArr.length){
            while (index < res.length){
                res[index++] = rArr[right++];
            }
        }else if (right == rArr.length){
            while (index < res.length){
                res[index++] = lArr[left++];
            }
        }
        return res;
    }

    // 8. 基数排序，分别对每一个(个、十、百、千、万)进行排序
    // 每一轮排序的数组都放在arr中，然后进行再排序，这样从最开始保证了个位顺序、百位顺序。
    // 稳定排序，时间O(n*k) 空间O(n+k)
    public int[] radixSort(int[] arr){
        if (arr == null || arr.length < 2){
            return arr;
        }
        int max = arr[0];
        int len = arr.length;
        // 取最大值。
        for (int i = 0; i < len; i++) {
            if (arr[i] > max){
                max = arr[i];
            }
        }
        int maxDigit = 0;
        while (max != 0) {
            max /= 10;
            maxDigit++;
        }
        List<List<Integer>> bucket = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            bucket.add(new ArrayList<Integer>());
        }
        int mod = 10;
        int div = 1;
        for (int i = 0; i < maxDigit; i++,mod *= 10, div *= 10) {
            for (int j = 0; j < len; j++) {
                // 从个位数开始判断。
                int bucketIndex = (arr[j] % mod) / div;
                bucket.get(bucketIndex).add(arr[j]);
            }
            int index = 0;
            for (int j = 0; j < bucket.size(); j++) {
                for (int k = 0; k < bucket.get(j).size(); k++) {
                    arr[index++] = bucket.get(j).get(k);
                }
                bucket.get(j).clear();
            }
        }
        return arr;
    }

    // 9. 桶排序
    public  int[] bucketSort(int[] array, int bucketSize) {
        if (array == null || array.length < 2){
             return array;
        }
        int len = array.length;
        // 寻找最大值和最小值。
        int max = array[0],min = array[0];
        for (int i = 0; i < len; i++) {
            if (array[i] > max){
                max = array[i];
            }
            if (array[i] < min){
                min = array[i];
            }
        }
        int bucketCount = (max - min) / bucketSize + 1;
        List<List<Integer>> bucket =  new ArrayList<>(bucketCount);
        for (int i = 0; i < bucketCount; i++) {
            bucket.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < len; i++) {
            bucket.get((array[i] - min) / bucketSize).add(array[i]);
        }
        int index = 0;
        for (int i = 0; i < bucketCount; i++) {
            if (bucketSize == 1){
                for (int j = 0; j < bucket.get(i).size(); j++) {
                    array[index++] = bucket.get(i).get(j);
                }
            }else{
                // 对每个桶进行排序。
//                insertionSort();
                for (int j = 0; j < bucket.get(i).size(); j++) {
                    array[index++] = bucket.get(i).get(j);
                }

            }
        }
        return array;
    }

    // 10. 堆排序，堆是一个类似于完全二叉树的结构，子节点的键总是小于或者大于它的节点。
    public  int[] HeapSort(int[] array) {
        return array;
    }



}
