package 哈希表.time_8_28;

/**快排算法！
 * @author: cheneyzhang2018@gmail.com
 * @date: 2020/8/28,19:07
 * @version: 1.0
 */
public class QuickSort {
    public static void main(String[] args) {

    }
    // 快排的一种写法
    public static void Qksort(int[] a, int start, int end){
        if (a.length < 0) return;
        if (start >= end) return;
        int left = start, right = end;
        int pviot = a[left];  // 将第一个作为标杆，即pviot
        while (left < right){
            while (left < right && a[right] > pviot){ // 寻找尾部比标杆小的index。
                right--;
            }
            a[left] = a[right]; // 最好还是直接交换两者的值，也就是pviot这个值一直在不断的被换来换去！ 直接交换该left和right索引的值。
            while (left < right && a[left] < pviot){
                left++;
            }
            a[right] = a[left];
        }
        a[left] = pviot;
        Qksort(a,start,left - 1);
        Qksort(a,left + 1, end);
    }


}
