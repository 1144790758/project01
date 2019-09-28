package com.lhl.create_thread_JDK5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 *
 * java5.0新增的创建线程方式
 * 所有的线程一开始被创建好放在线程池中,加快响应速度
 * 线程池中线程可以重复利用
 * 便于线程的管理
 *
 * ExecutorServer:真正的线程池接口,常用实现类ThreadPoolExecutor
 * 方法execute() 执行 适用于Runnable
 * 方法submit() 执行 适用于Callable (可以有返回值,值为Call()方法返回值)
 * shutdown() 关闭线程池
 *
 * Executors:线程池工厂,工具类,用于返回不同类型的线程池
 * @athor:lhl
 * @create:2019-07-25 20:56
 */
public class thread_pool {

    public static void main(String[] args) {
        //创建一个可重复用,固定数量的线程池
        //ExecutorService为接口,其中没有设置管理线程池的属性的方法
        //在其实现类ThreadPoolExecutor中有设置属性的方法
        ExecutorService service = Executors.newFixedThreadPool(10);

        //强转ThreadPoolExecutor,向下转
        ThreadPoolExecutor service_1=(ThreadPoolExecutor)service;

        //getClass(）返回Class类型的对象。ThreadPoolExecutor
//        System.out.println(service.getClass());

        //如果池中的实际线程数<corePoolSize,无论是否其中有空闲的线程，
        // 都会给新的任务产生新的线程
        //如果池中的线程数>corePoolSize and <maximumPoolSize,而又有空闲线程，
        // 就给新任务使用空闲线程，如没有空闲线程，则产生新线程
        //如果池中的线程数＝maximumPoolSize，则有空闲线程使用空闲线程，
        // 否则新任务放入workQueue。
        // （线程的空闲只有在workQueue中不再有任务时才成立）
//        service_1.setCorePoolSize();

        //设置线程池存活时间
//        service_1.setKeepAliveTime();

        //实例化对象
        Number_1 t1=new Number_1();
        Number_2 t2=new Number_2();

        service_1.execute(t1);//适用于Runnable
        service_1.submit(t2);//适用于Callable

        //线程池关闭
        service_1.shutdown();
    }
}

class Number_1 implements Runnable{

    int n=100;

    @Override
    public void run() {
        while (true){
            if(n<0){
                break;
            }
            if(n%2==0){
                System.out.println(Thread.currentThread().getName()+" : "+n);
            }
            n--;
        }

    }
}

class Number_2 implements Runnable{

    int n=100;

    @Override
    public void run() {
        while (true){
            if(n<0){
                break;
            }
            if(!(n%2==0)){
                System.out.println(Thread.currentThread().getName()+" : "+n);
            }

            n--;
        }

    }
}

