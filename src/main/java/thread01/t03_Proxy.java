package thread01;

/**
 * 要想实现自定义Thread 对象代理 在构造器中必须要有加上 super.(target)
 * 不然就跟没有传入Runnable 一样了
 */

public class t03_Proxy {
    public static void main(String[] args) throws InterruptedException {

        Web web=new Web(10,"abc");

        Passenger p1=new Passenger(2,"p1",web);
        Passenger p2=new Passenger(8,"p2",web);
        p1.start();
        p2.start();

    }
}


class Web implements Runnable{

    int seats;
    String name;

    public Web(int seats,String name ) {

        this.seats=seats;
        this.name=name;
    }

    @Override
    public void run() {
        getTickit();
    }

    synchronized void getTickit(){

         Passenger passenger = (Passenger) Thread.currentThread();

        if(passenger.tickits<=seats){

            this.seats-=passenger.tickits;
            System.out.println("抢票成功" +  "  " + Thread.currentThread().getName());

        }else{
            System.out.println("抢票失败" +  "  " + Thread.currentThread().getName());
        }

    }

}

class Passenger extends Thread{
    int tickits;
    String name;
    Runnable target;

    public Passenger(int tickits, String name,Runnable target) {
        super(target,name);
        this.tickits = tickits;
        this.name = name;
        this.target=target;
    }
}