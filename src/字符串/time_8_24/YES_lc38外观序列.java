package 字符串.time_8_24;

/**lc38外观序列
 * @author: cheneyzhang2018@gmail.com
 * @date: 2020/8/24,19:04-19:38
 * @version: 1.0
 */
public class YES_lc38外观序列 {
    public String countAndSay(int n) {
        // 递归终止条件
        if (n == 1) return "1";

        StringBuilder res = new StringBuilder();
        // 获取上一次的字符串
        String ans = countAndSay(n - 1);
        int length = ans.length();
        // 开始指针为0
        int start = 0;
        for (int i = 1; i < length + 1; i++){
            // 字符串的最后一位拼接
            if (i == length){
                res.append(i - start).append(ans.charAt(start));
                // 查找连续相同的数字，并记录次数以及值
            }else if(ans.charAt(i) != ans.charAt(start)){
                res.append(i - start).append(ans.charAt(start));
                start = i;
            }
        }
        return res.toString();
    }
}
