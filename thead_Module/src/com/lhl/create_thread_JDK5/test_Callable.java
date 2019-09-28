package com.lhl.create_thread_JDK5;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 实现Callable接口创建线程
 * 与Runnable相比Callable重写call()方法
 *  call()可以抛出异常,可以有返回值,Callable 支持泛型
 * @athor:lhl
 * @create:2019-07-19 15:55
 */
public class test_Callable {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //创建实现Callable的实现对象
        Number n=new Number();

        //将Callable的实现对象放入FutureTask对象构造器中
        //FutureTask 实现了Runnable和Future接口
        FutureTask ft=new FutureTask(n);

        //这里用法与实现Runnable有相似之处
        Thread t1=new Thread(ft,"线程一");

        t1.start();

        //在主线程中还可以获取Callable的实现对象的Call()方法的返回值
        //利用FutureTask获取
        Object o = ft.get();
        System.out.println(o.toString());


    }
}

class Number implements Callable{

    int number=0;

    @Override
    public Integer call() throws InterruptedException {
        for (int i = 1; i <= 100 ; i++) {
                Thread.sleep(10);
                number++;
                System.out.println(Thread.currentThread().getName()+" : " +number);
                throw new NullPointerException("lalala");
        }

        return number;
    }
}
