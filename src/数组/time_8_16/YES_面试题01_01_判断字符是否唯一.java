package 数组.time_8_16;

/**面试题01_01_判断字符是否唯一  桶排序  后面利用int数据结构有32位，然后进行位运算存储每个位置的10判断是否出现过。
 *
 * @author: cheneyzhang2018@gmail.com
 * @date: 2020/8/16,9:33-9:50
 * @version: 1.0
 */
public class YES_面试题01_01_判断字符是否唯一 {
    public boolean isUnique(String astr) {
        int[] arr = new int[26];
        char[] tmp = astr.toCharArray();
        for (char temp: tmp){
            arr[temp -'a']++;
            if (arr[temp -'a'] >= 2){
                return false;
            }
        }return true;
    }
    // 通过位运算来表示是否已经存在元素。
    public boolean isUnique2(String astr) {
        int[] arr = new int[26];
        int mark = 0;
        for (char temp: astr.toCharArray()){
            int moveBit = 1 << temp -'a';
            if ((mark & moveBit) != 0){
                return false;
            }else mark |= moveBit;
        }return true;
    }
}
