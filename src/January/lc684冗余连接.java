package January;

/**
 * Description:
 * User: zhangcheng
 * Date: 2021-01-13
 * Time: 9:33
 */
public class lc684冗余连接 {
    public int[] findRedundantConnection(int[][] edges) {
        int len = edges.length;
        int[] parent = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < len; i++) {
            int[] edge = edges[i];
            int node1 = edge[0],node2 = edge[1];
            if (parent[find(parent,node1)] != parent[find(parent,node2)]){
                union(parent,node1,node2);
            }else {
                return edge;
            }
        }
        return new int[0];
    }



    private void union(int[] parent, int node1, int node2) {
        parent[find(parent,node1)] = find(parent,node2);
    }

    private int find(int[] parent, int node2) {
        if (parent[node2] != node2){
            node2 = find(parent,parent[node2]);
        }
        return node2;
    }

}
