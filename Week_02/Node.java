import java.util.List;

/**
 * @author: zhaopc@tuya.com
 * @date: 2020-05-30 20:59
 * @description
 */
class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}