package significance.time_Sep.time_9_11;


import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/9/11 15:45
 */
public class lc1009十进制整数的反码 {
    // 常规芍算法
    public int bitwiseComplement(int N) {
    Queue<Integer> binary = D2B(N);
        int res = 0, pow = 0;
        while (!binary.isEmpty()){
            int i = binary.poll() == 1? 0 : 1;
            int m = (int) (i * Math.pow(2,pow));
            pow++;
            res += m;
        }
        return res;
    }

    private Queue<Integer> D2B(int n) {
        Queue<Integer> sb = new LinkedList<>(); {
        };
        while (n >= 2){
            sb.add(n % 2);
            n = n / 2;
        }
        sb.add(n);
        return sb;
    }
    // 经典位运算方法！！！！ 原码异或allOne可以得到反码！，不过我们需要进行十进制到二进制的长度的计算！
    public int bitwiseComplement2(int N) {
        if(N == 0){
            return 1;
        }
        int len = N;
        int countBit = 0;
        while(len > 0){
            countBit++;
            len = len >> 1;
        }

        int allOne = (int)Math.pow(2, countBit) - 1;
        return allOne ^ N;
    }

}
