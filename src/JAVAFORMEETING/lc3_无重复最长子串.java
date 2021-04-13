package JAVAFORMEETING;

import java.util.*;

/**
 * Description:
 * User: zhangcheng
 * Date: 2021-04-06
 * Time: 10:00
 */
public class lc3_无重复最长子串 {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        Deque<Character> deque = new LinkedList<>();
        char[] chars = s.toCharArray();
        int tempLen = 0, maxLen = 0;
        for(int i = 0; i < chars.length; i++){
            if(!set.contains(chars[i])){
                set.add(chars[i]);
                deque.addLast(chars[i]);
                tempLen++;
            }else {
                // 如果存在重复，那么将重复之前的元素删除掉，重新开始计数。
                while (!deque.isEmpty() && deque.peekFirst() != chars[i]){
                    char cc = deque.pollFirst();
                    set.remove(cc);
                }
                if (!deque.isEmpty()){
                    deque.pollFirst();
                }
                deque.addLast(chars[i]);
                set.add(chars[i]);
                tempLen = deque.size();
            }
            if (tempLen > maxLen){
                maxLen = tempLen;
            }
        }
        return maxLen;
    }
    // 直接用滑动窗口
    public int lengthOfLongestSubstring2(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLen = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))){
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i),i);
            maxLen = Math.max(maxLen, i - left + 1);
        }
        return maxLen;

    }
}
