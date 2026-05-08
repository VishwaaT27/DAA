import java.util.Scanner;
public class ClosestPair 
{
    public static void main(String[] args) 
    {
        int n; double dist, minDist;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Number of Points:"); n = sc.nextInt();
        int[] x = new int[n], y = new int[n];
        for (int i = 0; i < n; i++) 
        {
            System.out.println("Enter the X-Coordinate of point " + (i + 1) + ":"); x[i] = sc.nextInt();
            System.out.println("Enter the Y-Coordinate of point " + (i + 1) + ":"); y[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) System.out.println("Point " + (i + 1) + ": (" + x[i] + "," + y[i] + ")");
        minDist = Double.MAX_VALUE;
        for (int i = 0; i < n - 1; i++) 
            for (int j = i + 1; j < n; j++) 
            {
                dist = Math.sqrt( (x[i] - x[j]) * (x[i] - x[j]) + (y[i] - y[j]) * (y[i] - y[j]) );
                System.out.println("Distance between Point " + (i + 1) + " and Point " + (j + 1) + " = " + dist);
                if (dist < minDist) minDist = dist;
            }
        sc.close();
        System.out.println("Minimum Euclidean Distance: " + minDist);
    }
}