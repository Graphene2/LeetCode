package 数组.time_8_20;

import java.util.Arrays;

/**lc1170比较字符串最小字母出现频次
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/8/20 16:04
 */
public class YES_lc1170比较字符串最小字母出现频次 {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int len1 = queries.length, len2 = words.length;
        int[] arr1 = new int[len1];
        int[] arr2 = new int[len2];

        for (int i = 0; i < len2; i++){
            arr2[i] = minFrequency(words[i]);
        }

        Arrays.sort(arr2);

        for (int i = 0; i < len1; i++){
            arr1[i] = minFrequency(queries[i]);
            int m = binarySearch(arr2,arr1[i]);
            arr1[i] = m;
        }return arr1;
    }

    private int binarySearch(int[] arr,int i) {
        int left = 0, right = arr.length - 1;

        while (left < right){
            int mid = (left + right) / 2;
            if (arr[mid] > i){
                right = mid;
            }else left = mid + 1;
        }
        if (arr[left] <= i) return 0;
        else return arr.length - left;
    }

    private int minFrequency(String num) {
        int[] arr = new int[26];
        int ans = 0;
        for (char a:num.toCharArray()){
            arr[a - 'a']++;
        }
        for (int i = 0; i < 26; i++){
            if (arr[i] > 0){
                ans = arr[i];
                break;
            }
        }return ans;
    }
}
