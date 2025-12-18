class Person
{
    Person()
    {
        System.out.println("Person Constructor Called");
    }
    void role()
    {
        System.out.println("Person has a role");
    }
}
class Employee extends Person
{
    Employee()
    {
        super();
        System.out.println("Employee Constructor called");
    }
    void role()
    {
        super.role();
        System.out.println("Employee has a role");
    }
}
class Manager extends Employee
{
    Manager()
    {
        super();
        System.out.println("Manager constructor called");
    }
    void role()
    {
        super.role();
        System.out.println("Manager has a role");
    }
}
public class MultilevelInheritence {
public static void main(String[] args) {
    Manager m =new Manager();
    m.role();
}
    
}
