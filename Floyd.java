import java.util.*;
public class Floyd 
{
    static final int INF = 99999;
    public static void floyd(int[][] W, int n) 
    {
        int[][] D = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                D[i][j] = W[i][j];
        for (int k = 0; k < n; k++) 
            for (int i = 0; i < n; i++) 
                for (int j = 0; j < n; j++) 
                    if ((D[i][k] != INF && D[k][j] != INF) && (D[i][k] + D[k][j] < D[i][j]))
                        D[i][j] = D[i][k] + D[k][j];
        System.out.println("\nShortest Distance Matrix:");
        for (int i = 0; i < n; i++)
        { 
            for (int j = 0; j < n; j++)
                if (D[i][j] == INF)
                    System.out.print("INF ");
                else
                    System.out.print(D[i][j] + " ");
            System.out.println();
        }
    }
    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter number of vertices: ");
        int n = in.nextInt();
        int[][] W = new int[n][n];
        System.out.println("Enter weights for vertices(99999 for INF): ");
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) 
            {
                if (i == j) 
                {
                    W[i][j] = 0;
                    continue;
                }
                System.out.print((i+1) + " -> " + (j+1) + ": ");
                W[i][j] = in.nextInt();
            }
        floyd(W, n);
        in.close();
    }
}