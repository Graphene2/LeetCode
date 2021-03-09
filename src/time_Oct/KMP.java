package time_Oct;

/**
 * Description:
 * User: zhangcheng
 * Date: 2020-10-06
 * Time: 20:43-21:19
 */
public class KMP {

    int[] getNext(String str){
        int[] next = new int[str.length()];
        next[0] = -1;
        int i = 0,cur = -1;
        while (i < str.length()){
            if (cur == -1 || str.charAt(i) == str.charAt(cur)){
                ++i;
                ++cur;
                next[i] = cur;
            }else {
                cur = next[cur];
            }
        }
        return next;
    }

    int KMP(String main,String substr){
        int [] next = getNext(substr);
        int i = 0, j = 0;
        while (i < main.length() && j < substr.length()){
            if (j== -1 || main.charAt(i) == substr.charAt(j)){
                ++i;++j;
            }else {
                j = next[j];
            }
        }
        if (j == substr.length()){
            return i - j;
        }else return -1;
    }
}
