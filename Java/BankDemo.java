class MyException extends Exception
{
    MyException(String msg)
    {
        super(msg);
    }
}
class BankAc {
    double balance;
    BankAc(double balance)
    {
        this.balance=balance;
    }
   void withdraw(double amount) throws MyException
   {
    if(balance-amount<1000)
    {
        throw new MyException("Invalid balance");
    }
    balance-=amount;
    System.out.println("Withdrawl successfull.balance is"+balance);
   }
    
}
public class BankDemo {
    public static void main(String[] args) {

        BankAc account = new BankAc(5000);

        try {
            account.withdraw(4500);   // Causes balance < 1000
        } catch (MyException e) {
            System.out.println("Exception caught in main(): " + e.getMessage());
        }

        System.out.println("Program continues...");
    }
}
