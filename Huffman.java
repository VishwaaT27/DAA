import java.util.*;
class Node
{
    char ch; int freq; Node left, right;
    Node(char ch, int freq)
    {
        this.ch = ch;
        this.freq = freq;
    }
}
class Huffman
{
    static void generateCodes(Node root, String code, Map<Character, String> codesMap)
    {
        if (root == null) return;
        if (root.left == null && root.right == null)
        {
            codesMap.put(root.ch, code);
            return;
        }
        generateCodes(root.left, code + "0", codesMap);
        generateCodes(root.right, code + "1", codesMap);
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of symbols: ");
        int n = sc.nextInt();

        char[] chars = new char[n];
        int[] freq = new int[n];

        System.out.println("Enter symbols:");
        for (int i = 0; i < n; i++) chars[i] = sc.next().charAt(0);

        System.out.println("Enter frequencies:");
        for (int i = 0; i < n; i++) freq[i] = sc.nextInt();

        PriorityQueue<Node> pq = new PriorityQueue<>( Comparator.comparingInt(a -> a.freq) );
        for (int i = 0; i < n; i++) pq.add(new Node(chars[i], freq[i]));

        while (pq.size() > 1)
        {
            Node x = pq.poll(); Node y = pq.poll();
            Node z = new Node('-', x.freq + y.freq);
            z.left = x; z.right = y;
            pq.add(z);
        }

        Node root = pq.poll();

        Map<Character, String> codesMap = new HashMap<>();
        generateCodes(root, "", codesMap);

        System.out.println("\nHuffman Codes:");
        for (Map.Entry<Character, String> entry : codesMap.entrySet())
            System.out.println(entry.getKey() + " : " + entry.getValue());
        while (true)
        {
            System.out.print("\nEnter a word to encode (or type 'exit' to quit): ");
            String input = sc.next();

            if (input.equalsIgnoreCase("exit"))
            {
                System.out.println("Program terminated. Goodbye!");
                break;
            }

            StringBuilder encodedString = new StringBuilder();
            boolean isValid = true;

            for (int i = 0; i < input.length(); i++)
            {
                char current = input.charAt(i);
                if (codesMap.containsKey(current)) encodedString.append(codesMap.get(current));
                else
                {
                    System.out.println("Error: Character '" + current + "' was not recognized in the symbol list.");
                    isValid = false;
                    break;
                }
            }
            if (isValid) System.out.println("Encoded Word: " + encodedString.toString());
        }
        sc.close();
    }
}