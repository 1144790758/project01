package thread01;

public class t02 {
    public static void main(String[] args) {

        Cinema02 cinema = new Cinema02();

        Person02 lee = new Person02("lee", 10, cinema);
        Person02 jack = new Person02("jack", 20, cinema);

        new Thread(lee, "lee").start();
        new Thread(jack, "jack").start();
    }
}


class Cinema02 {

    int rest = 10;
    Person p;

//    public Cinema(Person p) {
//        this.p=p;
//    }


}

class Person02 implements Runnable {

    String name;
    int tickts;
    Cinema02 cinema;

    public Person02(String name, int tickts, Cinema02 cinema) {
        this.name = name;
        this.tickts = tickts;
        this.cinema = cinema;
    }

    @Override
    public void run() {
        try {
            get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void get() throws InterruptedException {
        for (int i = 0; i < tickts; i++) {

                if(cinema.rest<=0){
                    System.out.println("票数为 ：" + cinema.rest + "抢票失败" + "  " + Thread.currentThread().getName());
                    return;
                }

                synchronized (cinema){
                    if(cinema.rest<=0){
                        System.out.println("票数为 ：" + cinema.rest + "抢票失败" + "  " + Thread.currentThread().getName());
                        return;
                    }
                }
                if (cinema.rest > 0) {
                    System.out.println("剩余票数 ：" + cinema.rest);

//                    cinema.rest = cinema.rest - 1;
                    System.out.println("抢票成功,抢到第几张票 -->" + cinema.rest-- + "  " + Thread.currentThread().getName());

                Thread.sleep(200);
            }
        }

    }
}
