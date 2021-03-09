package time_Oct;

import java.util.Stack;

/**
 * Description:（71，median）栈+字符数组+可变字符串容器
 * User: zhangcheng
 * Date: 2020-10-15
 * Time: 10:48
 */
public class lc71简化路径 {
    public String simplifyPath(String path){
        Stack<String> stack = new Stack<>();
        String[] str = path.split("/");
        for (String s:str){
            if (s.equals("..")){
                if (!stack.isEmpty()){
                    stack.pop();
                }
            }else if (!s.equals("") && !s.equals(".")){
                stack.push(s);
            }
        }
        if (stack.isEmpty()){
            return "/";
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < stack.size(); i++){
            ans.append("/" + stack.get(i));
        }
        return ans.toString();
    }
}
