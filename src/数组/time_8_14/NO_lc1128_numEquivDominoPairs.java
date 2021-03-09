package 数组.time_8_14;

/**leetcode1128: 等价多米诺骨牌的数量。 关键在于读题查找规则。能重复吗？题目读的不懂。
 * @author: cheneyzhang2018@gmail.com
 * @date: 2020/8/14,15:50-16:40
 * @version: 1.0
 */
public class NO_lc1128_numEquivDominoPairs {
    public static int numEquivDominoPairs(int[][] dominoes) {
        int[][] count = new int[10][10];
        int sum = 0, a = 0, b = 0;
        for (int[] item:dominoes){
            if (item[0] > item[1]){
                a = item[0];
                b = item[1];
            }else {
                a = item[1];
                b = item[0];
            }
            sum += count[a][b];
            count[a][b]++;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] arr =new int[][]{{1, 2}, {2, 1}, {3, 4}, {5, 6}};
        int m = numEquivDominoPairs(arr);
        System.out.println(m);
    }
}
