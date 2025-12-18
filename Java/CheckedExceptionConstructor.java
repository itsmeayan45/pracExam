class Manual extends Exception
{
    Manual(String msg)
    {
        super(msg);
    }
}
class Student 
{
    int age;
    Student(int age) throws Manual
    {
        if(age<18)
        {
            throw new Manual("Age is less than 18");
        }
        this.age=age;
        System.out.println("Student object created successfully");
    }
}
public class CheckedExceptionConstructor {
    public static void main(String[] args) {
        try
        {
            Student s=new Student(15);
            
        } catch(Manual e)
        {
            System.out.println("Exception handled from main()");
            System.out.println(e.getMessage());
        }
        System.out.println("Program Continues");
    }
}
