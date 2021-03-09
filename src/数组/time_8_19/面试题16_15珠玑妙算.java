package 数组.time_8_19;
import java.util.HashMap;
import java.util.Map;
/**面试题16_15珠玑妙算
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/8/19 15:23
 */
public class 面试题16_15珠玑妙算 {
    public int[] masterMind(String solution, String guess) {
        int real = 0, fake = 0;
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < 4; i++){
            if (solution.charAt(i) == guess.charAt(i)){
                real++;
            }
        }
        for (char a: solution.toCharArray()){
            map.put(a, map.getOrDefault(a,0) + 1);
        }
        for (char a :guess.toCharArray()){
            if (map.containsKey(a) && map.get(a) > 0){
                fake++;
                map.put(a, map.get(a) - 1);
            }
        }
        return new int[]{real,fake - real};
    }
}
