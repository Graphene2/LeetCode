package traceback;

import java.util.*;

/**
 * Description:
 * User: zhangcheng
 * Date: 2020-09-23
 * Time: 14:59-15:23
 */
public class lc17电话号码的字母组合 {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits.length() == 0) return ans;
        Map<Character,String> map = new HashMap<>(){{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        backtrack(ans,map,digits,0,new StringBuilder());
        return ans;
    }

    private void backtrack(List<String> ans, Map<Character, String> map,
                           String digits, int index, StringBuilder sb) {
        if (index == digits.length()) ans.add(sb.toString());
        else {
            char digit = digits.charAt(index);
            String letters = map.get(digit);
            int letterCount = letters.length();
            for (int i = 0; i < letterCount; i++){
                sb.append(letters.charAt(i));
                backtrack(ans,map,digits,index + 1,sb);
                sb.deleteCharAt(index);
            }
        }
    }
    //
    public List<String> letterCombinations2(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() == 0) return res;
        Map<Character, String> map = new HashMap<>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        StringBuilder path = new StringBuilder();
        backtrack2(res, map, digits, 0, path);
        return res;
    }


    private void backtrack2(List<String> res, Map<Character, String> map, String digits, int index, StringBuilder path) {
        if (index == digits.length()){
            res.add(new String(path.toString()));
            return;
        }
        char digit = digits.charAt(index);
        String letters = map.get(digit);
        int letterLength = letters.length();
        for (int i = 0; i < letterLength; i++) {
            path.append(letters.charAt(i));
            backtrack2(res,map,digits,index + 1,path);
            path.deleteCharAt(index);
        }
    }
}