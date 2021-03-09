package 字符串.time_8_26;

/**
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/8/26 13:13-13:43
 */
public class lc434字符串中的单词数 {
    // 使用系统自带的函数trim和split。空间复杂度为O(n)
    public int countSegments(String s) {
        String trimmed = s.trim();
        if (trimmed.equals("")) {
            return 0;
        }
        // \s表示匹配任何空白字符，包括空格、制表符、换页符等等, 等价于[ \f\n\r\t\v],而"\s+"则表示匹配任意多个上面的字符
        return trimmed.split("\\s+").length;
    }
    // 遍历直接定义单词个数。
    public int countSegments2(String s) {
        int segmentCount = 0;

        for (int i = 0; i < s.length(); i++) {
            if ((i == 0 || s.charAt(i-1) == ' ') && s.charAt(i) != ' ') {
                segmentCount++;
            }
        }

        return segmentCount;
    }


}
