package com.lhl.Thread;

/**
 * @athor:lhl
 * @create:2019-07-13 13:28
 */
public class createThread {

    public static void main(String[] args) throws InterruptedException {

        //用匿名内部类创建一个线程
        new Thread(){
            @Override
            public void run() {
                for(int i=1;i<=100;i=i*2){
                    System.out.println(i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName());
                }
            }

        }.start();
        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName());

    }
}

