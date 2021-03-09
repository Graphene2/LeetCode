package 数组.time_8_11;

/**leetcode1051.Height Checker ：核心思想为桶排序，具有较低的时间复杂度，同时能够得到
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/8/10 10:05
 */
public class lc1051_heightChecked {
    public static int heightChecker(int[] heights){
        int[] newBook = new int[101];
        int uCount = 0;
        for (int height:heights){
            newBook[height]++;
        }
        for (int i = 1, j=0;i < newBook.length; i++){
            while (newBook[i]-- > 0){
                if (heights[j++] != i){
                    uCount++;
                }
            }
        }
        return uCount;
    }

    public static void main(String[] args) {
        int[] heights;
        heights = new int[]{1,1,2,4,5,6,6,8,5,6,8,10};
        int m = heightChecker(heights);
        System.out.println(m);
    }
}
