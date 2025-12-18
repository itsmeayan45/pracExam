class Volume
{
    double volume;
    Volume(int side)
    {
        volume=side*side*side;
        System.out.println("volume of the cube is "+volume);
    }
    Volume(int radius,int height)
    {
        volume=(1.0/3)*Math.PI*radius*radius*height;
        System.out.println("Volume of the cone is "+volume);
    }
}
public class Box {
    public static void main(String[] args) {
        
    
    Volume cube=new Volume(2);
    Volume cone=new Volume(4,6);
    }
}
