public class CatchMultipleException {
    public static void main(String[] args) {
        try
        {
            int[] arr={2,3,4,5};
            System.out.println(arr[4]);
            
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            System.out.println("Array index is out of bound "+e);
        }
        try
        {
            String x="Hello sir i am here";
            System.out.println(x.charAt(100));
        }catch (StringIndexOutOfBoundsException e)
        {
            System.out.println("String index is out of bound "+e);
        }
        try
        {
            int b=10/0;
            System.out.println(b);
        }catch(ArithmeticException e)
        {
            System.out.println("Arithmetic exception happened "+e);
        }
        System.out.println("Program Executed Successfully");

    }
    
}
