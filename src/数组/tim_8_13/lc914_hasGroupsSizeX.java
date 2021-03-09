package 数组.tim_8_13;

/**
 * leetcode914: 卡牌分组  即最大公约数算法：
 *
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/8/13 16:53-20:05
 */
public class lc914_hasGroupsSizeX {
    public static boolean hasGroupsSizeX(int[] deck) {
        int[] count = new int[10000];
        for (int c: deck)
            count[c]++;
        int g = -1;
        for (int i=0;i<10000;i++){
            if (count[i]>0){
                if (g == -1){
                    g = count[i];
                }else {
                    g = gcd(g,count[i]);
                }
            }
        }
        return g >= 2;
    }
    // 最大公约数算法：当y比x小时会调换x与y位置，然后求余数，循环到x是y的约数为止，即x==0；
    private static int gcd(int x, int y) {
        if (x==0){
            return y;
        }else {
            return gcd(y%x,x);
        }
    }

    public static void main(String[] args) {
        int[] deck = new int[]{1, 1, 2, 2, 2, 2};
        boolean m = hasGroupsSizeX(deck);
        System.out.println(m);

    }
}
