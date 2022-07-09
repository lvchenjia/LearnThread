package com.thyme;

import java.util.concurrent.locks.ReentrantLock;

public class TestLock implements Runnable{
    static int n=10;

    ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        lock.lock();
        while(n>0){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(n--);
        }
        lock.unlock();
    }

    public static void main(String[] args) {
        TestLock testLock = new TestLock();
        new Thread(testLock).start();
        new Thread(testLock).start();
        new Thread(testLock).start();
    }
}
