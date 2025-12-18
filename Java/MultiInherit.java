class A{
    void show()
    {
        System.out.println("This is from Top level");
    }

}
class B extends A
{
    void show()
    {
        System.out.println("This is from the middle show");
    }
    void callSuperShow()
    {
        super.show();
    }
}
class C extends B
{
    void show()
    {
        System.out.println("This is from the lowest show");
    }
    void seeShow()
    {
        callSuperShow();;
    }
    void Bshow()
    {
        super.show();
    }
}
public class MultiInherit {
    public static void main(String[] args) {
        C c=new C();
        c.show();
        c.seeShow();
        c.Bshow();

    }
    
}
