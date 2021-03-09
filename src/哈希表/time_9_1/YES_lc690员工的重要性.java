package 哈希表.time_9_1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/9/1 8:35-8:44
 */
class lc690员工的重要性 {
    Map<Integer, Employee> emap;
    public int getImportance(List<Employee> employees, int id) {
        emap = new HashMap<>();
        for (Employee e:employees){
            emap.put(e.id,e);
        }
        return dfs(id);
    }

    private int dfs(int id) {
        Employee employee = emap.get(id);
        int ans = employee.importance;
        for (Integer ee: employee.subordinates){
            ans += dfs(ee);
        }
        return ans;
    }
}
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};


