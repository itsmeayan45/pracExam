class A
{
    void show()
    {
        System.out.println("Showing from class A");
    }
}
class B extends A
{
    @Override
    void show()
    {
        System.out.println("Showing from class B");
    }
}
class C extends A
{
    @Override
    void show()
    {
        System.out.println("Showing from class C");
    }
}
class D extends A
{
    @Override
    void show()
    {
        System.out.println("Showing from class D");
    }
}
public class OverrideMethod {
    public static void main(String[] args) {
        A a=new A();
        a.show();
        B b =new B();
        b.show();
        C c=new C();
        c.show();
        D d =new D();
        d.show();
    }
    
}
