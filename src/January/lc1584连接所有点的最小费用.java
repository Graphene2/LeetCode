package January;

import org.w3c.dom.ls.LSInput;

import java.text.CollationElementIterator;
import java.util.*;

/**
 * Description:
 * User: zhangcheng
 * Date: 2021-01-19
 * Time: 9:40
 */
public class lc1584连接所有点的最小费用 {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        DisjointSetUnion dsu = new DisjointSetUnion(n);
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                edges.add(new Edge(dist(points,i,j),i,j));
            }
        }
        Collections.sort(edges, new Comparator<Edge>() {
            @Override
            public int compare(Edge edge1, Edge edge2) {
                return edge1.len - edge2.len;
            }
        });
        int ret = 0,num = 1;
        for (Edge edge : edges){
            int len = edge.len, x = edge.x, y = edge.y;
            if (dsu.union(x,y)){
                ret += len;
                num++;
                if (num == n){
                    break;
                }
            }
        }
        return ret;

    }


    private int dist(int[][] points, int x, int y){
        return Math.abs(points[x][0] - points[y][0]) + Math.abs(points[x][1] - points[y][1]);
    }
    private class DisjointSetUnion{
        int[] parent;
        int[] rank;
        int n;

        public DisjointSetUnion(int n){
            this.n = n;
            this.rank = new int[n];
            Arrays.fill(this.rank,1);
            this.parent = new int[n];
            for (int i = 0; i < n; i++) {
                this.parent[i] = i;
            }
        }

        public int find(int x){
            if (parent[x] != x){
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public boolean union(int x, int y){
            int rootx = find(x);
            int rooty = find(y);
            if (rootx == rooty){
                return false;
            }
            if (rank[rootx] < rank[rooty]){
                int temp = rootx;
                rootx = rooty;
                rooty = temp;
            }
            rank[rootx] += rank[rooty];
            parent[rooty] = rootx;
            return true;
        }

    }
    private class Edge{
        int len,x,y;
        public Edge(int len, int x,int y){
            this.len = len;
            this.x = x;
            this.y = y;
        }
    }
}
