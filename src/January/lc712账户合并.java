package January;

import java.util.*;

/**
 * Description:
 * User: zhangcheng
 * Date: 2021-01-18
 * Time: 9:15
 */
public class lc712账户合并 {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String,Integer> emailToIndex = new HashMap<>();
        Map<String,String> emailToName = new HashMap<>();
        int emailCount = 0;
        for (List<String> account : accounts){
            String name =  account.get(0);
            int size = account.size();
            for (int i = 1; i < size; i++) {
                String email = account.get(i);
                if (!emailToIndex.containsKey(email)){
                    emailToIndex.put(email,emailCount++);
                    emailToName.put(email,name);
                }
            }
        }
        UnionFind unionFind = new UnionFind(emailCount);
        Map<Integer,List<String>> indexToEmail = new HashMap<>();
        for (List<String> account : accounts){
            String firstEmail = account.get(1);
            int firstIndex = emailToIndex.get(firstEmail);
            int size = account.size();
            for (int i = 2; i < size; i++) {
                String nextEmail = account.get(i);
                int nextIndex = emailToIndex.get(nextEmail);
                unionFind.union(firstIndex,nextIndex);
            }
        }

        for (String email : emailToIndex.keySet()){
            int index = unionFind.find(emailToIndex.get(email));
            List<String> account = indexToEmail.getOrDefault(index,new ArrayList<String>());
            account.add(email);
            indexToEmail.put(index,account);
        }

        List<List<String>> merged = new ArrayList<>();
        for (List<String> email : indexToEmail.values()){
            Collections.sort(email);
            String name = emailToName.get(email.get(0));
            List<String> account = new ArrayList<>();
            account.add(name);
            account.addAll(email);
            merged.add(account);
        }
        return merged;


    }

    private class UnionFind{
        private int[] parent;

        public UnionFind(int n){
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public void union(int x, int y){
            parent[find(x)] = parent[find(y)];
        }

        public int find(int index){
            if (parent[index] != index){
                parent[index] = parent[find(index)];
            }
            return parent[index];
        }

    }
}
