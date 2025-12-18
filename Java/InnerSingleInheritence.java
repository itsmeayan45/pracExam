class SingleInheritence
{
    String name="Ayan";
    SingleInheritence()
    {
        System.out.println("Animal Constructor Called");
    }
    void bark()
    {
        System.out.println("Animal Barks");
    }

}
class Dog extends SingleInheritence
{
    Dog()
    {
        super();
        System.out.println("Dog Constructor called");
    }
    void bark()
    {
        super.bark();
        System.out.println("Dog barks");
    }
    
}
public class InnerSingleInheritence {
    public static void main(String[] args) {
        Dog d=new Dog();
        d.bark();
    }

    
}