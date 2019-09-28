package com.lhl.ticket;

/**
 * 使用同步机制将单一设计模式,设计为线程安全
 * @athor:lhl
 * @create:2019-07-17 1:17
 */
public class SingletonDesignPatterns {
}


class Bank{

    //私有化构造器
    private Bank(){

    }

    private static Bank instance=null;

    public static Bank getInstance(){
        //方式一
        //效率较差
//        synchronized (Bank.class) {
//            if(instance==null){
//                instance=new Bank();
//            }
//            return instance;
//        }

        //方式二
        if(instance==null){
            synchronized (Bank.class) {
                if (instance == null) {
                    instance = new Bank();
                }
            }
        }
        return instance;
    }
}