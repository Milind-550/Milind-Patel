import java.util.*;
class p7_1
{
public static int max(int a, int b) { 
return (a > b)? a : b; 
}

public static int knapSack(int W, int wt[], int val[], int n) {
int i, w;
int [][]K = new int[n+1][W+1];

for (i = 0; i <= n; i++) {
for (w = 0; w <= W; w++) {

if (i==0 || w==0)
K[i][w] = 0; 

else if (wt[i-1] <= w)
K[i][w] = max(val[i-1] + K[i-1][w-wt[i-1]], K[i-1][w]); 
else
K[i][w] = K[i-1][w];
 }
}
return K[n][W]; 
}

public static void main(String[] args) {
int i, n, W;
int []val = new int[20];
int []wt = new int[20];

Scanner s = new Scanner(System.in);
System.out.println("Enter number of items:");
n = s.nextInt();

System.out.println("Enter value and weight of items:\n"); 

for(i = 0;i < n; ++i) {
System.out.println("For :"+i); 
val[i] = s.nextInt();
wt[i] = s.nextInt();
}

System.out.println("Enter size of knapsack:"); 
W = s.nextInt();

System.out.print(knapSack(W, wt, val, n));
 }
} 
