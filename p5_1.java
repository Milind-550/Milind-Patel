import java.util.*;

class p5_1 {
    public static int randomNumberInRange(int n) {
        Random random = new Random();
        return random.nextInt(n);
    }

    public static void merge(int[] A, int left, int mid, int right) {
        int[] Temp = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int count = 0;
        while (i <= mid && j <= right) {
            if (A[i] < A[j]) {
                Temp[count] = A[i];
                i++;
            } else {
                Temp[count] = A[j];
                j++;
            }
            count++;
        }
        while (i <= mid) {
            Temp[count] = A[i];
            i++;
            count++;
        }
        while (j <= right) {
            Temp[count] = A[j];
            j++;
            count++;
        }
        for (i = 0; i < count; i++)
            A[i + left] = Temp[i];
    }

    public static void mergesort(int[] A, int left, int right) {
        if (left != right) {
            int mid = (left + right) / 2;
            mergesort(A, left, mid);
            mergesort(A, mid + 1, right);
            merge(A, left, mid, right);
        }
    }

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int n;
        System.out.println("How many data you want to sort:");
        n = s.nextInt();
        int[] A = new int[n];
        int value;
        for (int i = 0; i < n; i++) {
            value = randomNumberInRange(n);
            A[i] = value;
        }
        System.out.println("Array of n random values : ");
        for (int i = 0; i < n; i++) {
            System.out.println(A[i]);
        }
        long startTime = System.currentTimeMillis();
        mergesort(A, 0, A.length - 1);
        long endTime = System.currentTimeMillis();
        System.out.println("sorted array: ");
        long totalTime = endTime - startTime;
        for (int i = 0; i < n; i++) {
            System.out.println(A[i]);
        }
        System.out.println("Start time:   " + startTime / 1000);
        System.out.println("End time:     " + endTime / 1000);
        System.out.println("Total time:(sec) " + totalTime / 1000);
    }
}