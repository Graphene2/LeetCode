package DEC;

import java.util.Arrays;

/**
 * @author: cheneyzhang2018@gmail.com
 * @date: 2020/12/5,11:01
 * @version: 1.0
 */
public class lc621任务调度 {
    public int leastInterval(char[] tasks, int n) {
        int len = tasks.length;
        int[] list = new int[26];
        for (char c: tasks){
            int idx = c - 'a';
            list[idx]++;
        }
        Arrays.sort(list);
        int maxTask = list[25];
        int count = 0;
        for (int i = 25; i >= 0; i--) {
            if (list[i] != maxTask){
                break;
            }
            count++;
        }
        return Math.max(len,count + (maxTask - 1) * (n + 1));
    }
}
