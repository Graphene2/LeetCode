package January;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Description:
 * User: zhangcheng
 * Date: 2021-01-11
 * Time: 16:22
 */
public class lc1202交换字符串中的元素 {

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        if (pairs.size() == 0){
            return s;
        }
        int len = s.length();
        // 将pairs数据加入到并查集中。
        UnionFind unionFind = new UnionFind(len);
        for (List<Integer> pair : pairs) {
            int index1 = pair.get(0);
            int index2 = pair.get(1);
            unionFind.union(index1,index2);
        }
        // 2. 构建映射关系
        char[] charArray = s.toCharArray();
        Map<Integer, PriorityQueue<Character>> map = new HashMap<>(len);
        for (int i = 0; i < len; i++) {
            int root = unionFind.find(i);
//            if (map.containsKey(root)){
//                map.get(root).offer(charArray[i]);
//            }else {
//                PriorityQueue<Character> minHeap = new PriorityQueue<>();
//                minHeap.offer(charArray[i]);
//                map.put(root,minHeap);
//            }
            map.computeIfAbsent(root,key-> new PriorityQueue<>()).offer(charArray[i]);
        }

        // 3. 重组字符串
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            int root = unionFind.find(i);
            sb.append(map.get(root).poll());
        }
        return sb.toString();
    }
    // 并查集
    private class UnionFind{
        private int[] parent;
        /**
         * 以 i 为根节点的子树的高度。
         */
        private int[] rank;

        public UnionFind(int n) {
            this.parent = new int[n];
            this.rank = new int[n];
            for (int i = 0; i < n; i++) {
                this.parent[i] = i;
                this.rank[i] = 1;
            }
        }
        public void union(int x, int y){
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY){
                return;
            }
            if (rank[rootX] == rank[rootY]){
                parent[rootX] = rootY;
                rank[rootY]++;
            }else if (rank[rootX] < rank[rootY]){
                parent[rootX] = rootY;
            }else {
                parent[rootY] = rootX;
            }
        }

        private int find(int x) {
            if (x != parent[x]){
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
    }
}
