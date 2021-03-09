package 字符串.time_8_28;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: cheneyzhang2018@gmail.com
 * @date: 2020/8/28,12:19
 * @version: 1.0
 */
public class YES_lc929独特的电子邮件地址 {
    public static int numUniqueEmails(String[] emails) {
        Set<String> ans = new HashSet<>();
        int count = 0;
        boolean flag = false;
        for (String s:emails){
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++){
                if (flag == true){
                    sb.append(s.charAt(i));
                    continue;
                }else if (s.charAt(i) == '.' && flag == false){
                    continue;
                }else if (s.charAt(i) == '+' && flag == false){
                    while (s.charAt(i) != '@'){
                        i++;
                    }
                    flag = true;
                }else if (s.charAt(i) == '@'){
                    flag = true;
                }
                sb.append(s.charAt(i));
            }
            flag = false;
            ans.add(sb.toString());
            System.out.println(sb);
        }
        return ans.size();
    }
    // 快速方法！ 通过@分为两部分，前一部分不需要处理，后一部分需要处理！
    public int numUniqueEmails2(String[] emails) {
        Set<String> seen = new HashSet();
        for (String email : emails) {
            int i = email.indexOf('@');
            String local = email.substring(0, i);
            String rest = email.substring(i);
            if (local.contains("+")) {
                local = local.substring(0, local.indexOf('+'));
            }

            local = local.replaceAll("\\.", "");
            seen.add(local + rest);
        }

        return seen.size();
    }

}
