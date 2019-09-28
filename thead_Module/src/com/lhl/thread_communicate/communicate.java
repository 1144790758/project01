package com.lhl.thread_communicate;

/**
 *
 * 使用notify() 唤醒 被wait()阻塞的线程
 * 使用notifyAll() 唤醒所以被阻塞的线程
 * 使用wait() 阻塞当前线程会释放当前线程持有的锁
 * 但是只能用在synchronize 方法或者synchronize块中
 * notify,notifyAll(),wait() 的调用者只能是同步监视器
 * Object obj=new Object() 可以使用obj作为同步监视器
 *
 * @athor:lhl
 * @create:2019-07-19 1:50
 */
public class communicate {

    public static void main(String[] args) {
        Number n=new Number();
        Thread t1=new Thread(n,"线程1");
        Thread t2 =new Thread(n,"线程2");

        t1.start();
        t2.start();


    }
}

class Number implements Runnable{
    private int number=0;
//    Object obj=new Object();

    @Override
    public void run() {
        while (true){

//          synchronized (obj) {
            synchronized (this) {
//                  obj.notify();
                this.notify();
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if(number<=100){

                    System.out.println(Thread.currentThread().getName()+" : "+number);
                    number++;

                    try {
                        this.wait();

//                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                else{
                    break;
                }
            }


        }
    }
}