package com.zyx.leetcode.question0703_kth_largest;

import java.util.PriorityQueue;

public class KthLargest {
    private PriorityQueue<Integer> priorityQueue;
    private int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        priorityQueue = new PriorityQueue<>(k);
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        if (priorityQueue.size() < k) {
            priorityQueue.offer(val);
        } else if (priorityQueue.peek() < val){
                priorityQueue.poll();
                priorityQueue.offer(val);
        }
        return priorityQueue.peek();
    }
}
