import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author: zhaopc
 * @date: 2020-05-30 21:48
 * @description
 */
public class InorderTraversal {


    /**
     * 递归
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
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
        dfs(node.left, result);
        result.add(node.val);
        dfs(node.right, result);
    }
}
