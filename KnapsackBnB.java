import java.util.*;
class Item 
{
    int weight, value;
    double ratio;
    Item(int w, int v) 
    {
        weight = w; value = v;
        ratio = (double) v / w;
    }
}
class Node 
{
    int level, profit, weight;
    double bound;
}
public class KnapsackBnB 
{
    static int W, n;
    static Item[] items;
    static double bound(Node u) 
    {
        if (u.weight >= W) return 0;
        double profitBound = u.profit;
        int j = u.level + 1;
        int totalWeight = u.weight;
        while (j < n && totalWeight + items[j].weight <= W) 
        {
            totalWeight += items[j].weight;
            profitBound += items[j].value; j++;
        }
        if (j < n) profitBound += (W - totalWeight) * items[j].ratio;
        return profitBound;
    }
    static int knapsack() 
    {
        PriorityQueue<Node> Q = new PriorityQueue<>((a, b) -> Double.compare(b.bound, a.bound));
        Node root = new Node();
        root.level = -1; root.profit = 0;
        root.weight = 0; root.bound = bound(root);
        int maxProfit = 0; 
        Q.add(root); 
        while (!Q.isEmpty()) 
        {
            Node u = Q.poll();
            if (u.bound <= maxProfit) continue;
            Node v = new Node();
            v.level = u.level + 1;
            if (v.level >= n) continue;

            // INCLUDE item
            v.weight = u.weight + items[v.level].weight;
            v.profit = u.profit + items[v.level].value;
            if (v.weight <= W && v.profit > maxProfit) maxProfit = v.profit;
            v.bound = bound(v);
            if (v.bound > maxProfit) Q.add(v);

            // EXCLUDE item
            v = new Node();
            v.level = u.level + 1; v.weight = u.weight;
            v.profit = u.profit; v.bound = bound(v);
            if (v.bound > maxProfit) Q.add(v);
        }
        return maxProfit;
    }
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("====== 0/1 Knapsack using Branch and Bound ======");
        System.out.print("Enter number of items: ");
        n = sc.nextInt();
        items = new Item[n];
        for (int i = 0; i < n; i++) 
        {
            System.out.println("\nItem " + (i + 1) + ":");
            System.out.print("Enter weight: ");
            int w = sc.nextInt();
            System.out.print("Enter value: ");
            int v = sc.nextInt();
            if (w <= 0) 
            {
                System.out.println("Weight must be positive. Try again.");
                i--;
                continue;
            }
            items[i] = new Item(w, v);
        }
        System.out.print("\nEnter knapsack capacity: ");
        W = sc.nextInt();
        Arrays.sort(items, (a, b) -> Double.compare(b.ratio, a.ratio));
        System.out.println("\nItems after sorting by Value/Weight ratio:");
        System.out.println("Weight\tValue\tRatio");
        for (Item item : items) System.out.printf("%d\t%d\t%.2f\n", item.weight, item.value, item.ratio);
        int result = knapsack();
        System.out.println("\n====================================");
        System.out.println("Maximum Profit = " + result);
        System.out.println("====================================");
        sc.close();
    }
}