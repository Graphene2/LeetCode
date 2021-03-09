package 哈希表.time_9_1;

import java.sql.ClientInfoStatus;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/9/1 13:12
 */
class lc748最短完整词 {
    public static String shortestCompletingWord(String licensePlate, String[] words) {
        String str = null;
        int length = 16;
        sss:for (int i = 0; i < words.length; i++){
            int[] arr = new int[26];
            for (char e:words[i].toCharArray()){
                arr[e - 'a']++;
            }
            for (char c: licensePlate.toCharArray()){
                if (Character.isLetter(c)){
                    char e = Character.toLowerCase(c);
                    arr[e - 'a']--;
                    if (arr[e - 'a'] < 0){
                        continue sss;
                    }
                }
            }
            if (words[i].length() < length){
                str = words[i];
                length = words[i].length();
            }
        }
        return str;
    }

    public static void main(String[] args) {
        String a1 = "1s3 456";
        String[] words ={"looks","pest","stew","show"};
        String m = shortestCompletingWord(a1,words);
        System.out.println(m);
    }
}
