package 数组.time_8_17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**leetcode830: 较大分组位置 自己做的方法太麻烦了。双指针更好。
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/8/17 14:16
 */
public class lc830较大分组位置 {
    public static List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> ans = new ArrayList<>();
        char[] aa = S.toCharArray();
        int start = 0, count = 1;
        for (int i = 1; i < aa.length; i++){
            if (aa[i - 1] == aa[i]){
                count++;
            }
            if (aa[i - 1] != aa[i]){
                if (count >= 3 ){
                    List<Integer> list = new ArrayList<>(2);
                    list.add(start);
                    list.add(i - 1);
                    ans.add(list);
                }
                start = i;
                count = 1;
            }if(i == aa.length - 1){
                if(count >= 3){
                    List<Integer> list = new ArrayList<>(2);
                    list.add(start);
                    list.add(i);
                    ans.add(list);
                }
            }
        }return ans;
    }
    // 利用双指针的方法进行
    public List<List<Integer>> largeGroupPositions2(String S) {
        List<List<Integer>> ans = new ArrayList();
        int i = 0, N = S.length(); // i is the start of each group
        for (int j = 0; j < N; ++j) {
            if (j == N-1 || S.charAt(j) != S.charAt(j+1)) {
                // Here, [i, j] represents a group.
                if (j-i+1 >= 3)
                    ans.add(Arrays.asList(new Integer[]{i, j}));
                i = j + 1;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        String s = "ddd";
        List<List<Integer>> ans = new ArrayList<>();
        ans = largeGroupPositions(s);
        for (List<Integer> aa: ans){
            for (Integer bb:aa){
                System.out.print(bb+"\t");
            }
            System.out.print(" , ");
        }
    }
}
