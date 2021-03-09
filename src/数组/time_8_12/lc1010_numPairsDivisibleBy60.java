package 数组.time_8_12;

/**leetcode1010: 总持续时间可被60整除的歌曲。 方法：进行运算！
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/8/12 9:48
 */
public class lc1010_numPairsDivisibleBy60 {
    public static int numPairsDivisibleBy60(int[] time){
        int count = 0;
        int[] second = new int[60];
        // 进行余数统计。
        for (int item:time){
            second[item%60] += 1;
        }
        count += combine(second[0]);
        count += combine(second[30]);
        int i = 1, j = 59;
        while (i < j){
            count += second[i++]*second[j--];
        }
        return count;
    }
    static int combine(int num){
        if (num == 0 || num == 1) return 0;
        else return num * (num - 1) / 2;
    }

    public static void main(String[] args) {
        int[] time = new int[]{60,60,60};
        int m = numPairsDivisibleBy60(time);
        System.out.println(m);
    }
}
