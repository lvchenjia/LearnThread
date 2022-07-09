package com.thyme;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestSleep{
    public static void tenDown(){
        int n = 10;
        while (n>=0){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(n--);
        }
    }

    public static void main(String[] args) {
        Date date = new Date(System.currentTimeMillis());
        while (true){
            try {
                Thread.sleep(1000);
                System.out.println(new SimpleDateFormat("HH:mm:ss").format(date));
                date = new Date(System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
