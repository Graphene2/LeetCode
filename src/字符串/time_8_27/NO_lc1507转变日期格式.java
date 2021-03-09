package 字符串.time_8_27;

/**
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/8/27 15:18
 */
public class NO_lc1507转变日期格式 {
    public String reformatDate(String date) {
        String[] dates = date.split(" ");
        switch(dates[0]){
            case "1st": dates[0] = "01"; break;
            case "2nd": dates[0] = "02"; break;
            case "3rd": dates[0] = "03"; break;
            default: break;
        }
        dates[0] = dates[0].substring(0,dates.length - 1);
        switch(dates[1]){
            case "Jan": dates[1] = "01"; break;
            case "Feb": dates[1] = "02"; break;
            case "Mar": dates[1] = "03"; break;
            case "Apr": dates[1] = "04"; break;
            case "May": dates[1] = "05"; break;
            case "Jun": dates[1] = "06"; break;
            case "Jul": dates[1] = "07"; break;
            case "Aug": dates[1] = "08"; break;
            case "Sep": dates[1] = "09"; break;
            case "Oct": dates[1] = "10"; break;
            case "Nov": dates[1] = "11"; break;
            case "Dec": dates[1] = "12"; break;
        }
        return dates[2] + "-" +dates[1] + "-" +dates[0];
    }
}
