package 剑指offer;

/**
 * Description:
 * User: zhangcheng
 * Date: 2021-01-21
 * Time: 20:41
 */
public class offer17打印从1到最大的n位数 {
    StringBuilder res;
    int count = 0,nine = 0, n, start;
    char[] num, loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    public String printNumbers(int n){
        this.n = n;
        res = new StringBuilder();
        num = new char[n];
        start = n - 1;
        dfs(0);
        res.deleteCharAt(res.length() - 1);
        return res.toString();
    }

    private void dfs(int x) {
        if (x == n){
            String s = String.valueOf(num).substring(start);
            if (!s.equals('0')) res.append(s + ',');
            if (n - start == nine) start--;
            return;
        }
        for (char c : loop) {
            if (c == '9'){
                nine++;
            }
            num[x] = c;
            dfs(x + 1);
        }
        nine--;
    }
}
