 import java.util.Scanner;
 import java.util.HashMap;
 public class Morse
 {
    static String[] MorseArray={".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."}; 
    static HashMap<String ,Character> MorseMap=new HashMap<>();
    static void Buildmap()
    {
        for(int i=0;i<26;i++)
            {
                MorseMap.put(MorseArray[i],(char)('a'+i));
            }
    }
    static void MorsetoChar(String morse)
    {
        Buildmap();
        String[] MorseWord=morse.split("       ");
        for(String word:MorseWord)
        {
            String[] MorseChar=word.split("   ");
            for(String Char:MorseChar)
            {
                if(MorseMap.get(Char)==null)
                {
                    continue;
                }
                System.out.print(MorseMap.get(Char));
            }
            System.out.print(' ');
        }
    }
    static void ChartoMorse(String text)
    {
        for(char c:text.toCharArray())
        {
            if(c==' ')
            {
                System.out.print("       ");
            }
            else if(c!=' ' && !Character.isLetter(c))
            {
                continue;
            }
            else
            {
                System.out.print(MorseArray[Character.toLowerCase(c)-'a']+' ');
            }
        }
    }
    public static void main(String[] args)
    {
        System.out.println("How may We asist you today?");
        System.out.println("Choose 1 to Convert Morse code to text");
        System.out.println("Choose 2 to Convert text to Morse code");
        Scanner sc=new Scanner(System.in);
        if(sc.nextInt()==1)
        {
            System.out.println("Enter the Morse code to convert to text:");
            Scanner scan=new Scanner(System.in);
            String morse=scan.nextLine();
            MorsetoChar(morse);
        }
        else
        {
        System.out.println("Enter the text to convert to Morse code:");
        Scanner scan=new Scanner(System.in);
        String text=scan.nextLine();
        ChartoMorse(text);
        }
    }
 }