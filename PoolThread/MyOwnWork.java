package PoolThread;

public class MyOwnWork {
	public static void main(String[] args) 
    {
        MyOwnThreadPool customThreadPool = new MyOwnThreadPool(2);
         
        for (int i = 1; i <= 5; i++) 
        {
            MyTask task = new MyTask("MyTask " + i);
            System.out.println("Started --> " + task.getName());
 
            customThreadPool.execute(task);
        }
        System.out.println();
    }
}
