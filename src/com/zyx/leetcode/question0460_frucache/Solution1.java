package com.zyx.leetcode.question0460_frucache;

import java.util.HashMap;
import java.util.Map;

public class Solution1 {
    class Node {
        int key;
        int value;
        int cnt;
        Node next;
        Node pre;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            cnt = 0;
        }
    }


    class DDList {
        Node head;
        Node tail;
        int len;

        public DDList() {
            this.head = new Node(0, 0);
            this.tail = new Node(0, 0);
            head.next = tail;
            tail.pre = head;
            len = 0;
        }

        public void addNode(Node node) {
            Node next = head.next;
            head.next = node;
            node.pre = head;

            node.next = next;
            next.pre = node;
            map.put(node.key, node);
            len++;
        }

        public void remove(Node node) {
            Node pre = node.pre;
            Node next = node.next;

            pre.next = next;
            next.pre = pre;
            map.remove(node.key);
            len--;
        }

        public void removeTail() {
            Node node = tail.pre;
            remove(node);
        }
    }

    Map<Integer, Node> map;
    Map<Integer, DDList> freq;
    int maxFreq;
    int capacity;
    int size;

    public Solution1(int capacity) {
        this.map = new HashMap<>();
        this.freq = new HashMap<>();
        maxFreq = 0;
        this.capacity = capacity;
        size = 0;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        Node node = map.get(key);
        int preFreq = node.cnt;
        DDList preDdList = freq.get(preFreq);

        preDdList.remove(node);

        int curFreq = preFreq + 1;
        maxFreq = Math.max(maxFreq, curFreq);

        DDList curDDList = freq.getOrDefault(curFreq, new DDList());
        node.cnt++;
        curDDList.addNode(node);
        freq.put(preFreq, preDdList);
        freq.put(curFreq, curDDList);
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }

        if (map.containsKey(key)) {
            map.get(key).value = value;
            get(key);
            return;
        }

        Node node = new Node(key, value);
        DDList currList = freq.getOrDefault(1, new DDList());
        currList.addNode(node);
        size++;
        if (size > capacity) {
            if (currList.len > 1) {
                currList.removeTail();
            } else {
                for (int i = 2; i <= maxFreq; i++) {
                    if (freq.get(i) != null && freq.get(i).len > 0) {
                        freq.get(i).removeTail();
                        break;
                    }
                }
            }
            size--;
        }
        freq.put(1, currList);
    }
}
