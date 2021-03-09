package 字符串.time_8_27;

import java.util.Arrays;

/**
 * @author: cheneyzhang2018@gmail.com
 * @date: 2020/8/27,17:52-18:54
 * @version: 1.0
 */
public class NO_lc657机器人能否返回原点 {
    public static boolean judgeCircle(String moves) {
        int[] pos = new int[2];
        for (char e:moves.toCharArray()){
            switch (e){
                case 'U': pos[0]++; break;
                case 'D': pos[0]--; break;
                case 'L': pos[1]--; break;
                case 'R': pos[1]++; break;
            }
        }
        if (Arrays.equals(pos,new int[]{0, 0})){
            return true;
        }else return false;
    }

    public static void main(String[] args) {
        String move = new String("UD");
        boolean m = judgeCircle(move);
        System.out.println(m);
    }
}
