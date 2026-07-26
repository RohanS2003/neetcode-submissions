class Solution {

    private final int[] deltaRow = {-1, 0, 1, 0};
    private final int[] deltaCol = {0, 1, 0, -1};

    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();

        for (String word : words) {
            trie.insert(word);
        }

        List<String> result = new ArrayList<>();
        Node root = trie.root;

        int rows = board.length;
        int cols = board[0].length;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                dfs(board, r, c, root, result);
            }
        }

        return result;
    }

    private void dfs(char[][] board, int row, int col, Node node, List<String> result) {

        int rows = board.length;
        int cols = board[0].length;

        // boundary check
        if (row < 0 || row >= rows || col < 0 || col >= cols) {
            return;
        }

        char ch = board[row][col];

        // already visited
        if (ch == '#') {
            return;
        }

        // no matching prefix in trie
        if (!node.containsKey(ch)) {
            return;
        }

        // move in trie
        Node nextNode = node.get(ch);

        // found a word
        if (nextNode.word != null) {
            result.add(nextNode.word);

            // avoid duplicate answers
            nextNode.word = null;
        }

        // mark visited
        board[row][col] = '#';

        // explore 4 directions
        for (int dir = 0; dir < 4; dir++) {
            int newRow = row + deltaRow[dir];
            int newCol = col + deltaCol[dir];

            dfs(board, newRow, newCol, nextNode, result);
        }

        // backtrack
        board[row][col] = ch;
    }
}


class Trie {

    Node root;

    Trie() {
        root = new Node();
    }

    void insert(String word) {
        Node node = root;

        for (char ch : word.toCharArray()) {
            if (!node.containsKey(ch)) {
                node.put(ch, new Node());
            }

            node = node.get(ch);
        }

        node.word = word;
    }
}


class Node {

    Node[] links = new Node[26];

    String word;


    boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }


    void put(char ch, Node node) {
        links[ch - 'a'] = node;
    }


    Node get(char ch) {
        return links[ch - 'a'];
    }
}
