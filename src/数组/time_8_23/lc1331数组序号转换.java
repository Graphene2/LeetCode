package 数组.time_8_23;



import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**lc1331数组序号转换
 * @author: cheneyzhang2018@gmail.com
 * @date: 2020/8/23,10:19
 * @version: 1.0
 */
public class lc1331数组序号转换 {
    public int[] arrayRankTransform(int[] arr){
        Map<Integer, Integer> map = new HashMap<>();
        int[] a = new int[arr.length];
        a = arr.clone();
        Arrays.sort(a);
        int index = 1;
        for (int i = 0;  i < a.length ; i++){
            if (i == 0){
                map.put(a[i], index);
                index++;
            }else if (i != 0 && a[i] != a[i - 1]){
                map.put(a[i], index);
                index++;
            }
        }
        for (int i = 0; i < a.length; i++){
            arr[i] = map.get(arr[i]);
        }
        return arr;
    }
}
