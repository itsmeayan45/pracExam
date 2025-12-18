import java.util.Scanner;
class LimitedException extends Exception
{
    LimitedException(String msg)
    {
        super(msg);
    }
}
public class AgeLimitExcepion {
    static void checkException(int age) throws LimitedException
    {
        if(age<18||age>60)
        {
            throw new LimitedException("Age is not within 18-60");
        }
        System.out.println("Age is Valid");
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a age: ");
        int age=sc.nextInt();
        try
        {
            checkException(age);
        }catch(LimitedException e)
        {
            System.out.println(e);
        }

    }
}
