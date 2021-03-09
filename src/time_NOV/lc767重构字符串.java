package time_NOV;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Description:
 * User: zhangcheng
 * Date: 2020-11-30
 * Time: 8:41
 */
public class lc767重构字符串 {
    public String reorganizeString(String S) {
        if  (S.length() < 2){
            return S;
        }
        int[] count = new int[26];
        int maxCount = 0;
        int len = S.length();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            count[c - 'a']++;
            maxCount = Math.max(maxCount,count[c - 'a']);
        }
        if (maxCount > (len + 1) / 2){
            return "";
        }
        PriorityQueue<Character> queue = new PriorityQueue<>(new Comparator<Character>() {
            @Override
            public int compare(Character letter1, Character letter2) {
                return count[letter2 - 'a'] - count[letter1 - 'a'];
            }
        });

        for (char c = 'a'; c <= 'z'; c++){
            if (count[c - 'a'] > 0){
                queue.offer(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (queue.size() > 1){
            char letter1 = queue.poll();
            char letter2 = queue.poll();
            sb.append(letter1);
            sb.append(letter2);
            int index1 = letter1 - 'a',index2 = letter2 - 'a';
            count[index1]--;
            count[index2]--;
            if (count[index1] > 0){
                queue.offer(letter1);
            }
            if (count[index2] > 0){
                queue.offer(letter2);
            }
        }
        if (queue.size() > 0){
            sb.append(queue.poll());
        }
        return sb.toString();
    }
}
