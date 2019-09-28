package thread01;

public class t01 {


    public static void main(String[] args) {

        Cinema cinema = new Cinema();

        Person lee = new Person("lee", 3, cinema);
        Person jack = new Person("jack", 4, cinema);

        new Thread(lee,"lee").start();
        new Thread(jack,"jack").start();

    }
}


class Cinema  {


    int rest=10;
    Person p;

//    public Cinema(Person p) {
//        this.p=p;
//    }


}

class Person implements Runnable{


    String name;
    int tickts;
    Cinema cinema;

    public Person(String name,int tickts,Cinema cinema) {
        this.name=name;
        this.tickts=tickts;
        this.cinema=cinema;
    }

    @Override
    public void run() {
        try {
            get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public  void get() throws InterruptedException {
        for(int i=0;i<tickts;i++){

            synchronized (cinema){

                int num=cinema.rest;
                if(num>0) {
                    System.out.println("剩余票数 ：" + num);

                    cinema.rest = cinema.rest - 1;
                    System.out.println("抢票成功,抢到第几张票 -->" + num + "  " + Thread.currentThread().getName());

                }
                else
                {
                    System.out.println("票数为 ："+ num+"抢票失败"+"  "+ Thread.currentThread().getName());
                }
                Thread.sleep(200);
            }
        }

    }
}