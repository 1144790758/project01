package com.lhl.thread.exercise;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @athor:lhl
 * @create:2019-07-17 23:50
 *
 * 使用锁的方式考虑安全问题
 * 模拟存钱,每次存1000,甲乙两人共享一个账号
 */
public class AccountMoney {

    public static void main(String[] args) {
        Account acc=new Account(0);

        Person p1=new Person(acc);
        Person p2=new Person(acc);

        p1.setName("甲");
        p2.setName("乙");

        p1.start();
        p2.start();

    }
}


class Account{

    int balance;

    private ReentrantLock lock=new ReentrantLock();


    public Account(int balance) {
        this.balance = balance;
    }

    public void deposit(int cash){

        try {
            lock.lock();
            this.balance=balance+cash;

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName()+" :存钱成功,剩余余额为: "+balance);
        }finally {
            lock.unlock();
        }


    }
}

class Person extends Thread{
    //要对共享的账号进行操作
    Account acc;

    public Person(Account acc) {
        this.acc = acc;
    }

    @Override
    public void run() {

        for (int i = 0; i < 3; i++) {
            acc.deposit(1000);
        }

    }
}