class Animal
{
    void consume_food()
    {
        System.out.println("It consumes food");
    }

    void capable_of_motion()
    {
        System.out.println("It can walk and do motion");
    }
}
class Mamal extends Animal
{
    void hairs()
    {
        System.out.println("They have Long hairs");
    }
    void feeding()
    {
        System.out.println("They can feed their infants");
    }
    void can_crawl()
    {
        System.out.println("They can crawl");
    }
}
class Reptile extends Animal
{
    void have_scale()
    {
        System.out.println("They have scales");
    }
    void cold_blood()
    {
        System.out.println("They have cold blood");
    }
}
public class AnimalForest {
    public static void main(String[] args) {
        Mamal human=new Mamal();
        human.consume_food();
        human.can_crawl();
        human.capable_of_motion();
        human.hairs();
        human.feeding();
        Reptile snake=new Reptile();
        snake.consume_food();
        snake.capable_of_motion();
        snake.cold_blood();
        snake.have_scale();
        

    }
    
}
