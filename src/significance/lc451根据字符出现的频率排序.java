package significance;

import java.util.*;

/**
 * Description:
 * User: zhangcheng
 * Date: 2020-10-19
 * Time: 20:01
 */
public class lc451根据字符出现的频率排序 {
    public String frequencySort(String s) {
        char[] ch = s.toCharArray();
        Map<Character,Integer> map = new HashMap<>();
        int maxTime = - 1;
        for (char c : ch){
            map.put(c,map.getOrDefault(c,0) + 1);
            maxTime = Math.max(maxTime,map.get(c));
        }
        List<Character>[] buckets = new ArrayList[maxTime + 1];
        for (char c:ch){
            int fre = map.get(c);
            if (buckets[fre] == null){
                buckets[fre] = new ArrayList();
            }
            buckets[fre].add(c);
        }
        int p = 0;
        for (int i = maxTime; i > 0; i--){
            if (buckets[i] != null){
                for (char c: buckets[i]){
                    for (int j = 0; j < i; j++) {
                        ch[p++] = c;
                    }
                }
            }
        }
        return ch.toString();
    }
    private int[] freq;
    private static final Random RANDOM = new Random();
    public String frequencySort2(String s){
        char[] charArray = s.toCharArray();
        freq = new int[128];
        for (char c : charArray){
            freq[c]++;
        }
        int len = charArray.length;
        quickSort(charArray,0,len - 1);
        return charArray.toString();
    }

    private void quickSort(char[] charArray, int left, int right) {
        if (left >= right){
            return;
        }
        int randomIndex = left + RANDOM.nextInt(right - left + 1);
        swap(charArray,randomIndex,left);
        int pivot = charArray[left];                 // pivot 代表字符， freq表示该字符对应的频次。
        int lt = left;                               // freq数组中只进行存储频次，比较之后对charArray数组进行交换！
        int gt = right + 1;                           // 这里将lt 和 rt 都设置到区间外，在后面进行交换前处理。
        int i = left + 1;
        while (i < gt){
            if (freq[charArray[i]] > freq[pivot]){
                lt++;
                swap(charArray,lt,i);
                i++;
            }else if (charArray[i] == pivot) {
                i++;
            } else {
                gt--;
                swap(charArray, i, gt);
            }
        }
        swap(charArray, left, lt);
        // 注意，这里需要排序，故而找到等于pivot频次的位置后，剩下的就是处理小于和大于pivot位置对应频次的字符了，现在分成两部分进行排序，直到不可再分。

        quickSort(charArray,left,lt - 1);
        quickSort(charArray,gt, right);
    }

    private void swap(char[] charArray, int i, int j) {
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
    }

}
