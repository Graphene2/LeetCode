package 数组.time_8_12;

import java.util.HashMap;
import java.util.Map;

/**leetcode1346：检查整数及其两倍数是否存在   原理和leetcode1两数相加相同
 * 注意：没有考虑到hash冲突的情况。还有就是零的情况
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/8/12 16:03
 */
public class lc1346_checkIfExist {
    public static boolean checkIfExist(int[] arr){
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++){
            if (map.containsKey(arr[i]*2)){
                return true;
            }
            if (arr[i] % 2 == 0){
                if (map.containsKey(arr[i] / 2)){
                    return true;
                }
            }
            map.put(arr[i],i);
        }
        return  false;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,1,7,11};
        boolean flag = checkIfExist(arr);
        System.out.println(flag);
    }
}
