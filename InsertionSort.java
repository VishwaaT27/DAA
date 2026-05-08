import java.util.*;
class InsertionSort 
{
    static void insertionSort(int arr[]) 
    {
        int n = arr.length;
        for (int i = 1; i < n; i++) 
        {
            int v = arr[i], j = i - 1;
            while (j >= 0 && arr[j] > v) arr[j + 1] = arr[j--];
            arr[j + 1] = v;
        }
    }
    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = in.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) arr[i] = in.nextInt();
        insertionSort(arr);
        System.out.println("Sorted array:");
        for (int x : arr) System.out.print(x + " ");
        in.close();
    }
}