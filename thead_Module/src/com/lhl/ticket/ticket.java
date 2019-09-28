package com.lhl.ticket;

/**
 * @athor:lhl
 * @create:2019-07-16 23:17
 */
public class ticket {

    public static void main(String[] args) {
        TicketWindows ticket_windows=new TicketWindows();

        Thread t1=new Thread(ticket_windows,"t1线程");
        Thread t2=new Thread(ticket_windows,"t2线程");
        Thread t3=new Thread(ticket_windows,"t3线程");
        t1.start();
        t2.start();
        t3.start();
    }




}

class TicketWindows implements Runnable{
    int ticket_number=100;
    Object obj=new Object();


    @Override
    public void run() {
        while (true){
            //synchronized理论上用任何对象都可以,隐藏条件是多个线程
            //共用一把锁
            synchronized (this){
                //this是动态获取的,哪个对象调用的此方法,获取的就是哪个对象
                //此时是ticket_windows调用的run()方法
                // synchronized(obj){

                if(ticket_number>0){
                    System.out.println("当前窗口"+Thread.currentThread().getName()+"  "+ticket_number);
                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    ticket_number=ticket_number-1;
                }else {
                    System.out.println("没有票了~~");
                    break;
                }
            }

        }
    }
}
