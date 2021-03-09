package significance.time_Sep.time_9_11;

import java.util.Stack;

/**
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/9/11 14:17
 */
public class lc844比较退格字符串 {
    // 双指针 碰到‘#’直接退格，碰到字符就比较！
    public boolean backspaceCompare(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1;
        int skipT = 0, skipS = 0;

        while (i >= 0 || j >= 0){
                while (i >= 0){
                    if (S.charAt(i) == '#'){
                        skipS++;i--;
                    }else if (skipS > 0){skipS--;i--;}
                    else break;
                }
                while (j >= 0){
                    if (T.charAt(j) == '#'){
                        skipT++;j--;
                    }else if (skipT > 0){skipT--;j--;}
                    else break;
                }
                if (i >= 0 && j >= 0 && S.charAt(i) != T.charAt(j)){
                    return false;
                }
                if ((i >= 0) != (j >= 0)){
                    return false;
                }
                i--;j--;
        }
        return true;
    }

    // 常见想法，单调栈！
    public boolean backspaceCompare2(String S, String T) {
        return build(S).equals(build(T));
    }

    private String build(String s) {
        Stack<Character> ans = new Stack<>();
        for (char c: s.toCharArray()){
            if (c != '#') ans.push(c);
            else if (!ans.isEmpty()) ans.pop();
        }
        return String.valueOf(ans);
    }

}
