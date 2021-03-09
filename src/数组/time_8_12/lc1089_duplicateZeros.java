package 数组.time_8_12;

/**leetcode1089: 复写零  方法：从后往前倒叙，但是要注意边界点！这是难点
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/8/12 8:54
 */
public class lc1089_duplicateZeros {
    public static void duplicateZeros(int[] arr){
        int length = arr.length - 1;
        int zeroCount = 0;
        for (int i = 0; i <= length - zeroCount;i++){
            if (arr[i] == 0){
                if (i == length - zeroCount){
                    arr[length] = 0;
                    length--;
                    break;
                }
                zeroCount++;
            }
        }
        int temp = length - zeroCount;
        for (int i = temp;i >= 0;i--){
            if (arr[i] != 0){
                arr[i + zeroCount] = arr[i];
            }else {
                arr[i + zeroCount] = 0;
                zeroCount--;
                arr[i + zeroCount] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{8,4,5,0,0,0,0,7};
        for (int item:arr){
            System.out.print(item+"\t");
        }
        System.out.println();
        duplicateZeros(arr);
        for (int item:arr){
            System.out.print(item+"\t");
        }
    }
}
