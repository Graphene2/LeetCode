package JAVAFORMEETING;

/**
 * Description:
 * User: zhangcheng
 * Date: 2021-04-20
 * Time: 9:21
 */
public class lc28实现strStr {
    // KMP算法详解
    public int  strStr(String haystack, String needle) {
        // next数组表示最长前缀和最长后缀相同的长度。 前缀不包括最后一个字符，后缀不包含第一个字符。
        if (needle.isEmpty()) return 0;
        char[] ss = haystack.toCharArray();
        char[] pp = needle.toCharArray();
        int n = ss.length, m = pp.length;
        int[] next = getNext(pp);
        // 下面是匹配过程
        for (int i = 0, k = -1; i < n; i++) {
            while (k > -1 && ss[i] != pp[k + 1]){
                k = next[k];    // 不匹配，向前回溯
            }
            if (ss[i] == pp[k + 1]){
                k++;            // 匹配，往后继续。
            }
            if (k == m - 1) return i - m + 1;
        }
        return -1;
    }

    private int[] getNext(char[] pp){
        int n = pp.length;
        int[] next = new int[n];
        // -1表示不存在相同的最大前缀和最大后缀
        next[0] = -1;
        int k = -1;
        for (int i = 1; i <= n - 1; i++) {
            while (k > -1 && pp[k + 1] != pp[i]){ // 如果下一个不相同，那么k就会变为next[k],next[k] 是小于 k 的
                k = next[k];    // 往前回溯
            }
            // 如果回溯后相同，k++
            if (pp[k + 1] == pp[i]){
                k++;
            }
            next[i] = k; // 最后得到相同的最大前缀和最大后缀长度。
        }
        return next;
    }



}
