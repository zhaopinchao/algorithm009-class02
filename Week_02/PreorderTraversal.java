import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author: zhaopc@tuya.com
 * @date: 2020-05-30 22:02
 * @description
 */
public class PreorderTraversal {

    /**
     * 递归
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<Integer> result = new ArrayList<>();
        dfs(root, result);
        return result;
    }

    private void dfs(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        result.add(node.val);
        dfs(node.left, result);
        dfs(node.right, result);
    }
}
