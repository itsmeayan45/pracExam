
class Printer
{
    synchronized void Printing(String user)
    {
        try{
        System.out.println("Printing started for: "+user);
        for(int i=1;i<=5;i++)
            {
            System.out.println("printing "+i+"th page of "+user);
            Thread.sleep(500);
            }
        System.out.println("Printing completed for "+user);
        System.out.println("\n");
        }catch(InterruptedException e)
        {
            System.out.println("Printing is interrupted");
        }
    }

}
class User extends Thread
{
    Printer printer;
    String userName;
    User(Printer printer,String userName)
    {
        this.printer=printer;
        this.userName=userName;
    }
    public void run()
    {
        printer.Printing(userName);
    }

} 
public class SynchronizedDemo {
    public static void main(String[] args) {
        Printer printer=new Printer();
        User u1=new User(printer,"user-1");
        User u2=new User(printer,"user-2");
        User u3=new User(printer,"user-3");
        u1.start();
        u2.start();
        u3.start();
        
    }
    
}
