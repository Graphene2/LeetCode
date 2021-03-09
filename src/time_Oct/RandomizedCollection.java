package time_Oct;

import java.util.*;

/**
 * Description:O(1)时间插入删除和获取随机元素允许重复
 * User: zhangcheng
 * Date: 2020-10-31
 * Time: 16:49
 */
public class RandomizedCollection {
    Map<Integer, Set<Integer>> idx;
    List<Integer> nums;
    public RandomizedCollection() {
        idx = new HashMap<Integer, Set<Integer>>();
        nums = new ArrayList<Integer>();
    }

    public boolean insert(int val) {
        nums.add(val);
        Set<Integer> set = idx.getOrDefault(val,new HashSet<Integer>());
        set.add(nums.size() - 1);
        idx.put(val,set);
        return set.size() == 1;
    }

    public boolean remove(int val) {
        if (!idx.containsKey(val)) {
            return false;
        }
        Iterator<Integer> it = idx.get(val).iterator();
        int pos = it.next();
        int lastNum = nums.get(nums.size() - 1);
        nums.set(pos,lastNum);
        // 在idx 中删掉对应值中的
        idx.get(val).remove(pos);
        idx.get(lastNum).remove(nums.size() - 1);
        // 如果数组出现了一个val所在的位置不是数组中最后一个位置,在idx中添加lastNum以及对应set中存入i这个位置
        if (pos < nums.size() - 1){
            idx.get(lastNum).add(pos);
        }
        // 如果该val只存在一个,删掉idx中的map
        if (idx.get(val).size() == 0){
            idx.remove(val);
        }
        // 删掉最后数组中的最后一个元素
        nums.remove(nums.size() - 1);
        return true;
    }

    public int getRandom() {
        return nums.get((int) (Math.random() * nums.size()));
    }

}
