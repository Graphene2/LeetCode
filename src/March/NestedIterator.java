package March;

import java.util.*;

/**
 * Description:
 * User: zhangcheng
 * Date: 2021-03-23
 * Time: 9:27
 */
public class NestedIterator implements Iterator<Integer>{
    private List<Integer> vals = new ArrayList<>();
    private Iterator<Integer> itar;
    public NestedIterator(List<NestedInteger> nestedList){
        dfs(nestedList);
        itar = vals.listIterator();
    }
    public Integer next(){
        return itar.next();
    }

    public boolean hasNext(){
        return itar.hasNext();
    }

    private void dfs(List<NestedInteger> nestedList){
        for (NestedInteger nest: nestedList){
            if (nest.isInteger()){
                vals.add(nest.getInteger());
            }else {
                dfs(nest.getList());
            }
        }
    }
}
class NestedIterator2 implements Iterator<Integer>{
    Deque<NestedInteger> stack = new ArrayDeque<>();
    public NestedIterator2(List<NestedInteger> nestedList){
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            stack.addLast(nestedList.get(i));
        }
    }
    public Integer next(){
        return stack.pollLast().getInteger();
    }

    public boolean hasNext(){
        if (stack.isEmpty()){
            return false;
        }else {
            if (!stack.peekLast().isInteger()){
                List<NestedInteger> nest = stack.pollLast().getList();
                for (int i = nest.size() - 1; i >= 0; i--) {
                    stack.addLast(nest.get(i));
                }
                return hasNext();
            }else {
                return true;
            }
        }
    }
}



interface NestedInteger {
    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();
    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();
    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}