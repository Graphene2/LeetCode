package 数组.time_8_11;

import java.util.ArrayList;
import java.util.List;

/**leetcode118: 杨辉三角打印输出
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/8/11 16:22
 */
public class lc118_numRows {
    public static List<List<Integer>> generate(int numRows){
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        for (int i=0; i < numRows; i++){
            List<Integer> sub = new ArrayList<Integer>();
            for (int j=0; j <= i; j++){
                if (j == 0 || j == i){
                    sub.add(1);
                }else {
                    sub.add(triangle.get(i-1).get(j-1)+triangle.get(i-1).get(j));
                }
            }
            triangle.add(sub);
        }
        return triangle;
    }

    public static void main(String[] args) {
        generate(2);
    }
}
