class WordDictionary {
    private static Node root;

    public WordDictionary() {
        root=new Node();
    }

    public void addWord(String word) {
        Node node=root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (!node.containsKey(ch)) {
                node.put(ch, new Node());
            }

            node = node.get(ch);
        }

        node.setEnd();
    }

    public boolean search(String word) {
        return searchHelper(word, 0, root);
    }

    private boolean searchHelper(String word, int index, Node node){
        if(node==null)
        return false;

        if(index==word.length()){
            return node.isEnd();
        }

        char ch=word.charAt(index);

        if(ch!='.'){
            if(!node.containsKey(ch))
            return false;

            return searchHelper(word, index+1, node.get(ch));
        }

        // ch == '.', try every possible child
        for (int i = 0; i < 26; i++) {
            Node child = node.getChild(i);

            if (child != null && searchHelper(word, index + 1, child)) {
                return true;
            }
        }

        return false;

    }
}

class Node{
    private Node[] links=new Node[26];
    private boolean flag=false;

    public boolean containsKey(char ch){
        return links[ch-'a']!=null;
    }

    public void put(char ch, Node node){
        links[ch-'a']=node;
    }

    public Node get(char ch) {
        return links[ch - 'a'];
    }

    public Node getChild(int index) {
        return links[index];
    }

    public void setEnd() {
        flag = true;
    }

    public boolean isEnd() {
        return flag;
    }
}
