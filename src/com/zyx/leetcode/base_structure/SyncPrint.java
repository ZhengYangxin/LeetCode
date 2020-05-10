package com.zyx.leetcode.base_structure;

public class SyncPrint {
    public static void main(String[] args) {
        PrintThread a = new PrintThread(0, "A");
        PrintThread b = new PrintThread(1, "B");
        PrintThread c = new PrintThread(2, "C");
        a.start();
        b.start();
        c.start();
    }

}

class PrintThread extends Thread {

    int flag;
    String value;
    private static Object lock = new Object();
    private static int currentCount = 0;

    public PrintThread(int flag, String value) {
        this.flag = flag;
        this.value = value;
    }

    @Override
    public void run() {

        for (int i = 0; i < 10; i++) {
            synchronized (lock) {
                while (currentCount % 3 != flag) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println(value + " " + Thread.currentThread().getName());
                currentCount++;
                lock.notifyAll();
            }
        }
    }
}
