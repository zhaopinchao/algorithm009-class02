import java.util.*;

/**
 * @author: zhaopc
 * @date: 2020-07-05 22:08
 * @description
 */
public class LadderLength2 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || wordList.size() == 0) {
            return 0;
        }
        Map<String, Boolean> wordSet = new HashMap<>(wordList.size());
        for (String s : wordList) {
            wordSet.put(s, false);
        }
        //如果endWord不在字段中,那么直接返回0
        if (!wordSet.containsKey(endWord)) {
            return 0;
        }
        //结果从1开始
        int result = 1;
        if (beginWord.equals(endWord)) {
            return result;
        }
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);
        while (!beginSet.isEmpty()) {
            //交换set
            if (beginSet.size() > endSet.size()) {
                Set<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }
            result++;
            Set<String> temp = new HashSet<>();
            for (String s : beginSet) {
                char[] chars = s.toCharArray();
                for (int j = 0; j < chars.length; j++) {
                    char c = chars[j];
                    for (char k = 'a'; k <= 'z'; k++) {
                        if (k == c) {
                            continue;
                        }
                        chars[j] = k;
                        String tempStr = String.valueOf(chars);
                        if (endSet.contains(tempStr)) {
                            return result;
                        }
                        if(wordSet.containsKey(tempStr) && !wordSet.get(tempStr)) {
                            temp.add(tempStr);
                            wordSet.put(tempStr, true);
                        }
                    }
                    chars[j] = c;
                }
            }
            beginSet = temp;
        }
        return 0;
    }
}
