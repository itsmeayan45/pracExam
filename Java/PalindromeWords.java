import java.util.Scanner;
public class PalindromeWords {
    static boolean isPalindrome(String word)
    {
        int left=0;
        int right=word.length()-1;
        while(left<right)
        {
            if(word.charAt(left)!=word.charAt(right))
            {
                return false;
            }
            left++;
            right--;
            
        }
        return true;

    }
    public static void main(String[] args) {
        System.out.println("enter a sentence: ");
        Scanner sc=new Scanner(System.in);
        String sentence=sc.nextLine();
        sentence=sentence.toUpperCase();
        String[] words=sentence.split("\\s+");
        System.out.println("Palindrome words are: ");
        for(String word:words)
            {
                if(word.length()>1 && isPalindrome(word))
                {
                    System.out.println(word);
                }
            }
            sc.close();        
    }

    
}
