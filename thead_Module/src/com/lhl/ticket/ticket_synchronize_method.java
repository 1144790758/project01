package com.lhl.ticket;

/**
 * @athor:lhl
 * @create:2019-07-17 0:44
 */
public class ticket_synchronize_method {

    public static void main(String[] args) {
        TicketWindows02 ticket_windows = new TicketWindows02();

        Thread t1 = new Thread(ticket_windows, "t1线程");
        Thread t2 = new Thread(ticket_windows, "t2线程");
        Thread t3 = new Thread(ticket_windows, "t3线程");
        t1.start();
        t2.start();
        t3.start();
    }


}

class TicketWindows02 implements Runnable {
    int ticket_number = 100;
    Object obj = new Object();
    boolean flag=false;

    @Override
    public void run() {

        while (true) {

            if(flag){
                break;
            }
            getTicket();

        }
    }

    public synchronized void getTicket(){
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
