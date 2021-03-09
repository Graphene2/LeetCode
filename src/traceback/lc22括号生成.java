package traceback;

import java.util.ArrayList;
import java.util.List;

/** 广度优先算法或者深度优先算法。
 * Description:
 * User: zhangcheng
 * Date: 2020-09-23
 * Time: 16:13-
 */
public class lc22括号生成 {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        if (n == 0) return ans;
        StringBuilder sb = new StringBuilder();
        DFS(sb,n,n,ans);
        return ans;
    }

    private void DFS(StringBuilder curStr, int left, int right, List<String> ans) {
        if (left == 0 && right == 0){
            ans.add(curStr.toString());
            return;
        }
        if (left > right){
            return;
        }
        if (left > 0){
            curStr.append("(");
            DFS(curStr,left - 1,right,ans);
            curStr.deleteCharAt(curStr.length() - 1);
        }
        if (right > 0){
            curStr.append(")");
            DFS(curStr,left,right - 1,ans);
            curStr.deleteCharAt(curStr.length() - 1);
        }

    }

    public List<String> generateParenthesis2(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) return res;
        DFS2("",n,n,res);
        return res;
    }

    private void DFS2(String s, int left, int right, List<String> res) {
        if (left == 0 && right == 0){
            res.add(s);
            return;
        }
        if (left > right){
            return;
        }
        if (left > 0){
            DFS2(s + "(",left - 1,right,res);
        }
        if (right > 0){
            DFS2(s + ")",left,right - 1,res);
        }
    }
}
