import java.util.Scanner;
class NoMatchExceptionDemo extends Exception
{
    NoMatchExceptionDemo(String msg)
    {
        super(msg);
    }
}
public class NoMatchException {
    static void checkString(String country) throws NoMatchExceptionDemo
    {
        if(!country.equals("India"))
        {
            throw new NoMatchExceptionDemo("This inputted string didnot matched with India");
        }
        System.out.println("String matched successfully");
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String ip=sc.nextLine();
        try
        {
            checkString(ip);
        }catch(NoMatchExceptionDemo e)
        {
            System.out.println(e);
        }
        sc.close();
    }
    
    
}
