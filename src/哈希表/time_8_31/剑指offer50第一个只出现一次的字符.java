package 哈希表.time_8_31;

/**
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/8/31 18:26
 */
class 剑指offer50第一个只出现一次的字符 {
    public char firstUniqChar(String s) {
        int[] arr = new int[26];
        for (char e: s.toCharArray()){
            arr[e - 'a']++;
        }
        for (int i = 0; i < s.length(); i++){
            char e = s.charAt(i);
            if (arr[e - 'a'] == 1){
                return e;
            }
        }
        return ' ';
    }
}
