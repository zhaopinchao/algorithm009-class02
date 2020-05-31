import com.sun.tools.jdi.IntegerValueImpl;

import java.util.*;

/**
 * @author: zhaopc@tuya.com
 * @date: 2020-05-30 21:00
 * @description N叉树前序遍历
 */
public class Npreorder {

    /**
     * 递归
     *
     * @param root
     * @return
     */
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, res);
        return res;
    }

    private void dfs(Node node, List<Integer> res) {
        if (node == null) {
            return;
        }
        res.add(node.val);
        for (Node child : node.children) {
            dfs(child, res);
        }
    }

    /**
     * 栈
     *
     * @param root
     * @return
     */
    public List<Integer> preorder1(Node root) {
        LinkedList<Node> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null) {
            return output;
        }

        stack.add(root);
        while (!stack.isEmpty()) {
            Node node = stack.pollLast();
            output.add(node.val);
            Collections.reverse(node.children);
            for (Node item : node.children) {
                stack.add(item);
            }
        }
        return output;
    }

    /**
     * 栈
     *
     * @param root
     * @return
     */
    public List<Integer> preorder2(Node root) {
        Deque<Node> stack = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();

        stack.add(root);

        while (!stack.isEmpty()) {
            root = stack.pop();
            res.add(root.val);
            for (int i = root.children.size() - 1; i > 0; i--) {
                stack.addFirst(root.children.get(i));
            }
        }
        return res;
    }
}
