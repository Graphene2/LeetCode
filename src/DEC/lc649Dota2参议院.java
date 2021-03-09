package DEC;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description:
 * User: zhangcheng
 * Date: 2020-12-11
 * Time: 8:52
 */
public class lc649Dota2参议院 {
    public String predictPartyVictory(String senate) {
        int n = senate.length();
        Queue<Integer> radiant = new LinkedList<>();
        Queue<Integer> dire = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'R'){
                radiant.offer(i);
            }else {
                dire.offer(i);
            }
        }
        while (!radiant.isEmpty() && !dire.isEmpty()){
            int radianIndex = radiant.poll(), direIndex = dire.poll();
            if (radianIndex < direIndex){
                radiant.offer(radianIndex + n);
            }else {
                dire.offer(direIndex + n);
            }
        }
        return !radiant.isEmpty() ? "Radiant" : "Dire";
    }
}
