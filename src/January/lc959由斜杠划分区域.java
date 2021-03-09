package January;

/**
 * Description:
 * User: zhangcheng
 * Date: 2021-01-25
 * Time: 14:47
 */
public class lc959由斜杠划分区域 {
    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        int size = 4 * n * n;

        UnionFind unionFind = new UnionFind(size);
        for (int i = 0; i < n; i++) {
            char[] row = grid[i].toCharArray();
            for (int j = 0; j < n; j++) {
                int index = 4 * (i * n + j);
                char c = row[j];
                if (c == '/'){
                    unionFind.union(index,index + 3);
                    unionFind.union(index + 1, index + 2);
                }else if (c == '\\'){
                    unionFind.union(index, index + 1);
                    unionFind.union(index + 2, index + 3);
                }else {
                    unionFind.union(index, index + 1);
                    unionFind.union(index, index + 2);
                    unionFind.union(index,index + 3);
                }
                if (j + 1 < n){
                    unionFind.union(index + 1,4 * (i * n + j + 1) + 3);
                }
                if (i + 1 < n){
                    unionFind.union(index + 2,4 * ((i + 1) * n + j));
                }
            }
        }
        return unionFind.getCount();
    }
    private class UnionFind{
        private int[] parent;
        private int   count;

        public int getCount(){
            return this.count;
        }
        public UnionFind(int n){
            this.count = n;
            this.parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }
        public int find(int x){
            while (x != parent[x]){
                parent[x] = find(parent[x]);
                x = parent[x];
            }
            return parent[x];
        }

        public void union(int x,int y){
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY){
                return;
            }
            parent[rootX] = rootY;
            count--;
        }

    }
}
