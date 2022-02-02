import java.util.*; 
class p7_3
{
public static int MatrixChainMultuplication(int d[], int n) 
{
          int [][]minMul = new int[n][n];
          int j, q;
          for (int i = 1; i < n; i++)
         minMul[i][i] = 0;
          for (int L = 2; L < n; L++) {
                for (int i = 1; i < n - L + 1; i++) {
                     j = i + L - 1; minMul[i][j] = 99999999; 
                            for (int k = i; k <= j - 1; k++) {
                               q = minMul[i][k] + minMul[k+1][j] + d[i-1] * d[k] * d[j]; 
                              if (q < minMul[i][j])
                              minMul[i][j] = q; }
} }
return minMul[1][n - 1]; 
}
public static void main(String[] args)
 {
int d[] = {32,50,58,150,17}; int size = d.length; for(int i=0; i< size ; i++)
System.out.println(d[i]);
System.out.println("Minimum number of multiplications required is: "+MatrixChainMultuplication(d, size)); }
} 			
