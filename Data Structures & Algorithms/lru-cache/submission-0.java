class LRUCache {
    int capacity;
    Map<Integer, Node> map;

    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.capacity=capacity;
        this.map=new HashMap<>();

        //dummy nodes
        head=new Node(0,0);
        tail=new Node(0,0);

        head.next=tail;
        tail.prev=head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }

        Node node=map.get(key);

        //key is used move it front
        remove(node);
        insertAfterHead(node);

        return node.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node=map.get(key);

            node.val=value;

            remove(node);
            insertAfterHead(node);
        }else{
            Node node=new Node(key, value);

            map.put(key, node);
            insertAfterHead(node);

            if(map.size()>capacity){
                Node lru=tail.prev;

                remove(lru);
                map.remove(lru.key);
            }
        }
    }

    private void remove(Node node){
        Node before=node.prev;
        Node after=node.next;

        before.next=after;
        after.prev=before;
    }

    private void insertAfterHead(Node node){
        Node afterHead=head.next;

        head.next=node;
        node.prev=head;

        node.next=afterHead;
        afterHead.prev=node;
    }
}

class Node{
    //inbuilt doubly is not enough because list.remove(val)
    //searches first which takes O(n)
    int key;
    int val;
    Node prev;
    Node next;

    Node(int key, int val){
        this.key=key;
        this.val=val;
    }
}
