package com.lhl.thread.exercise;

/**
 * 实现消费者与生产者模式
 *
 * @athor:lhl
 * @create:2019-07-19 2:44
 * 消费者多线程,生产者多线程
 * 消费者共享资源
 * 生产者生产产品
 */
public class Customer_Producer {
    public static void main(String[] args) {

        production p = new production(0);

        //两生产者
        producer producer1 = new producer("生产者1", p);
        producer producer2 = new producer("生产者2", p);

        //4消费者
        customer c1 = new customer("消费者1", p);
        customer c2 = new customer("消费者2", p);
        customer c3 = new customer("消费者3", p);
        customer c4 = new customer("消费者4", p);

        producer1.start();
        producer2.start();

        c1.start();
        c2.start();
        c3.start();
        c4.start();
    }
}

class production {
    private int production_number;

     production(int production_number) {

        this.production_number = production_number;
    }

     void setProduction_number(int production_number) {

        this.production_number = production_number;
    }

     int getProduction_number() {
        return production_number;
    }
}

class producer extends Thread {
    production p;

    public producer(production p) {
        this.p = p;
    }

    public producer(String name, production p) {
        super(name);
        this.p = p;
    }

    @Override
    public void run() {
        while (true) {

            synchronized (p) {
                p.notifyAll();

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (p.getProduction_number() < 20) {
                    p.setProduction_number(p.getProduction_number() + 1);
                    System.out.println(getName() + "生产了商品,剩余商品 : " + p.getProduction_number());
                } else {
                    try {
                        p.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

class customer extends Thread {
    production p;

    public customer(production p) {
        this.p = p;
    }

    public customer(String name, production p) {
        super(name);
        this.p = p;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (p) {
                p.notifyAll();
                if (p.getProduction_number() > 0) {

                    p.setProduction_number(p.getProduction_number() - 1);
                    System.out.println(getName() + "正在消费,剩余产品数为 : " + p.getProduction_number());

                } else {
                    try {
                        p.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }


        }
    }
}