package 字符串.time_8_28;

/**
 * @author: cheneyzhang2018@gmail.com
 * @date: 2020/8/28,13:06
 * @version: 1.0
 */
public class lc345反转字符串中的元音字母 {
    public String reverseVowels(String s) {
        int i = 0, j = s.length() - 1;
        char[] ans = s.toCharArray();
        while (i < j){
            while (!isVowel(ans[i]) && i < ans.length - 1) i++;
            while (!isVowel(ans[j]) && j > 0) j--;
            if (i >= j) break;
            char tmp = ans[i];
            ans[i++] = ans[j];
            ans[j--] = tmp;
        }
        String result = new String(ans);
        return result;
    }
    boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'
                ||ch=='A'|| ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';
    }

}
