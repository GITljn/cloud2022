package com.bjpowernode.customhystrix.model;

import lombok.Data;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Data
public class CustomHystrix {
    public static final Integer TIME_WINDOW = 20;
    public static final Integer MAX_FAIL_TIME = 3;
    public static ThreadPoolExecutor executor = new ThreadPoolExecutor(
            5,10, 30, TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(10),
            Executors.defaultThreadFactory(),
            new ThreadPoolExecutor.AbortPolicy()
    );
    private AtomicInteger curFailTime = new AtomicInteger(0);
    private HystrixStatus hystrixStatus = HystrixStatus.CLOSE;
    private final Object lock = new Object();
    // 构造代码块，在对象创建的时候执行
    {
        executor.execute(()->{
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(TIME_WINDOW);
                    if (hystrixStatus.equals(HystrixStatus.CLOSE)) {
                        curFailTime.set(0);
                    } else {
                        synchronized (lock) {
                            lock.wait();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void addFailTime() {
        int i = curFailTime.incrementAndGet();
        if (i >= MAX_FAIL_TIME) {
            hystrixStatus = HystrixStatus.OPEN;
            executor.execute(()->{
                try {
                    TimeUnit.SECONDS.sleep(TIME_WINDOW);
                    hystrixStatus = HystrixStatus.HALF_OPEN;
                    curFailTime.set(0);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
