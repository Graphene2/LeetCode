package 字符串.time_8_26;

import java.util.Arrays;

/**
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/8/26 13:42
 */
public class YES_lc443压缩字符串 {
    public static int compress(char[] chars) {
       int pos = 0, write = 0;
       for (int read = 0; read < chars.length; read++){
           if (read + 1 == chars.length || chars[read + 1] != chars[read]){
               chars[write++] = chars[pos];
               if (read > pos){
                   for (char c: (""+(read - pos + 1)).toCharArray()){
                       chars[write++] = c;
                   }
               }
               pos = read + 1;
           }
       }return write;
    }

    public static void main(String[] args) {
        char[] arr = new char[]{'a','a','b','b','c','c','c'};
        compress(arr);
        for (char c: arr){
            System.out.print(c);
        }
    }
}
