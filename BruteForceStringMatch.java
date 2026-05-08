import java.util.Scanner;

public class BruteForceStringMatch 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        String text, pattern;
        int n, m;
        int foundIndex = -1;
        System.out.println("Enter the Text String:");
        text = sc.nextLine();

        System.out.println("Enter the Pattern String:");
        pattern = sc.nextLine();

        n = text.length();
        m = pattern.length();

        for (int i = 0; i <= n - m; i++) 
        {
            int c = 0, a = i;
            for (int j = 0; j < m; j++, a++) 
            {
                if (text.charAt(a) != pattern.charAt(j)) 
                {
                    c = 1;
                    break;
                }
            }
            if (c == 0) 
            {
                foundIndex = i;
                break;
            }
        }

        if (foundIndex != -1)
            System.out.println("Pattern found at position: " + (foundIndex + 1));
        else
            System.out.println("Pattern not found");
    }
}
