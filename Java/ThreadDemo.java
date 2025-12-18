class Mythread extends Thread
{
    Mythread(String name)
    {
        super(name);
        System.out.println("Thread object created "+getName());
    }
    public void run()
    {
        try
        {
            for(int i=0;i<=5;i++)
            {
                System.out.println("Running Thread..."+Thread.currentThread().getName());
                Thread.sleep(1000);
            }
        }catch(InterruptedException e)
        {
            System.out.println("Thread interrupted");
        }
        System.out.println("Thread exiting.."+getName());
    }
}
public class ThreadDemo {
    public static void main(String[] args) {
        System.out.println("Main thread started..."+Thread.currentThread().getName());
        Mythread t=new Mythread("Child-Thread");
        t.start();
        
        
            try{
                for(int i=0;i<=5;i++){
                System.out.println("Running Thread"+Thread.currentThread().getName());
                Thread.sleep(500);
                }
            }catch(InterruptedException e)
            {
                System.out.println("Thread interroupted");
            }
            System.out.println("Thread exitting..."+Thread.currentThread().getName());
    
        
    }
    
}
