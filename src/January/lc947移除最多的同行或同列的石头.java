package January;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: cheneyzhang2018@gmail.com
 * @date: 2021/1/15,12:26
 * @version: 1.0
 */
public class  lc947移除最多的同行或同列的石头 {
    public int removeStones(int[][] stones) {
        int n = stones.length;
        UnionFind unionFind = new UnionFind();
        for (int[] stone : stones) {
            unionFind.union(stone[0] + 10001, stone[1]);
        }
        return n - unionFind.count;
    }

    private class UnionFind{
        private int count;
        private Map<Integer,Integer> parent;

        private UnionFind(){
            this.count = 0;
            this.parent = new HashMap();
        }

        private void union(int x,int y){
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY){
                return;
            }
            parent.put(rootX,rootY);
            count--;
        }
        private int find(int x) {
            if (!parent.containsKey(x)){
                parent.put(x,x);
                count++;
            }
            if (x != parent.get(x)){
                parent.put(x,find(parent.get(x)));
            }
            return parent.get(x);
        }

    }


}
