package time_NOV;

import java.util.*;

/** 这个暂时是单向BFS，实际上需要的是双向的BFS
 * @author: cheneyzhang2018@gmail.com
 * @date: 2020/11/5,23:12
 * @version: 1.0
 */
public class hard_lc127单词接龙 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (wordSet.size() == 0 || !wordSet.contains(endWord)){
            return 0;
        }
        wordSet.remove(beginWord);
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        int step = 1;
        while (!queue.isEmpty()){
            int currentSize = queue.size();
            for (int i = 0; i < currentSize; i++) {
                String currentWord = queue.poll();
                if (changeWordEveryOneLetter(currentWord,endWord,queue,visited,wordSet)){
                    return step + 1;
                }
            }
            step++;
        }
        return 0;
    }

    private boolean changeWordEveryOneLetter(String currentWord, String endWord, Queue<String> queue, Set<String> visited, Set<String> wordSet) {
        char[] currentChar = currentWord.toCharArray();
        for (int i = 0; i < endWord.length(); i++) {
            char originChar = currentChar[i];
            for (char k = 'a'; k <= 'z'; k++){
                if (k == originChar){
                    continue;
                }
                currentChar[i] = k;
                String nextWord = String.valueOf(currentChar);
                if (wordSet.contains(nextWord)){
                    if (nextWord.equals(endWord)){
                        return true;
                    }
                    if (!visited.contains(nextWord)){
                        queue.add(nextWord);
                        visited.add(nextWord);
                    }
                }
            }
            currentChar[i] = originChar;
        }
        return false;
    }

}
