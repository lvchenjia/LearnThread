package com.thyme;

public class Race implements Runnable{

    private static String winner;

    @Override
    public void run() {
        for (int i = 0; i <= 30; i++) {
            System.out.println(Thread.currentThread().getName()+"跑了"+i+"步");
            if(isFinished(i))break;
        }
    }

    private boolean isFinished(int step){
        if(winner!=null)return true;
        if(step>=30){
            winner = Thread.currentThread().getName();
            System.out.println("Winner is "+winner);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Race race = new Race();
        new Thread(race,"乌龟").start();
        new Thread(race,"兔子").start();

    }
}
