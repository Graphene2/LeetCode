package traceback;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Description:
 * User: zhangcheng
 * Date: 2020-10-20
 * Time: 18:38
 */
public class lc93复制IP地址 {
    public List<String> restoreIpAddresses(String s) {
        int len = s.length();
        List<String> res = new ArrayList<>();
        if (len < 4 || len > 12){
            return res;
        }
        Deque<String> path = new ArrayDeque<>(4);
        int splitTime = 0;
        dfs(s,len,0,4,path,res);
        return res;
    }

    private void dfs(String s, int len, int begin, int residue, Deque<String> path, List<String> res) {
        if (begin == len) {
            if (residue == 0){
                res.add(String.join(".",path));
            }
            return;
        }

        for (int i = begin; i < begin + 3; i++) {
            if ( i >= len) {
                break;
            }
            if (residue * 3 < len - i) {
                continue;
            }
            if (judgeIfIpSegment(s, begin,  i)) {
                // 在判断是 ip 段的情况下，才去做截取
                String currentIpSegment = s.substring(begin,i + 1);
                path.addLast(currentIpSegment);
                dfs(s, len, i + 1, residue - 1, path, res);
                path.removeLast();
            }
        }

    }
    private boolean judgeIfIpSegment(String s, int left, int right) {
        int len = right - left + 1;
        // 长度大于1位时不能以0开头。
        if (len > 1 && s.charAt(left) == '0'){
            return false;
        }
        // 记录此段数据的数字值并返回
        int res = 0;
        for (int i = left; i <= right; i++) {
            res = res * 10 + s.charAt(i) - '0';
        }
        return res >= 0 && res <= 255;
    }



}
