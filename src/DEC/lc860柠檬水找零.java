package DEC;

/**
 * Description:
 * User: zhangcheng
 * Date: 2020-12-10
 * Time: 8:40
 */
public class lc860柠檬水找零 {
    public boolean lemonadeChange(int[] bills) {
        int tenCoin = 0, fiveCoin = 0;
        int len = bills.length;
        if (len == 0){
            return true;
        }
        for (int i = 0; i < len; i++) {
            if (i == 0 && bills[i] != 5){
                return false;
            }
            if (bills[i] == 5){
                fiveCoin++;
            }else if (bills[i] == 10){
                tenCoin++;
                fiveCoin--;
            }else if (bills[i] == 20){
                if (tenCoin > 0){
                    tenCoin--;
                    fiveCoin--;
                }else {
                    fiveCoin -= 3;
                }
            }
            if (tenCoin < 0 || fiveCoin < 0){
                return false;
            }
        }
        return true;
    }
}
