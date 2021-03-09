package 数组.tim_8_13;

/**leetcode43_medium: 字符串相乘
 * 时间复杂度：O(MN),MN为字符串长度。
 * 空间复杂度：O(M+N),创建一个数组存储结果。
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/8/13 9:21
 */
public class lc43_stringMultiply {
    public static String stringMultiply(String num1,String num2){
        // 其中一个为0时结果为0；
        if (num1.equals("0") || num2.equals("0"))
            return "0";
        int m = num1.length(), n = num2.length();
        // 创建res数组保存乘法的结果，每一次num1[i]和num2[j]的乘法结果第一位位于res[i+j],第二位位于res[i+j+1]
        int[] res = new int[num1.length()+num2.length()];
        for (int i = m - 1; i >= 0; i--){
            int n1 = num1.charAt(i) - '0';
            for (int j = n - 1 ; j >= 0; j--){
                int n2 = num2.charAt(j) - '0';
                // 此处res[i+j+1]表示的是乘积的低位，却也表示着前一位的进位信号，需要加到sum中而不只是后续的res[i+j+1]中
                int sum = ( res[i+j+1] +n1 * n2);
                res[i+j+1] = sum % 10;
                res[i+j] += sum / 10;
            }
        }
        // 将res数组转换成字符串添加到结果中，注意i=0时为最高位，需要判断是否为0从而表示是否显示。
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < m+n ; i++){
            if (i == 0 && res[i] == 0) continue;
            result.append(res[i]);
        }
        // 使用StringBuilder中的toString方法将当前StringBuilder对象转换为String对象。
        return result.toString();
    }

    public static void main(String[] args) {
        String num1 = "13";
        String num2 = "456";
        String res = stringMultiply(num1,num2);
        System.out.println(res);
    }
}
