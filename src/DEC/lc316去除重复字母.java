package DEC;

/**
 * Description:
 * User: zhangcheng
 * Date: 2020-12-20
 * Time: 10:09
 */
public class lc316去除重复字母 {
    public String removeDuplicateLetters(String s) {
        // 记录后续字母的剩余个数
        int[] count = new int[26];
        // 记录栈中是否出现该字母
        boolean[] used = new boolean[26];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            count[ch - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            // 如果栈中未保存该字母，尝试比较
            if (!used[ch - 'a']){
                while (sb.length() > 0 && sb.charAt(sb.length() - 1) > ch){
                    // 如果栈顶元素为串中最后一个，保留
                    if (count[sb.charAt(sb.length() - 1) - 'a'] > 0){
                        used[sb.charAt(sb.length() - 1) - 'a'] = false;
                        sb.deleteCharAt(sb.length() - 1);
                    }else {
                        break;
                    }
                }
                // 保存该字母并将访问标志置位。
                sb.append(ch);
                used[ch - 'a'] = true;
            }// 访问过元素，将元素个数减少1
            count[ch - 'a']--;
        }
        return sb.toString();
    }
}
