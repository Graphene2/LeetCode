package March;

/**
 * Description:
 * User: zhangcheng
 * Date: 2021-03-02
 * Time: 10:06
 */
public class lc130_MED {
    // 深度优先
    int m,n;
    public void solve(char[][] board) {
        n = board.length;
        if (n == 0){
            return;
        }
        m = board[0].length;
        for (int i = 0; i < n; i++) {
            dfs(board,i,0);
            dfs(board,i,m - 1);
        }
        for (int i = 0; i < m; i++) {
            dfs(board,0,i);
            dfs(board,n - 1,i);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O'){
                    board[i][j] = 'X';
                }else if (board[i][j] == 'A'){
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int x, int y) {
        if ((x < 0)||(x >= n)||(y < 0)||(y >= m)||(board[x][y] != 'O')){
            return;
        }
        board[x][y] = 'A';
        dfs(board,x - 1,y);
        dfs(board,x + 1,y);
        dfs(board,x,y - 1);
        dfs(board,x,y + 1);
    }
    // 采用并查集的方法做
    int rows,cols;
    public void solve2(char[][] board) {
        if (board == null || board.length == 0){
            return;
        }
        rows = board.length;
        cols = board[0].length;

        UnionFind uf = new UnionFind(rows * cols + 1);
        int dummyNode = rows * cols;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O') {
                    if (i == 0 || i == rows - 1 ||j == 0 || j == cols - 1){
                        uf.union(node(i,j),dummyNode);
                    }else {
                        if (i > 0 && board[i - 1][j] == 'O'){
                            uf.union(node(i - 1,j),node(i,j));
                        }
                        if (i < rows - 1 && board[i + 1][j] =='O'){
                            uf.union(node(i,j),node(i + 1,j));
                        }
                        if (j > 0 && board[i][j - 1] == 'O'){
                            uf.union(node(i,j),node(i,j - 1));
                        }
                        if (j < cols - 1 && board[i][j + 1] =='O'){
                            uf.union(node(i,j),node(i,j + 1));
                        }
                    }

                }

            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (uf.isConnected(node(i,j),dummyNode)){
                    board[i][j] = 'O';
                }else {
                    board[i][j] = 'X';
                }
            }
        }

    }
    int node(int i, int j) {
        return i * cols + j;
    }

}
class UnionFind{
    int[] parents;

    public UnionFind(int totalNodes){
        parents = new int[totalNodes];
        for (int i = 0; i < totalNodes; i++) {
            parents[i] = i;
        }
    }

    void union(int node1,int node2){
        int root1 = find(node1);
        int root2 = find(node2);
        if (root1 != root2){
            parents[root2] = root1;
        }
    }

    int find(int node){
        while (parents[node] != node){
            parents[node] = parents[parents[node]];
            node = parents[node];
        }
        return node;
    }
    boolean isConnected(int node1, int node2) {
        return find(node1) == find(node2);
    }
}
