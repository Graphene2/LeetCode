package JAVAFORMEETING;

/**
 * Description:
 * User: zhangcheng
 * Date: 2021-04-02
 * Time: 15:37
 */
public class 面17_21接雨水 {
    public static int trap(int[] height) {
        int len = height.length;
        int[] leftMaxArr = new int[len];
        int[] rightMaxArr = new int[len];
        int leftMax = 0;
        for(int i = 0; i < len; i++){
            if(height[i] > leftMax){
                leftMax = height[i];
            }
            leftMaxArr[i] = leftMax;
        }
        int rightMax = 0;
        for(int i = len - 1; i >= 0;i--){
            if (height[i] > rightMax){
                rightMax = height[i];
            }
            rightMaxArr[i] = rightMax;
        }

        int res = 0;
        for(int i = 0; i < len; i++){
            int tempMin = Math.min(leftMaxArr[i], rightMaxArr[i]);
            if (tempMin > height[i]){
                res += tempMin - height[i];
            }

        }
        return res;
    }

    public static void main(String[] args) {
        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(面17_21接雨水.trap(height));

    }
}
