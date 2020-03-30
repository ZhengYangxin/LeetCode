package com.zyx.leetcode;

import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadTest {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        long start = System.currentTimeMillis();
        for (int i = 0; i < 2000; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    excution(new Random().nextInt(20000), "20180110");
                }
            });
        }

    }

    private static void excution(int ints, String s) {
        System.out.println("ints = " + ints);

    }
}
