package 数组.time_8_11;

/**leetcode1266: 将每个元素替换为右侧最大元素,Eazy
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/8/11 16:57
 */
public class lc1266_replaceElements {
    public static int[] replaceElements(int[] arr){
        int max = arr[arr.length-1];
        arr[arr.length-1] = -1;
        for (int i = arr.length - 2; i >= 0;i--){
            int temp = arr[i];
            arr[i] = max;
            max = Math.max(temp,max);
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{17,18,5,4,6,1};
        for (int temp:arr){
            System.out.print(temp+"\t");
        }
        System.out.println();
        replaceElements(arr);
        for (int temp:arr){
            System.out.print(temp+"\t");
        }
    }
}
