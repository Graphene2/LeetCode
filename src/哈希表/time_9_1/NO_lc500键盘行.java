package 哈希表.time_9_1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/9/1 11:16
 */
class NO_lc500键盘行 {
    public String[] findWords(String[] words) {
        String[] oneLines = new String[]{
                "QWERTYUIOP","ASDFGHJKL","ZXCVBNM"
        };
        List<String> res = new ArrayList<>();
        int[] lines = new int[128];
        for (int i = 0; i < oneLines.length; i++){
            for (char c: oneLines[i].toCharArray()){
                lines[c] = i + 1;
            }
        }
        int count = 0;
        for (String word:words){
            int lineNum = 0;
            boolean flag = true;
            for (char c:word.toCharArray()){
                c = Character.toUpperCase(c);
                if (lineNum != 0 && lines[c] != lineNum){
                    flag = false;
                    break;
                }else{
                    lineNum = lines[c];
                }
            }
            if (flag) res.add(word);
        }
        return res.toArray(new String[res.size()]);
    }
}
