import java.util.HashMap;
import java.util.Map;

/* Node of Doubly Linked List */
class Node {
    int key, value, cnt;
    Node next;
    Node prev;

    Node(int _key, int _value) {
        key = _key;
        value = _value;
        cnt = 1; // frequency starts from 1
    }
}

/* Doubly Linked List for each frequency */
class DoublyLinkedList {
    int size;
    Node head;
    Node tail;

    DoublyLinkedList() {
        head = new Node(0, 0); // dummy head
        tail = new Node(0, 0); // dummy tail
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    // Add node right after head
    void addFront(Node node) {
        Node temp = head.next;
        node.next = temp;
        node.prev = head;
        head.next = node;
        temp.prev = node;
        size++;
    }

    // Remove given node
    void removeNode(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
        size--;
    }
}

/* LFU Cache Implementation */
class LFUCache {

    private Map<Integer, Node> keyNode;
    private Map<Integer, DoublyLinkedList> freqListMap;
    private int maxSizeCache;
    private int minFreq;
    private int curSize;

    public LFUCache(int capacity) {
        maxSizeCache = capacity;
        minFreq = 0;
        curSize = 0;
        keyNode = new HashMap<>();
        freqListMap = new HashMap<>();
    }

    // Update frequency of a node
    private void updateFreqListMap(Node node) {

        keyNode.remove(node.key);

        DoublyLinkedList oldList = freqListMap.get(node.cnt);
        oldList.removeNode(node);

        // If this was the last node of min frequency
        if (node.cnt == minFreq && oldList.size == 0) {
            minFreq++;
        }

        node.cnt++;

        DoublyLinkedList newList =
                freqListMap.getOrDefault(node.cnt, new DoublyLinkedList());

        newList.addFront(node);
        freqListMap.put(node.cnt, newList);
        keyNode.put(node.key, node);
    }

    public int get(int key) {
        if (!keyNode.containsKey(key))
            return -1;

        Node node = keyNode.get(key);
        int val = node.value;
        updateFreqListMap(node);
        return val;
    }

    public void put(int key, int value) {

        if (maxSizeCache == 0)
            return;

        if (keyNode.containsKey(key)) {
            Node node = keyNode.get(key);
            node.value = value;
            updateFreqListMap(node);
        } else {

            if (curSize == maxSizeCache) {
                DoublyLinkedList minFreqList = freqListMap.get(minFreq);
                Node nodeToRemove = minFreqList.tail.prev;

                minFreqList.removeNode(nodeToRemove);
                keyNode.remove(nodeToRemove.key);
                curSize--;
            }

            curSize++;
            minFreq = 1;

            Node newNode = new Node(key, value);
            DoublyLinkedList list =
                    freqListMap.getOrDefault(minFreq, new DoublyLinkedList());

            list.addFront(newNode);
            freqListMap.put(minFreq, list);
            keyNode.put(key, newNode);
        }
    }

    // Driver code
    public static void main(String[] args) {

        LFUCache cache = new LFUCache(2);

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.print(cache.get(1) + " "); // 1

        cache.put(3, 3);
        System.out.print(cache.get(2) + " "); // -1
        System.out.print(cache.get(3) + " "); // 3

        cache.put(4, 4);
        System.out.print(cache.get(1) + " "); // -1
        System.out.print(cache.get(3) + " "); // 3
        System.out.print(cache.get(4) + " "); // 4
    }
}