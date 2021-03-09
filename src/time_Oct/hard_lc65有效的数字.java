package time_Oct;

/**
 * Description:
 * User: zhangcheng
 * Date: 2020-10-28
 * Time: 14:59-15:26
 */
public class hard_lc65有效的数字 {
    // 有限状态机这个有点蒙蔽
    public int make(char c){
        switch (c){
            case ' ': return 0;
            case '+':;
            case '-': return 1;
            case '.': return 3;
            case 'e': return 4;
            default:
                if (c >= 48 && c <= 57){
                    return 2;
                }
        }
        return -1;
    }

    public boolean isNumber(String s){
        int state = 0;
        int finals = 0b101101000;
        int[][] transfer = new int[][]{
                { 0, 1, 6, 2,-1},
                {-1,-1, 6, 2,-1},
                {-1,-1, 3,-1,-1},
                { 8,-1, 3,-1, 4},
                {-1, 7, 5,-1,-1},
                { 8,-1, 5,-1,-1},
                { 8,-1, 6, 3, 4},
                {-1,-1, 5,-1,-1},
                { 8,-1,-1,-1,-1}};
        char[] ss = s.toCharArray();
        for (int i = 0; i < ss.length; i++) {
            int id = make(ss[i]);
            if (id < 0) return false;
            state = transfer[state][id];
            if (state < 0) return false;
        }
        return (finals & (1 << state)) > 0;
    }
    // 直接if else 判断！
    public boolean isNumber2(String s){
        if (s == null || s.length() == 0) return false;
        boolean numSeen = false;
        boolean eSeen = false;
        boolean dotSeen = false;
        char[] ss = s.trim().toCharArray();
        for (int i = 0; i < ss.length; i++) {
            if (ss[i] >= '0' && ss[i] <= '9'){
                numSeen = true;
            }else if (ss[i] == '.'){
                // . 之前出现过。 或者 e 直接false
                if (dotSeen || eSeen){
                    return false;
                }
                dotSeen = true;
            }else if (ss[i] == 'e' || ss[i] == 'E'){
                // e 前面没有数字 或者 e前面出现过直接false, 同时将numSeen 置 false;
                if (eSeen || !numSeen){
                    return false;
                }
                eSeen = true;
                numSeen = false;
            }else if (ss[i] == '+' || ss[i] == '-'){
                // +-只能出现在第一个或者e后面
                if (i != 0 && ss[i - 1] != 'e' && ss[i - 1] != 'E'){
                    return false;
                }
            }else {
                return false;
            }
        }
        return numSeen;
    }
}
