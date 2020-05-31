学习笔记



### 1、哈希表、映射、集合

哈希表（Hash table）， 也叫散列表，是根据关键码值（key value）而直接进行访问的数据结构。

它通过把关键码值映射到表中一个位置来访问记录，以加快查找的速度。

这个映射函数叫做散列函数（Hash Function），存放记录的数组叫做哈希表（或散列表）。

### 2、树、二叉树、二叉搜索树

#### 树

```
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
```



#### 二叉树

```
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
//前序遍历
dfs(TreeNode node) {
		if (node == null) {
				return;
		}
		node.val;
		dfs(node.left);
		dfs(node.right);
}
//中序遍历
dfs(TreeNode node) {
		if (node == null) {
				return;
		}
		dfs(node.left);
		node.val;
		dfs(node.right);
}
//后序遍历
dfs(TreeNode node) {
		if (node == null) {
				return;
		}
		dfs(node.left);
		dfs(node.right);
		node.val;
}
```

二叉树遍历方式分为前序遍历（Pre-order 根左右），中序遍历（In-order 左根右），后续遍历（Post-order 左右根）

#### 二叉搜索树 Binary Search Tree

二叉搜索树是一个有序的二叉树， 也称二叉排序树，有序二叉树（Ordered Binary Tree）、排序二叉树（Sorted Binary Tree），是指一棵空树或者具有下列性质的二叉树：

1. 左子树上**所有节点**的值均小于他的根节点的值
2. 右子树上**所有节点**的值均大于它的根节点的值
3. 以此类推：左、右子树也分别为二叉搜索树（重复性！）

对于二叉搜索树中序遍历右叫升序排列

二叉搜索树在删除元素时，如果是叶子节点，那么直接删除即可，如果是根节点，那么将最近的大于改节点的节点替换上来。

### 3、堆、二叉堆、图

#### 堆 heap

Heap: 可以驯熟找到一堆数中的最大或者最小值的数据结构

将根节点最大的堆叫做大顶堆或者大根堆，根节点最小的堆叫做小顶堆或小根堆。常见的堆有二叉堆，斐波那契堆等。

假设是大顶堆，则常见操作（Api）：

find-max： O(1)

delete-mas： O(logn)

insert（create）：O(logN) or O(1)

不同实现的比较： [维基百科：堆（Heap）](https://en.wikipedia.org/wiki/Heap_(data_structure) )

#### 二叉堆

通过完全二叉树来实现 （注意：不是二叉搜索树）；

二叉堆（大顶）它满足下列性质：

1、 是一一颗完全树

2、树中任一节点的值总是>=其子节点的值；

### 4、图

图的属性

- Graph(V, E)
- V - vertex： 点

  - 度- 入度和初度
  - 点与点之间：连通与否
- E-edge： 边
  - 有向和无向（单行线）
  - 权重（边长）

图的遍历，递归写法：

```
visited = set(); //和树中的dfs最大的区别
def dfs(node, visited):
		if node in visited: # terminator
			return
		visited.add(node)
		
	for next_node in node.children():
		if not next_node in visited:
			dfs(next_node, visited)
			
其中最关键的是visited数组，表示已读的节点，因为图是有连通性的，会形成环路
图可以分为多种： 有权无权，有向无向
```

### Java HashMap

- hash表，内部使用数组+链表的方式存储数据（链表在特定的情况下会转换成红黑树， 红黑树在特定的情况下会转换成链表）
- hashMap初始化时，默认数组长度为16，最大容量1<<32，当hash表中数据大于等于， 容量扩充规则为当前容量的一倍，当数据size到达 curr_capacity*负载因子时（默认的负载因子为0.75）， hash表插入元素时，每次都会检查数组容量（resize方法），达到条件时，就会进行扩容；
- 插入元素，当hash表key产生冲突时，冲突的元素未链接在该冲突的节点上，如果该节点冲突的元素达到8个时，会将该链表转换成红黑树。 在remove元素时，如果链表的数据到达6个时，红黑树会转换成链表
- get元素时，首先通过hash方法得到key的hash值（也就是hash表内部数组的下标地址），首先将元素取出来（hash表内部定义的Node类），然后equals key是否为true，如果为true，则该元素是目标元素，如果为false，说明该节点有key冲突，需遍历链表或者从红黑树中查找目标元素

