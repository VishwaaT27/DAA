import java.util.*;
public class HorspoolStringMatch 
{
    static int[] shiftTable(String pattern) 
    {
        int m = pattern.length();
        int[] table = new int[256];
        for (int i = 0; i < 256; i++) table[i] = m;
        for (int j = 0; j < m - 1; j++) table[(int) pattern.charAt(j)] = m - 1 - j;
        return table;
    }
    static int horspool(String text, String pattern) 
    {
        int n = text.length(), m = pattern.length();
        int[] table = shiftTable(pattern);
        int i = m - 1;
        while (i < n) 
        {
            int k = 0;
            while (k < m && pattern.charAt(m - 1 - k) == text.charAt(i - k)) k++;
            if (k == m) return i - m + 1;
            else i += table[text.charAt(i)];
        }
        return -1;
    }
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Text: ");
        String text = sc.nextLine();
        System.out.print("Enter Pattern: ");
        String pattern = sc.nextLine();
        int result = horspool(text, pattern);
        if (result == -1) System.out.println("Pattern not found.");
        else System.out.println("Pattern found at index: " + result);
        sc.close();
    }
}