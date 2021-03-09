package 字符串.time_8_27;

/**
 * @author: cheneyzhang2018@gmail.com
 * @date: 2020/8/27,19:57-20:11
 * @version: 1.0
 */
public class NO_lc1108IP地址无效化 {
    public String defangIPaddr(String address) {
        String[] str = address.split(".");
        String ans = new String( str[0] + "[.]" + str[1] + "[.]" + str[2] + "[.]" + str[3]);
        return ans;
    }

}
