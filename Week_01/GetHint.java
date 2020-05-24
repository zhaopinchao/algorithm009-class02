import java.util.HashMap;
import java.util.Map;

/**
 * @author: zhaopc@tuya.com
 * @date: 2020-05-23 21:32
 * @description
 */
public class GetHint {
    public String getHint(String secret, String guess) {
        int len = secret.length();
        Map<Character, Integer> map = new HashMap<>(len);
        for (int i = 0; i < len; i++) {
            char c = secret.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        int correctCount = 0;
        for (int i = 0; i < len; i++) {
            char c1 = guess.charAt(i);
            char c2 = secret.charAt(i);
            if (c1 == c2) {
                correctCount++;
                map.put(c1, map.get(c1) - 1);
            }
        }
        int indexErrorCount = 0;
        for (int i = 0; i < len; i++) {
            char c1 = guess.charAt(i);
            char c2 = secret.charAt(i);
            if (c1 != c2 && map.containsKey(c1) && map.get(c1) > 0) {
                indexErrorCount++;
                map.put(c1, map.get(c1) - 1);
            }
        }
        StringBuilder s = new StringBuilder();
        s.append(correctCount).append("A").append(indexErrorCount).append("B");
        return s.toString();
    }

    public static void main(String[] args) {
        GetHint getHint = new GetHint();
        System.out.println(getHint.getHint("1122", "1222"));
    }
}
