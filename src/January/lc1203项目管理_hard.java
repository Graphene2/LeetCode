package January;

import java.awt.desktop.QuitEvent;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Description:
 * User: zhangcheng
 * Date: 2021-01-12
 * Time: 16:04
 */
public class lc1203项目管理_hard {
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {

        List<List<Integer>> groupItems = new ArrayList<>();
        for (int i = 0; i < m + n; i++) {
            groupItems.add(new ArrayList<>());
        }
        List<List<Integer>> groupGraph = new ArrayList<>();
        for (int i = 0; i < n + m; i++) {
            groupGraph.add(new ArrayList<>());
        }
        List<List<Integer>> itemGraph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            itemGraph.add(new ArrayList<>());
        }

        int[] groupDegree = new int[m + n];
        int[] itemDegree = new int[n];

        // 安排每个组对应的项目，遍历项目添加到组
        int leftId = m;
        for (int i = 0; i < n; i++) {
            if (group[i] == -1){
                group[i] = leftId;
                leftId++;
            }
            groupItems.get(group[i]).add(i);
        }

        List<Integer> id = new ArrayList<>();
        for (int i = 0; i < m + n; i++) {
            id.add(i);
        }

        // 构建组间的流向图。
        for (int i = 0; i < n; i++) {
            int currGroupId = group[i];
            for (int item : beforeItems.get(i)) {
                int beforeGroupId = group[item];
                if (currGroupId == group[item]){
                    itemDegree[i]++;
                    itemGraph.get(item).add(i);
                }else {
                    groupDegree[currGroupId]++;
                    groupGraph.get(beforeGroupId).add(currGroupId);
                }
            }
        }
        // 根据组间关系进行
        List<Integer> groupTopSort = topSort(groupDegree,groupGraph,id);
        if (groupTopSort.size() == 0){
            return new int[0];
        }
        int[] ans = new int[n];
        int index = 0;
        for(int currGroupId : groupTopSort){
            int size = groupItems.get(currGroupId).size();
            if (size == 0){
                continue;
            }
            List<Integer> res = topSort(itemDegree,itemGraph,groupItems.get(currGroupId));
            if (res.size() == 0){
                return new int[0];
            }
            for (int item : res) {
                ans[index++] = item;
            }
        }
        return ans;



    }

    private List<Integer> topSort(int[] degree, List<List<Integer>> graph, List<Integer> items) {
        Queue<Integer> queue = new LinkedList<>();
        for (int item : items) {
            if (degree[item] == 0){
                queue.offer(item);
            }
        }
        List<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()){
            int u = queue.poll();
            res.add(u);
            for (int v : graph.get(u)){
                if (--degree[v] == 0){
                    queue.offer(v);
                }
            }
        }
        return res.size() == items.size() ? res : new ArrayList<>();
    }
}
