package com.thyme;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class MyThread extends Thread{

    private String url;
    private String name;

    public MyThread(String url, String name){
        this.url = url;
        this.name = name;
    }

    @Override
    public void run() {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(url, name);
        System.out.println("下载完成"+url);
    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread("https://img-blog.csdnimg.cn/20191013102908913.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NDAzNTAxNw==,size_16,color_FFFFFF,t_70", "1.jpg");
        myThread.start();
        for (int i = 0; i < 20; i++) {
            System.out.println("Main:"+i);
        }
    }
}

class WebDownloader{
    public void downloader(String url, String name){
        try {
            FileUtils.copyURLToFile(new URL(url), new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO异常，下载失败");
        }
    }
}
