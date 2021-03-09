package significance.time_Sep.time_9_11;

/** 关键因子为5，怎么判断阶乘中5的数量才是最关键的！
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/9/11 15:40-15:43
 */
public class lc172阶乘后的零 {
    public int trailingZeroes(int n){
        int zeroCount = 0;
        long currentMultiple = 5;
        while (n >= currentMultiple){
            zeroCount += (n / currentMultiple);
            currentMultiple *= 5;
        }
        return zeroCount;
    }
}
