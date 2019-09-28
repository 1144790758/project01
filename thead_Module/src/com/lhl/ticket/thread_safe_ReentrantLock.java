package com.lhl.ticket;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @athor:lhl
 * @create:2019-07-17 23:09
 *
 * lock的方式可以变相理解为synchronized 中的同步监视器(其实不是)
 *
 * djk5.0后新增的线程安全解决办法
 * 1 创建一个ReentrantLock实例
 * 2 把问题代码放入try-finally中
 * 3 先上锁
 * 4 在finally中解锁
 *
 * synchronized 与 lock 的异同
 * 二者都是解决线程安全
 * lock 手动解锁上锁
 * synchronized 方法块是自动的上锁与解锁
 *
 */
public class thread_safe_ReentrantLock {

    public static void main(String[] args) {
        Windows1 w=new Windows1();
        Thread t1=new Thread(w,"窗口1");
        Thread t2=new Thread(w,"窗口2");
        Thread t3=new Thread(w,"窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}

class Windows1 implements Runnable{

    private int ticket=100;

    //fair 为是否进行公平竞争,默认false
    private ReentrantLock lock=new ReentrantLock(false);


    @Override
    public void run() {
        while (true){
                try {
                    lock.lock();
                    if(ticket>0){
                        System.out.println("当前窗口"+Thread.currentThread().getName()+"  "+ticket);
                        try {
                            Thread.sleep(20);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        ticket=ticket-1;
                    }else {
                        System.out.println("没有票了~~");
                        break;
                    }

                }finally {
                    lock.unlock();
                }

        }


    }
}