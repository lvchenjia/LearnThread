package com.thyme;

public class TestJoin implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("Senior:"+i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TestJoin testJoin = new TestJoin();
        Thread thread = new Thread(testJoin);
        thread.setPriority(10);
        thread.start();

        for (int i = 0; i < 1000; i++) {
            if(i==200){
              thread.join();
            }
            System.out.println("h"+i);
        }
    }
}
