package 数组.time_8_11;

/**leetcode1491: 去掉最高和最低工资的平均值 :Eazy
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/8/11 16:23
 */
public class lc1491_averageSalary {
    public static double averageSalary(int[] salary) {
    Integer max = Integer.MIN_VALUE;
    Integer min = Integer.MAX_VALUE;
    int sumSalary = 0;
    for(int i = 0; i < salary.length; i++){
        max = Math.max(salary[i], max);
        min = Math.min(salary[i], min);
        sumSalary += salary[i];
    }
    double result = (double)(sumSalary - max - min) / (salary.length - 2);
    return result;
    }

    public static void main(String[] args) {
        int[] salary = new int[]{6000,5000,4000,3000,2000,1000};
        double m = averageSalary(salary);
        System.out.println(m);
    }
}
