import java.util.*;

class p5_3 {
    public static void main(String[] args) {
        int[] arr = new int[30];
        int i, n, x, flag = 0, high, low, mid = 0;
        Scanner s = new Scanner(System.in);
        System.out.println("Enter size of array: ");
        n = s.nextInt();
        System.out.println("Enter the element of array: ");
        for (i = 0; i < n; ++i)
            arr[i] = s.nextInt();
        System.out.println("Enter the element of to search:");
        x = s.nextInt();
        low = 0;
        high = n - 1;
        while (low <= high) {
            mid = (high + low) / 2;
            if (arr[mid] == x) {
                flag = 1;
                break;
            }
            if (arr[mid] < x)
                low = mid + 1;
            else
                high = mid - 1;
        }
        if (flag == 1)
            System.out.println("element found at entered position is :" + (mid + 1));
        else
            System.out.println("element not found");
    }
}