package PoolThread;

import java.util.concurrent.TimeUnit;

public class MyTask implements Runnable {
	private String name;
	 
    public MyTask(String name) {
        this.name = name;
    }
 
    public String getName() {
        return name;
    }
 
    public void run() {
        try {
            Long duration = (long) (Math.random() * 10);
            System.out.println("Running --> " + name);
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
}
}
