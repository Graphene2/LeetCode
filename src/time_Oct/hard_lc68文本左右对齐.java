package time_Oct;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * User: zhangcheng
 * Date: 2020-10-28
 * Time: 19:51
 */
public class hard_lc68文本左右对齐 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> list = new ArrayList<>();
        int n = words.length, i = 0, j = 0, blank = 0, rest, wdCnt;
        while (i < n){
            rest = maxWidth;
            wdCnt = 0;
            blank = 0;
            while (j < n && rest >= words[j].length()){
                rest -= words[j++].length();
                wdCnt++;
                rest -= 1;
                blank++;
            }
            blank += rest;
            StringBuilder sb = new StringBuilder();
            // 特殊情况1 如果是最后一行，单词之间只占一个空格。
            if (j >= n){
                while (i < j){
                    sb.append(words[i++]).append(" ");
                }
                sb.deleteCharAt(sb.length() - 1);
                while (sb.length() < maxWidth){
                    sb.append(" ");
                }

            }else if (wdCnt == 1){
                //特殊情况2， 如果一行只有一个单词， 补齐右边的空格
                while (i < j){
                    sb.append(words[i++]).append(" ");
                }
                sb.deleteCharAt(sb.length() - 1);
                while (sb.length() < maxWidth){
                    sb.append(" ");
                }
            }else {
                int mod = blank % (wdCnt - 1);
                int bsn = blank / (wdCnt - 1);
                while (i < j){
                    sb.append(words[i++]);
                    int k = bsn + (mod > 0 ? 1 : 0);
                    mod--;
                    if (i < j)
                        for (int l = 0; l < k; l++)
                            sb.append(" ");
                }
            }
            i = j;
            list.add(sb.toString());
        }
        return list;
    }
}
