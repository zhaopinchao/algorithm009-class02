import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: zhaopc
 * @date: 2020-05-30 15:42
 * @description
 */
public class IsAnagram {

    /**
     * 哈希表
     * 1.遍历字符串s, 将s的所有字符存入map中,并计算每个字符出现的次数
     * 2.遍历字符串t, 将t的所有字符都去map中找,找到了就操作该字符出现次数-1, 如果没找到return false
     * 空间复杂度O(1), 时间复杂度O(n)
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>(s.length());
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (map.containsKey(c) && map.get(c) > 0) {
                map.put(c, map.get(c) - 1);
            } else {
                return false;
            }
        }
        return true;
    }

    /**
     * 哈希表
     * 用数组代替map, 字符char作为数组下标
     * s字符串中包含该字符,array[c]++;
     * t字符串中包含该字符,array[c]--, 如果array[c] < 0, return false
     * 空间复杂度O(1), 时间复杂度O(n)
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram1(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        int[] chars = new int['z' - 'a' + 1];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            chars[c - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (--chars[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 将两个字符串进行排序(排序的时间复杂度为O(log n)), 然后进行equals比较
     * 空间复杂度O(n), 时间负责度O(log n)
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }
}
