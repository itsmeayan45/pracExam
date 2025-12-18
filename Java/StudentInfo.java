class Subject{
    String title;
    int scoredMarks;
    int Passmarks;
    Subject(String title,int scoredMarks,int Passmarks)
    {
        this.title=title;
        this.scoredMarks=scoredMarks;
        this.Passmarks=Passmarks;
    }
    String getStatus()
    {
        if(scoredMarks>=Passmarks)
        {
            return "PASS";
        }
        else
        {
            return "FAIL";
        }
    }
}
class Student
{
    String name;
    Subject s1,s2,s3;
    Student(String name,Subject s1,Subject s2,Subject s3)
    {
        this.name=name;
        this.s1=s1;
        this.s2=s2;
        this.s3=s3;
    }
    void displayResult()
    {
        System.out.println("Student "+name+"\n");
        System.out.println(s1.title + " : " + s1.scoredMarks+" (" + s1.getStatus() + ")");
        System.out.println(s2.title + " : " + s2.scoredMarks +" (" + s2.getStatus() + ")");
        System.out.println(s3.title + " : " + s3.scoredMarks +" (" + s3.getStatus() + ")");
        int total=s1.scoredMarks+s2.scoredMarks+s3.scoredMarks;
        System.out.println("Total Marks= "+total);
    }
}
public class StudentInfo {
    public static void main(String[] args) {
        Subject m1=new Subject("Math",95,40);
        Subject p1=new Subject("Physics",85,40);
        Subject c1=new Subject("Chemistry",75,40);
        Student s1=new Student("Ayan", m1, p1, c1);

        Subject m2=new Subject("Math",45,40);
        Subject p2=new Subject("Physics",35,40);
        Subject c2=new Subject("Chemistry",25,40);
        Student s2=new Student("Jadeja", m2, p2, c2);

        Subject m3=new Subject("Math",95,40);
        Subject p3=new Subject("Physics",54,40);
        Subject c3=new Subject("Chemistry",40,40);
        Student s3=new Student("Sayan", m3, p3, c3);

        s1.displayResult();
        s2.displayResult();
        s3.displayResult();
        
    }
    
}
