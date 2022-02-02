import java.util.*;

class p6_2 {
    public static void knapsack(int n, float weight[], float profit[], float capacity) {
        float[] x = new float[20];
        float tp = 0, u;
        int i, j;
        u = capacity;

        for (i = 0; i < n; i++)
            x[i] = (float) 0.0;

        for (i = 0; i < n; i++) {
            if (weight[i] > u)
                break;
            else {
                x[i] = (float) 1.0;
                tp = tp + profit[i];
                u = u - weight[i];
            }
        }

        if (i < n)
            x[i] = u / weight[i];

        tp = tp + (x[i] * profit[i]);

        System.out.println("The result vector is:- ");
        for (i = 0; i < n; i++)
            System.out.println("\t" + x[i]);

        System.out.println("Maximum profit is:-" + tp);

    }

    public static void main(String[] args) {
        float[] weight = new float[20];
        float[] profit = new float[20];
        float capacity, temp;
        int num, i, j;
        float[] ratio = new float[20];
        Scanner s = new Scanner(System.in);
        System.out.println("\n------------------------------------------------");
        System.out.println("\n       KNAPSACK PROBLEM USING GREEDY APPROACH    ");
        System.out.println("\n------------------------------------------------");

        System.out.println("\nEnter the no. of objects:- ");
        num = s.nextInt();

        System.out.println("\n------Enter the weights and values of each object--------");

        System.out.println("\nweights and profits of each object:- ");
        for (i = 0; i < num; i++) {
            weight[i] = s.nextFloat();
            profit[i] = s.nextFloat();
        }

        System.out.println("\nEnter the capacity of knapsack:- ");
        capacity = s.nextFloat();

        for (i = 0; i < num; i++) {
            ratio[i] = profit[i] / weight[i];
        }

        for (i = 0; i < num; i++) {
            for (j = i + 1; j < num; j++) {
                if (ratio[i] < ratio[j]) {
                    temp = ratio[j];
                    ratio[j] = ratio[i];
                    ratio[i] = temp;

                    temp = weight[j];
                    weight[j] = weight[i];
                    weight[i] = temp;

                    temp = profit[j];
                    profit[j] = profit[i];
                    profit[i] = temp;
                }
            }
        }

        knapsack(num, weight, profit, capacity);
    }
}
