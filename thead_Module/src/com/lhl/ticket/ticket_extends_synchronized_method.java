package com.lhl.ticket;

/**
 * @athor:lhl
 * @create:2019-07-17 0:58
 * 继承Thread的多线程共享的静态区的内容
 * 说以说 属性,方法 加个 static
 */
public class ticket_extends_synchronized_method {
    public static void main(String[] args) {
        TicketWindows03 t1=new TicketWindows03();
        TicketWindows03 t2=new TicketWindows03();
        TicketWindows03 t3=new TicketWindows03();
        t1.start();
        t2.start();
        t3.start();
    }

}

class TicketWindows03 extends Thread {
    static int ticket_number = 100;
    static boolean flag=false;

    @Override
    public void run() {

        while (true) {

            if(flag){
                break;
            }
            getTicket();

        }
    }

    //得是static  方法1
//    private static synchronized void getTicket(){
    private void getTicket(){
        //同步监视器 TicketWindows03.class 是惟一的
        //还可以这么写  方法2
        synchronized(TicketWindows03.class){

            if (ticket_number > 0) {
                System.out.println("当前窗口" +
                        Thread.currentThread().getName() +
                        "  " + ticket_number);
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ticket_number = ticket_number - 1;
            } else {
                System.out.println("没有票了~~");
                flag=true;
            }
        }
    }
}