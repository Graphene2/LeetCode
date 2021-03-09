package 数组.tim_8_13;

/**leetcode1184:公交站间的距离 Eazy
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/8/13 11:24
 */
public class lc1184_distanceBetweenBusStops {
    public static int distanceBetweenBusStops(int[] distance, int start, int destination){
        int sum = 0;
        for (int i=0 ; i < distance.length ; i++){
            sum += distance[i];
        }
        int m = Math.max(start, destination);
        int n = Math.min(start, destination);
        int ans = 0;
        for(int j=n ;j < m; j++){
            ans += distance[j];
        }
        if(ans > (sum / 2)){
            return sum - ans;
        }else return ans;
    }

    public static void main(String[] args) {
        int[] distance = new int[]{1,2,3,4};
        int m = distanceBetweenBusStops(distance,0,1);
        System.out.println(m);
    }
}
