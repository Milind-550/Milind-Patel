import java.util.*;

class p5_2 {
    public static int randomNumberInRange(int n) {
        Random random = new Random();
        return random.nextInt(n);
    }

    static void random(int arr[], int low, int high) {
        Random random = new Random();
        int pivot = random.nextInt(high - low) + low;
        int temp1 = arr[pivot];
        arr[pivot] = arr[high];
        arr[high] = temp1;
    }

    static int partition(int arr[], int low, int high) {
        random(arr, low, high);
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    static void sort(int arr[], int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }
    }

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int n;
        System.out.println("How many data you want to sort:");
        n = s.nextInt();
        int[] arr = new int[n];
        int value;
        for (int i = 0; i < n; i++) {
            value = randomNumberInRange(n);
            arr[i] = value;
        }
        System.out.println("Array of n random values : ");
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i]);
        }
        long startTime = System.currentTimeMillis();
        sort(arr, 0, n - 1);
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("sorted array: ");
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i]);
        }
        System.out.println("Start time:    " + startTime / 1000);
        System.out.println("End time:      " + endTime / 1000);
        System.out.println("Total time:(sec) " + totalTime / 1000);
    }
}