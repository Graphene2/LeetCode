package hot100;

import org.w3c.dom.ls.LSInput;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Description:
 * User: zhangcheng
 * Date: 2020-12-21
 * Time: 15:24
 */
public class lc347前K个高频元素 {
    // 方法一: 小根堆
    public int[] topKFrequent1(int[] nums, int k) {
        // 首先统计每个数字出现的次数。
        Map<Integer,Integer> count  = new HashMap<>();
        for (int num : nums){
            count.put(num,count.getOrDefault(num,0) + 1);
        }
        PriorityQueue<int []> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] m, int[] n) {
                return m[1] - n[1];
            }
        });
        for (Map.Entry<Integer,Integer> entry : count.entrySet()){
            int num = entry.getKey(), value = entry.getValue();
            if (queue.size() == k){
                if (queue.peek()[1] < value){
                    queue.poll();
                    queue.offer(new int[]{num,value});
                }
            }else {
                queue.offer(new int[]{num,value});
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll()[0];
        }
        return res;
    }
    // 方法二: 计数排序即桶排序
    public int[] topKFrequent2(int[] nums, int k) {
        // 首先统计每个数字出现的次数。
        Map<Integer,Integer> count  = new HashMap<>();
        for (int num : nums){
            count.put(num,count.getOrDefault(num,0) + 1);
        }
        // 为啥用队列？因为频次可能出现重复的，导致同一频次的数字有好几项。
        List<Integer>[] freqList = new List[nums.length + 1];
        for (int i = 0; i < freqList.length; i++) {
            freqList[i] = new ArrayList<>();
        }
        count.forEach((num,freq) ->{
            freqList[freq].add(num);
        });
        // 按照频次大小，从大到小遍历数组
        int[] res = new int[k];
        int idx = 0;
        for (int fre = freqList.length - 1; fre > 0; fre--){
            for(int num : freqList[fre]){
                res[idx++] = num;
                if (idx == k){
                    return res;
                }
            }
        }
        return res;
    }
    // 方法三: 二叉搜索树
    public int[] topKFrequent3(int[] nums, int k) {
        // 统计每个数字出现的次数
//        Map<Integer, Integer> counterMap = IntStream.of(nums).boxed().collect(
//                Collectors.toMap(e -> e, e -> 1, Integer::sum)
//        );
        Map<Integer,Integer> countFreq  = new HashMap<>();
        for (int num : nums){
            countFreq.put(num,countFreq.getOrDefault(num,0) + 1);
        }
        // 定义二叉搜索树：key 是数字出现的次数，value 是出现了key次的数字列表。
        TreeMap<Integer, List<Integer>> treeMap = new TreeMap<>();
        // 维护一个有 k 个数字的二叉搜索树：
        // 不足 k 个直接将当前数字加入到树中；否则判断当前树中的最小次数是否小于当前数字的出现次数。
        // 若是，则删掉树中出现次数最少的一个数字，将当前数字加入树中。
        int count = 0;
        for (Map.Entry<Integer,Integer> entry : countFreq.entrySet()) {
            int num = entry.getKey(), freq = entry.getValue();
            if (count < k){
                treeMap.computeIfAbsent(freq,ArrayList::new).add(num);
                count++;
            }else{
                Map.Entry<Integer,List<Integer>> firstEntry = treeMap.firstEntry();
                if (freq > firstEntry.getKey()){
                    treeMap.computeIfAbsent(freq,ArrayList::new).add(num);
                    List<Integer> list = firstEntry.getValue();
                    if (list.size() == 1){
                        treeMap.pollFirstEntry();
                    }else {
                        list.remove(list.size() - 1);
                    }
                }
            }
        }
        // 返回构造结果
        int[] res = new int[k];
        int idx = 0;
        for (List<Integer> list : treeMap.values()){
            for (int numL : list){
                res[idx++] = numL;
            }
        }
        return res;
    }

    public int[] topKFrequent4(int[] nums, int k) {
        // 统计每个数字出现的次数
        Map<Integer,Integer> countFreq  = new HashMap<>();
        for (int num : nums){
            countFreq.put(num,countFreq.getOrDefault(num,0) + 1);
        }
        List<int[]> values = new ArrayList<int[]>();
        for (Map.Entry<Integer,Integer> entry : countFreq.entrySet()){
            int num = entry.getKey(),count = entry.getValue();
            values.add(new int[]{num,count});
        }
        int[] res = new int[k];
        qsort(values,0,values.size() - 1,res,0,k);
        return res;
    }

    private void qsort(List<int[]> values, int start, int end, int[] res, int resIndex, int k) {
        int picked = (int)(Math.random() * (end - start + 1)) + start;
        Collections.swap(values,picked,start);

        int pivot = values.get(start)[1];
        int index = start;
        for (int i = start + 1; i <= end ; i++) {
            if (values.get(i)[1] >= pivot){
                Collections.swap(values,index + 1, i);
                index++;
            }
        }
        Collections.swap(values,start,index);
        if (k <= index - start){
            qsort(values,start,index - 1,res,resIndex,k);
        }else {
            for (int i = start; i <= index ; i++) {
                res[resIndex++] = values.get(i)[0];
            }
            if (k > index - start + 1){
                qsort(values,index + 1,end, res, resIndex, k - (index - start + 1));
            }
        }
    }

}
