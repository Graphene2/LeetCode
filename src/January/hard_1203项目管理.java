package January;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Description:
 * User: zhangcheng
 * Date: 2021-01-12
 * Time: 9:52
 */
public class hard_1203项目管理 {
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        // groupItem 表示各个小组的项目
        List<List<Integer>> groupItem = new ArrayList<>();
        for (int i = 0; i < n + m; i++) {
            groupItem.add(new ArrayList<Integer>());
        }
        // itemGraph 构建项目的流向图
        List<List<Integer>> itemGraph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            itemGraph.add(new ArrayList<>());
        }
        // groupGraph 构建组和组之间的流向图，是根据项目的流向来确定的。
        List<List<Integer>> groupGraph = new ArrayList<>();
        for (int i = 0; i < n + m; i++) {
            groupGraph.add(new ArrayList<>());
        }

        // 组间的入度
        int[] groupDegree = new int[n + m];
        int[] itemDegree = new int[n];

        List<Integer> id = new ArrayList<>();
        for (int i = 0; i < m + n; i++) {
            id.add(i);
        }
        // groupItem 存储的是各个小组对应的项目。
        // 这里将没有对应组别的项目放进了新建的小组，从 m 开始编号。
        int leftId = m;
        for (int i = 0; i < n; i++) {
            if (group[i] == -1){
                group[i] = leftId;
                leftId++;
            }
            groupItem.get(group[i]).add(i);
        }
        // 这里的 i 表示第 i 个项目编号。
        for (int i = 0; i < n; i++) {
            // currGroupId 表示第 i 个项目所属的小组编号
            int currGroupId = group[i];
            // 这里的 item 表示 应该完成的项目编号
            for(int item : beforeItems.get(i)){
                int beforeGroupId = group[item];
                // 如果该 item 项目属于同一个小组的话，进行操作
                if (beforeGroupId == currGroupId){
                    // 项目 i 的入度递增，同时项目的流向
                    itemDegree[i]++;
                    itemGraph.get(item).add(i);
                    // 如果不属于同一个小组。
                }else {
                    // 当前小组的入度增加，同时增加小组流向
                    groupDegree[currGroupId]++;
                    groupGraph.get(beforeGroupId).add(currGroupId);
                }
            }
        }

        // 组间top关系排序，先进行各个组别之间的排序，通常无依赖即入度为0的直接放在前面，剩下的有出入的放在后面。
        List<Integer> groupTopSort = topSort(groupDegree,groupGraph,id);
        if (groupTopSort.size() == 0){
            return new int[0];
        }
        int[] ans = new int[n];
        int index = 0;
        // 组内top关系
        for (int curGroupId : groupTopSort){
            // 现在解决同一个组内的项目排序：通过项目的入度和流向进行排序。
            int size = groupItem.get(curGroupId).size();
            if (size == 0){
                continue;
            }
            List<Integer> res = topSort(itemDegree,itemGraph,groupItem.get(curGroupId));
            if (res.size() == 0){
                return new int[0];
            }
            for (int item : res){
                ans[index++] = item;
            }
        }
        return ans;
    }

    private List<Integer> topSort(int[] degree, List<List<Integer>> graph, List<Integer> items) {
        Queue<Integer> queue = new LinkedList<>();
        // 首先安排没有依赖关系的 group 或者 item。
        for (int item: items) {
            if (degree[item] == 0){
                queue.offer(item);
            }
        }
        // 然后逐一删除每个 group/item 的入度，最后分别添加一次
        List<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()){
            int u = queue.poll();
            res.add(u);
            for (int v : graph.get(u)){
                // 在这里保证了所以的元素只出现一次。
                if (--degree[v] == 0){
                    queue.offer(v);
                }
            }
        }
        return res.size() == items.size() ? res : new ArrayList<Integer>();
    }
}
