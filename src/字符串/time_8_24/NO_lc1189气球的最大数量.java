package 字符串.time_8_24;

/**lc1189气球的最大数量
 * @author: cheneyzhang2018@gmail.com
 * @date: 2020/8/24,22:55-23:05
 * @version: 1.0min*/
public class NO_lc1189气球的最大数量 {
    public int maxNumberOfBalloons(String text) {
        int [] arr = new int[26];
        for (char m : text.toCharArray()){
            arr[m - 'a']++;
        }
        int min = 10000;
        min = Math.min(min,arr['a' - 'a']);
        min = Math.min(min,arr['b' - 'a']);
        min = Math.min(min,arr['l' - 'a'] / 2);
        min = Math.min(min,arr['o' - 'a'] / 2);
        min = Math.min(min,arr['n' - 'a']);
        return min;
    }
}
