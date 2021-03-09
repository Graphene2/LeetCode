package 字符串.time_8_27;

/**URL化。编写一种方法，将字符串中的空格全部替换为%20。假定该字符串尾部有足够的空间存放新增字符，并且知道字符串的“真实”长度。
 * 注：用Java实现的话，请使用字符数组实现，以便直接在数组上操作。
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/8/27 10:51
 */
public class NO_面试01_03URL化 {
    public String replaceSpaces(String S, int length) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < length; i++){
            if(S.charAt(i) == ' '){
                sb.append("%20");
            }else{
                sb.append(S.charAt(i));
            }
        }
        return sb.toString();
    }
}
