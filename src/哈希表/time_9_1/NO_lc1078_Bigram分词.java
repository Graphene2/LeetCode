package 哈希表.time_9_1;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/9/1 11:01
 */
public class NO_lc1078_Bigram分词 {
    public String[] findOcurrences(String text, String first, String second) {
        String[] str = text.split(" ");
        if (str.length <= 2) return null;
        List<String> arr = new ArrayList<>();
        for (int i = 0; i < str.length - 2; i++){
            if (first.equals(str[i]) && second.equals(str[i+1])){
                arr.add(str[i+2]);
            }
        }
        return arr.toArray(new String[arr.size()]);
    }
}
