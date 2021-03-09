package 数组.time_8_19;

import java.util.HashSet;

/**leetcode888:公平的糖果交换
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/8/19 10:32
 */
public class NO_lc888公平的糖果交换 {
    public int[] fairCandySwap(int[] A, int[] B) {
        int sum1 = 0, sum2 = 0;
        for (int temp:A){
            sum1 += temp;
        }
        for (int temp:B){
            sum2 += temp;
        }
        int avr = (sum1 + sum2) / 2;
        for (int i = 0; i < A.length; i++){
            for (int j = 0; j < B.length; j++){
                if (sum1 - A[i] + B[j] == avr || sum1 + A[i] - B[j] == avr){
                    return new int[]{A[i],B[j]};
                }
            }
        }
        throw new RuntimeException();
    }
    // 根据公式解题公式：totalAlice - xAlice + yBob = totalBob - yBob + xAlice ==> yBob = xAlice + (totalBob - totalAlice) / 2 ;
    public static int[] fairCandySwap2(int[] A, int[] B) {
        int sum = 0;
        HashSet<Integer> setBob = new HashSet<>();
        for(int yBob : B){
            sum += yBob;
            setBob.add(yBob);
        }
        for(int xAlice : A){
            sum -= xAlice;
        }
        for(int xAlice : A){
            // 2.
            if(setBob.contains(xAlice + sum / 2)){
                return new int[]{xAlice, xAlice + sum / 2};
            }
        }
        return new int[]{};
    }
}
