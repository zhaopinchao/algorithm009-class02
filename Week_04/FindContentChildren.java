import java.util.Arrays;

/**
 * @author: zhaopc@tuya.com
 * @date: 2020-06-14 17:58
 * @description 分发饼干
 */
public class FindContentChildren {

    public int findContentChildren(int[] g, int[] s) {
        if (g.length == 0 || s.length == 0) {
            return 0;
        }
        Arrays.sort(g);
        Arrays.sort(s);
        int index = 0;
        int res = 0;
        for (int i = 0; i < s.length && index < g.length; i++) {
            if (s[i] >= g[index]) {
                res++;
                index++;
            }
        }
        return res;
    }
}
