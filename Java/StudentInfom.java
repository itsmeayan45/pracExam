public class StudentInfom {
    public static void main(String[] args) {
        if(args.length<2)
        {
            System.out.println("Please provide two arguments");
        }
        String name=args[0];
        String college=args[1];
        System.out.println(name+" is a student of "+college);
    }
    
}
