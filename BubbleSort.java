        import java.util.*;

        public class BubbleSort {
            public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);

                System.out.print("Enter number of elements: ");
                int n = sc.nextInt();
                int[] arr = new int[n];

                System.out.println("Enter elements:");
                for (int i = 0; i < n; i++) {
                    arr[i] = sc.nextInt();
                }

                boolean swapped;
                for (int i = 0; i < n - 1; i++) 
                {
                    swapped = false; // flag to check if any swap occurs
                    for (int j = 0; j < n - i - 1; j++) 
                    {
                        if (arr[j] > arr[j + 1]) 
                        {
                            // swap elements
                            int temp = arr[j];
                            arr[j] = arr[j + 1];
                            arr[j + 1] = temp;
                            swapped = true; // swap occurred
                        }
                    }
                    if (!swapped) 
                        break;
                }

                System.out.println("Sorted array:");
                for (int num : arr) {
                    System.out.print(num + " ");
                }
                sc.close();
            }
        }
