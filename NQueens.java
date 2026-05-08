import java.util.*;
public class NQueens 
{
    static int[] x;
    static int count = 0;
    static boolean place(int k, int i) 
    {
        for (int j = 1; j < k; j++) 
            if (x[j] == i || Math.abs(x[j] - i) == Math.abs(j - k)) return false;
        return true;
    }

    static void nQueens(int k, int n) 
    {
        for (int i = 1; i <= n; i++) 
            if (place(k, i)) 
            {
                x[k] = i;
                if (k == n) 
                {
                    count++;
                    printBoard(n);
                } 
                else nQueens(k + 1, n);
            }
    }

    static void printBoard(int n) 
    {
        System.out.println("\nSolution " + count + ":");
        for (int i = 1; i <= n; i++) 
        {
            for (int j = 1; j <= n; j++) 
                if (x[i] == j) System.out.print("Q ");
                else System.out.print(". ");
            System.out.println();
        }
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        x = new int[n + 1];
        nQueens(1, n);
        if (count == 0) System.out.println("No solution exists for n = " + n);
    }
}