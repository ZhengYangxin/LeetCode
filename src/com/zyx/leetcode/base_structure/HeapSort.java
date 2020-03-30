package com.zyx.leetcode.base_structure;

import java.util.Arrays;
import java.util.PriorityQueue;

public class HeapSort {
    private PriorityQueue<Integer> queue = new PriorityQueue();

    public void sort(Integer[] nums) {
        queue.addAll(Arrays.asList(nums));
    }

    public int pop() {
        return queue.isEmpty() ? -1 : queue.poll();
    }

    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();
        Integer[] nums = new Integer[]{1,3,2,1,4,56,3,2};
        heapSort.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            System.out.println("heapSort.pop() = " + heapSort.pop());
        }
    }
}
