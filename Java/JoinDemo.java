class Mythread extends Thread{
    Mythread(String msg)
    {
        super(msg);
        System.out.println("Thread created: "+getName());
    }
    public void run()
    {
        try{
            for(int i=0;i<5;i++)
            {
                System.out.println(getName()+"is running-->"+i);
                Thread.sleep(1000);
            }
        }catch(InterruptedException e)
        {
            System.out.println("Interrupted "+getName()+" exception");
        }
        System.out.println(getName()+" Thread executed");
    }
}
public class JoinDemo {
    public static void main(String[] args) {
        Mythread t1=new Mythread("Thread-1");
        Mythread t2=new Mythread("Thread-2");
        t1.start();
        t2.start();
        System.out.println("t1 alive? "+t1.isAlive());
        System.out.println("t2 alive? "+t2.isAlive());
        try{
            t1.join();
            System.out.println("main thread resumed after t1 completion");

            t2.join();
            System.out.println("main thread resumed after t2 completion");
        }catch(InterruptedException e)
        {
            System.out.println("Main Thread Interrupted");
        }
        System.out.println("t1 alive after completion: " + t1.isAlive());
        System.out.println("t2 alive after completion: " + t2.isAlive());

        System.out.println("Main thread exiting");
        
    }
    
}
