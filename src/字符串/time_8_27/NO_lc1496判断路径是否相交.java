package 字符串.time_8_27;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: cheneyzhang2018@gmail.com
 * @date: 2020/8/27,22:43
 * @version: 1.0
 */
public class NO_lc1496判断路径是否相交 {
    public static boolean isPathCrossing(String path) {
        int x = 0, y = 0;
        Set<String> set = new HashSet<>();
        set.add("0,0");
        for (char e: path.toCharArray()){
            switch (e){
                case 'N' : x++; break;
                case 'S' : x--; break;
                case 'E' : y--; break;
                case 'W' : y++; break;
            }
            if (set.contains(x + "," + y)) return true;
            set.add(x + "," + y);
        }
        return false;
    }

    public static void main(String[] args) {
        String s = new String("NES");
        boolean m = isPathCrossing(s);
        System.out.println(m);
    }
}
