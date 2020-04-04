package lesson2;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

public class ThreadYield {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }).start();
        //等待new Thread线程执行完毕，否则一直等待
        while(Thread.activeCount() > 1){
            Thread.yield();//将当前线程由运行态->就绪态
        }
        System.out.println(Thread.currentThread().getName());
    }
}
