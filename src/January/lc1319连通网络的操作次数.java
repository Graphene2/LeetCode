package January;

/**
 * Description:
 * User: zhangcheng
 * Date: 2021-01-23
 * Time: 14:41
 */
public class lc1319连通网络的操作次数 {
    public int makeConnected(int n, int[][] connections) {
        if (connections == null || connections.length < n - 1){
            return -1;
        }
        UnionFind unionFind = new UnionFind(n);
        for (int i = 0; i < connections.length; i++) {
            unionFind.union(connections[i][0],connections[i][1]);
        }
        return unionFind.getCount() - 1;
    }

    private class UnionFind{
        // 记录节点的根
        private int[] parent;
        // 记录节点数目的大小，便于合并节点树。
        private int[] size;
        // 记录连通集个数
        private int count;


        private  UnionFind(int n){
            parent = new int[n];
            size = new int[n];
            count = n;
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        private int find(int x){
            // 路径压缩，直接指向根节点。
            if (x != parent[x]){
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
        // 按照节点数目规模合并。
        private void union(int x, int y){
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY){
                return;
            }
            if (size[rootX] < size[rootY]){
                parent[rootX] = rootY;
                size[rootY] += size[rootX];
            }else {
                parent[rootY] = rootX;
                size[rootX] += size[rootY];
            }
            count--;
        }
        private int getCount(){
            return count;
        }
    }
}
