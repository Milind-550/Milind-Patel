import java.util.*;

class p6_1 {
    static int[] ans = new int[100];

    public static int findMinCoins(int coins[], int value, int size) {
        int i, count = 0;
        for (i = 0; i < size; i++) {
            while (value >= coins[i]) {
                value -= coins[i];
                ans[count] = coins[i];
                count++;
            }
            if (value == 0)
                break;
        }
        return count;
    }

    public static void main(String[] args) {

        int coins[] = { 45, 25, 15, 5, 3, 1 };
        int value, i;
        Scanner s = new Scanner(System.in);
        System.out.println("Enter value: ");
        value = s.nextInt();
        int size = coins.length;
        int MinCount = findMinCoins(coins, value, size);
        System.out.println("\nUsing this coins:");
        for (i = 0; i < coins.length; i++)
            System.out.print(" " + coins[i]);
        System.out.println("\n\nFor amount:" + value);
        System.out.println("\nTotal Coins Needed = " + MinCount);
        System.out.println("\nCoins are:");
        for (i = 0; i < MinCount; i++)
            System.out.print(" " + ans[i]);
    }
}
