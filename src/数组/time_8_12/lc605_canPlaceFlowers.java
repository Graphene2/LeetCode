package 数组.time_8_12;

/**leetcode605: 种花问题：主要计算连续的零的个数，开头和结尾都填上一个零方便计算。仔细考虑边界条件！
 * 根据0的个数计算该区间段能够种植的花的数目：n = (count - 1) / 2;
 * 官方方法更多了技巧性，该位置左右都为0，或者在头部和尾部就是头右尾左为0即可。注意，判断可种花后该位置置为1；
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/8/12 16:37
 */
public class lc605_canPlaceFlowers {
    public static boolean canPlaceFlowers(int[] flowered, int n){
        int sum = 0;
        int zeroCount = 0;
        for (int i=0;i < flowered.length ;i++){
            if (i == 0) zeroCount++;
            if (i == flowered.length - 1){
                if (flowered[i] == 0) zeroCount++;
            }
            if (flowered[i] == 0) zeroCount++;
            if (flowered[i] == 1 || i == flowered.length - 1){
                if (zeroCount > 0){
                    sum += (zeroCount - 1) / 2;
                }
                zeroCount = 0;
            }
        }
        return sum >= n? true : false;
    }
    // 官方方法，清晰明了。
    public boolean canPlaceFlowers2(int[] flowerbed, int n) {
        int i = 0, count = 0;
        while (i < flowerbed.length) {
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                flowerbed[i] = 1;
                count++;
            }
            i++;
        }
        return count >= n;
    }
    public static void main(String[] args) {
        int[] flowered = new int[]{1,0,0,0,1,0,0};
        boolean m = canPlaceFlowers(flowered,2);
        System.out.println(m);
    }
}
