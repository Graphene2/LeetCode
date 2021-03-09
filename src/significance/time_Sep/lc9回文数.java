package significance.time_Sep;

/**
 * Description:
 * User: zhangcheng
 * Date: 2020-09-21
 * Time: 10:57
 */
public class lc9回文数 {
    // 最简单的方式，直接翻转后比较!
    public boolean isPalindrome(int x) {
        String reversedStr = (new StringBuilder(x + "")).reverse().toString();
        return (x + "").equals(reversedStr);
    }
    // 数学方法
    public boolean isPalindrome2(int x){
        if (x < 0) return false;
        int div = 1;

        while (x / div >= 10) div *= 10;
        while (x > 0){
            int left = x / div;
            int right = x % 10;
            if (left != right) return false;
            x = (x % div) / 10;
            div /= 100;
        }
        return true;
    }
    public boolean isPalindrome3(int x){
        // 先进行边界条件判断
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;
        int revertedNum = 0;
        while (x > revertedNum){
            revertedNum = revertedNum * 10 + x % 10;
            x /= 10;
        }
        return x == revertedNum || x == revertedNum / 10;
    }

}
