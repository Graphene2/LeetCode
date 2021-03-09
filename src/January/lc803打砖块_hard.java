package January;

/**
 * Description:
 * User: zhangcheng
 * Date: 2021-01-16
 * Time: 14:04
 */
public class lc803打砖块_hard {
    private int rows;
    private int cols;

    public static final int[][] DIRECTIONS = {{-1,0},{1,0},{0,-1},{0,1}};

    public int[] hitBricks(int[][]grid, int[][] hits){
        this.rows = grid.length;
        this.cols = grid[0].length;

        int[][] copy = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                copy[i][j] = grid[i][j];
            }
        }

        for (int i = 0; i < hits.length; i++) {
            copy[hits[i][0]][hits[i][1]] = 0;
        }

        int size = rows * cols;
        UnionFind unionFind = new UnionFind(size + 1);

        for (int i = 0; i < cols; i++) {
            if (copy[0][i] == 1){
                unionFind.union(i,size);
            }
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (copy[i][j] == 1) {
                    if (copy[i - 1][j] == 1) {
                        unionFind.union(getIndex(i - 1, j), getIndex(i, j));
                    }
                    if (j > 0 && copy[i][j - 1] == 1) {
                        unionFind.union(getIndex(i, j), getIndex(i, j - 1));
                    }
                }
            }
        }

        int hisLen = hits.length;
        int[] res = new int[hisLen];
        for (int i = hisLen - 1; i >= 0 ; i--) {
            int x = hits[i][0];
            int y = hits[i][1];
            // 原计划是空白，说明敲砖块敲到空白处了，没用心！
            if (grid[x][y] == 0){
                continue;
            }
            int origin = unionFind.getSize(size);

            if (x == 0){
                unionFind.union(getIndex(0,y),size);
            }

            for (int[] direction : DIRECTIONS) {
                int newX = x + direction[0];
                int newY = y + direction[1];

                if (inArea(newX,newY) && copy[newX][newY] == 1){
                    unionFind.union(getIndex(x,y),getIndex(newX,newY));
                }
            }

            int current = unionFind.getSize(size);

            res[i] = Math.max(0 , current - origin - 1);

            copy[x][y] = 1;
        }
        return res;
    }

    private boolean inArea(int x, int y){
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }

    private int getIndex(int x, int y){
        return x * cols + y;
    }

    private class UnionFind{
        private int[] parent;

        private int[] size;

        public UnionFind(int n){
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int find(int x){
            if (x != parent[x]){
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int x, int y){
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY){
                return;
            }
            parent[rootX] = rootY;
            size[rootY] += size[rootX];
        }

        public int getSize(int x){
            int root = find(x);
            return size[root];
        }
    }
}
