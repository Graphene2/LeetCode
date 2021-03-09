package March;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Description:
 * User: zhangcheng
 * Date: 2021-03-02
 * Time: 11:14
 */
public class lc179_MED {
    public String largestNumber(int[] nums) {
        String[] asStrs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            asStrs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(asStrs,new LargerNumberComparator());
        if (asStrs[0].equals("0")){
            return "0";
        }
        String largestNumberStr = new String();
        for (String numAsStr : asStrs){
            largestNumberStr += numAsStr;
        }
        return largestNumberStr;
    }

    private class LargerNumberComparator implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            String o1 = a + b;
            String o2 = b + a;
            return o2.compareTo(o1);
        }
    }
}
