package DEC;

import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * User: zhangcheng
 * Date: 2020-12-08
 * Time: 8:41
 */
public class lc842将数组拆分斐波那契数列 {
    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> res = new ArrayList<>();
        backtrace(res,S,S.length(),0,0,0);
        return res;
    }

    private boolean backtrace(List<Integer> res, String s, int length, int index, int sum, int pre) {
        if (index == length){
            return res.size() >= 3;
        }
        long currLong = 0;
        for (int i = index; i < length; i++) {
            if (i > index && s.charAt(index) == '0'){
                break;
            }
            currLong = currLong * 10 + s.charAt(i) - '0';
            if (currLong > Integer.MAX_VALUE){
                break;
            }
            int curr = (int)currLong;
            if (res.size() >= 2){
                if (curr < sum){
                    continue;
                }else if (curr > sum){
                    break;
                }
            }
            res.add(curr);
            if (backtrace(res,s,length,i + 1,pre + curr,curr)){
                return true;
            }else {
                res.remove(res.size() - 1);
            }
        }
        return false;
    }
}
