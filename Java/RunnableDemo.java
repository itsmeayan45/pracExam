class MyRunnable implements Runnable
{
    MyRunnable()
    {
        System.out.println("Runnable Object Created");
    }
    public void run()
    {
        try
        {
            for(int i=0;i<5;i++)
            {
                System.out.println("Thread is Running..."+Thread.currentThread().getName());
                Thread.sleep(1000);
            }
        }catch(InterruptedException e)
        {
            System.out.println("Thread Interrupted");
        }
        System.out.println("Thread existting...");
        System.out.println(Thread.currentThread().getName());
    }
}
public class RunnableDemo {
    public static void main(String[] args) {
        System.out.println("Main thread started.."+Thread.currentThread().getName());
        MyRunnable r=new MyRunnable();
        Thread t=new Thread(r,"child Thread");
        t.start();
        try
        {
            for(int i=0;i<5;i++)
            {
                System.out.println("Thread is Running..."+Thread.currentThread().getName());
                Thread.sleep(1000);
            }
        }catch(InterruptedException e)
        {
            System.out.println("Thread Interrupted");
        }
        System.out.println("Thread existting...");
        System.out.println(Thread.currentThread().getName());

    }
    
}
