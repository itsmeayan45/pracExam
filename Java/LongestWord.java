import java.util.Scanner;
public class LongestWord {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a sentence: ");
        String sentence=sc.nextLine();
        String[] words=sentence.split("\\s+");
        String longestWord="";
        int maxLength=0;
        for(String word:words)
        {
            if(word.length()>maxLength)
            {
                maxLength=word.length();
                longestWord=word;

            }
        }
        System.out.println("The longest word is : "+longestWord);
        System.out.println("The length of the longest word is: "+maxLength);
        sc.close();
    }
    
}
