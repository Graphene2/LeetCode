package 数组.time_8_11;

/**
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/8/11 14:34
 */
public class lc1160_countCharacters {
    public static int countCharacters(String[] words,String chars){
        int[] alphabet = new int[26];
        /**
         * 记录每个char出现的次数
         */
        for (char letter:chars.toCharArray()){
            alphabet[letter-'a'] += 1;
        }
        int result = 0;
        for (String word :words){
            boolean flag = true; // 标识位，用来标识是否可以拼出
            int[] alphabet2 = new int[26];
            for (char aa:word.toCharArray()){
                alphabet2[aa-'a'] += 1;
            }
            for (int i=0; i < 26; i++){
                if (alphabet2[i] > alphabet[i]){
                    flag = false;
                    break;
                }
            }
            if (flag) result += word.length();
        }
        return result;
    }
}
