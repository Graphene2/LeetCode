package DEC;

/**
 * Description:
 * User: zhangcheng
 * Date: 2020-12-24
 * Time: 9:19
 */
public class lc105分配糖果Hard {
    public int candy(int[] ratings) {
        int len = ratings.length;
        int[] left = new int[len];
        for (int i = 0; i < len; i++) {
            if (i > 0 && ratings[i - 1] < ratings[i]){
                left[i] = left[i - 1] + 1;
            }else {
                left[i] = 1;
            }
        }
        int res = 0;
        int right = 0;
        for (int i = len - 1; i >= 0 ; i--) {
            if (i < len - 1 && ratings[i ] > ratings[i + 1]){
                right++;
            }else {
                right = 1;
            }
            res += Math.max(left[i],right);
        }
        return res;
    }
    // 更简单的方法，可以画图分析
    public int candy2(int[] ratings) {
        int len = ratings.length;
        int res = 1,pre = 1, desNum = 0;
        for (int i = 1; i < len; i++) {
            if (ratings[i] >= ratings[i - 1]){
                if (desNum > 0){
                    res += ((1 + desNum) * desNum) / 2;
                    if (desNum >= pre){
                        res += (desNum - pre + 1);
                    }
                    pre = 1;
                    desNum = 0;
                }
                pre = ratings[i - 1] == ratings[i] ? 1 : pre + 1;
                res += pre;
            }else {
                desNum++;
            }
        }
        if (desNum > 0){
            res += ((1 + desNum) * desNum) / 2;
            if (desNum >= pre){
                res += (desNum - pre + 1);
            }
        }

        return res;
    }
}
