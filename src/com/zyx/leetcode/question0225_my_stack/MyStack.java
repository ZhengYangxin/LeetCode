package com.zyx.leetcode.question0225_my_stack;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {

    private Queue<Integer> inQueue;
    private Queue<Integer> outQueue;

    public MyStack() {
        inQueue = new LinkedList<>();
        outQueue = new LinkedList<>();
    }

    public void push(int x) {
        inQueue.add(x);

        while (!outQueue.isEmpty()) {
            inQueue.add(outQueue.poll());
        }

        while (!inQueue.isEmpty()) {
            outQueue.add(inQueue.poll());
        }
    }

    public int pop() {
        return outQueue.poll();
    }

    public int top() {
        return outQueue.peek();
    }

    public boolean isEmpty() {
        return outQueue.isEmpty();
    }
}
