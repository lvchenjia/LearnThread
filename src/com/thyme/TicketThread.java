package com.thyme;

public class TicketThread implements Runnable{

    private static Integer ticket = 10;

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (ticket){
                if(ticket<=0)break;

                System.out.println(Thread.currentThread().getName()+" get the "+ticket--+" ticket");
            }

        }
    }

    public static void main(String[] args) {
        TicketThread ticketThread = new TicketThread();
        new Thread(ticketThread, "A").start();
        new Thread(ticketThread, "B").start();
        new Thread(ticketThread, "C").start();

    }

}
