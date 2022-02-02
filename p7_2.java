import java.util.*;
 class p7_2
{
public static void lcsAlgo(char S1[],char S2[]) 
{
int i, j, m, n;
int [][]LCS_table = new int[20][20]; 
char [][]b = new char[20][20];
m = S1.length;
n = S2.length;
					
// Filling 0's in the matrix
 for (i = 0; i <= m; i++)
 LCS_table[i][0] = 0; 
 for (i = 0; i <= n; i++) 
 LCS_table[0][i] = 0;
					
// Building the matrix in bottom-up way 
for (i = 1; i <= m; i++)
for (j = 1; j <= n; j++) 
{
if (S1[i - 1] == S2[j - 1])
 {
LCS_table[i][j] = LCS_table[i - 1][j - 1] + 1;
} 
else if (LCS_table[i - 1][j] >= LCS_table[i][j - 1]) {

LCS_table[i][j] = LCS_table[i - 1][j];
 }
 else {
LCS_table[i][j] = LCS_table[i][j - 1]; 
}
}

int index = LCS_table[m][n];
char []lcsAlgo = new char[index + 1]; 
lcsAlgo[index] = '\0';
i = m;
j = n;

while (i > 0 && j > 0)
{ 
    if (S1[i - 1] == S2[j - 1]) 
    {
    lcsAlgo[index - 1] = S1[i - 1]; i--;
    j--;
    index--;
    }
    else if (LCS_table[i - 1][j] > LCS_table[i][j - 1]) i--;
    else
    j--;
    }
    
     // Printing the sub sequences
     System.out.print("S1: ");
     System.out.println(S1); 
    System.out.print("S2: "); 
    System.out.println(S2);
     System.out.print("LCS :"); 
    System.out.println(lcsAlgo); 
    }
    
    public static void main(String[] args) {
    String s1 = "ABABAB"; String s2 = "ABAB";
    char []S1 = s1.toCharArray(); 
    char []S2 = s2.toCharArray(); 
    lcsAlgo(S1,S2); System.out.print("\n"); 
    }
    }
    