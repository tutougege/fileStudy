package cn.tedu;

import javax.activation.MailcapCommandMap;
import java.security.PublicKey;

public class ThreadDemo  {
    public static void main(String[] args) {
        Thread t = new Thread();
        Thread t1 = new Thread(()->{
            //Runnable
            System.out.println("t1 start");
            synchronized (t){
                try {
                    System.out.println("t1 doSomething");
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("t1 over");
        });
        Thread t2 = new Thread(()->{
            System.out.println("t2 start");
            synchronized (t){
                try {
                    System.out.println("t2 doSomething");
                    Thread.sleep(5000);
                    System.out.println("t2 over");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        t2.start();
    }
}
