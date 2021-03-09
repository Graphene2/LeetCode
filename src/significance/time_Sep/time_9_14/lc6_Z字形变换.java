package significance.time_Sep.time_9_14;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/9/14 10:16
 */
public class lc6_Z字形变换 {
    public String convert(String s, int numRows) {
        if (numRows < 2) return s;
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }
        int i = 0, flag = -1;
        for (char c: s.toCharArray()){
            rows.get(i).append(c);
            if (i == 0 || i == numRows - 1) flag = -flag;
            i += flag;
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder row : rows) res.append(row);
        return res.toString();
    }
}
