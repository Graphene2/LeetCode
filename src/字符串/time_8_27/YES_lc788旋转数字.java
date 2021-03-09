package 字符串.time_8_27;

import javax.imageio.stream.ImageInputStream;

/**
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/8/27 8:41-9:06
 */
public class YES_lc788旋转数字 {
    // 采用官方的方法，使用递归分治。
    public int rotatedDigits(int N) {
        int count = 0;
        for (int i = 0; i <= N; i++){
            if (good(i,false)) {
                count++;
            }
        }return count;
    }
    public boolean good(int n, boolean flag){
        if (n == 0) return flag;

        int d = n % 10;
        if (d == 3 || d == 4 || d == 7) return false;
        if (d == 0 || d == 1 || d == 8) return good(n / 10, flag);
        return good(n / 10, true);
    }


    // 采用动态规划
    public int rotatedDigits2(int N){
        return 1;
    }
}
