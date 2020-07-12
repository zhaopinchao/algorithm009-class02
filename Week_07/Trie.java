/**
 * @author: zhaopc
 * @date: 2020-07-05 22:04
 * @description
 */
public class Trie {
    private TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new TrieNode().root();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!node.containsKey(c)) {
                node.put(c);
            }
            node = node.get(c);
        }
        node.isEnd = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }

    private TrieNode searchPrefix(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!node.containsKey(c)) {
                return null;
            }
            node = node.get(c);
        }
        return node;
    }

    private class TrieNode {
        //子节点
        private TrieNode[] link = new TrieNode[26];
        //是否是end
        private boolean isEnd;

        private TrieNode() {
        }

        private boolean containsKey(char c) {
            return link[c - 'a'] != null;
        }

        private TrieNode get(char c) {
            return link[c - 'a'];
        }

        private void put(char c) {
            link[c - 'a'] = new TrieNode();
        }

        private TrieNode root() {
            TrieNode trieNode = new TrieNode();
            trieNode.isEnd = true;
            return trieNode;
        }
    }
}

