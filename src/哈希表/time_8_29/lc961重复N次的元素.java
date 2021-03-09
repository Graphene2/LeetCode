package 哈希表.time_8_29;

/**
 * @author: cheneyzhang2018@gmail.com
 * @date: 2020/8/29,15:00
 * @version: 1.0
 */
public class lc961重复N次的元素 {
    public static int repeatedNTimes(int[] A) {
        int temp = 0, n = A.length;
        int ans = A[0], count = 1;
        for (int i = 1; i < n; i++){
            if (i == n - 1 ){
                temp = ans;
            }
            if (A[i] != ans){
                count--;

            } else if (A[i] == ans){
                count++;
            }
            if (count == 0){
                ans = A[i];
                count = 1;
            }
        }
        count = 0;
        for (int i = 0; i < n; i++){
            if (A[i] == ans)
                count++;
        }
        if (count == n / 2) return ans;
        else return temp;
    }

    public static void main(String[] args) {
        int[] A = new   int[]{2,1,2,5,3,2};
        int m = repeatedNTimes(A);
        System.out.println(m);
    }
}
