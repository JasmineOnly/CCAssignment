import java.io.*;
import java.util.*;
import java.math.*;

public class Solution03 {   
    static long MOD = 1000000007;
    static int maxA = 1000;
    static int maxC = 100005;

     
   public static void main(String args[] ) throws Exception {
   
    Scanner in = new Scanner(System.in);
		String[] split = in.nextLine().split(" ");
		int[] A = new int[split.length];
		for(int i=0; i<split.length; i++)
			A[i] = Integer.parseInt(split[i]);
		int N = Integer.parseInt(in.nextLine().trim());
		int[] T = new int[N];
		for(int i=0; i<N; i++) {
			T[i] = Integer.parseInt(in.nextLine().trim());
		}
		long[] countPaths = countPaths(A, T);
		for(long c : countPaths)
			System.out.println(c);
		in.close();
    }
    
    public static long[] countPaths(int[] A, int[] T){
        int[] temp = T;
        Arrays.sort(temp);
        int max = temp[temp.length-1];
        long[] result = new long[T.length]; 
        // s[i][j] indicates the paths of presenting j by the first i coins 
        long[][] s = new long[A.length][max+1]; 
        
        // Initiallize the special cases
        for(int i = 0; i*A[0]<= max; i++){
            s[0][i*A[0]] = 1;
        }
        
        for(int i = 0; i< A.length; i++){
            s[i][0] = 1;
        }
        
        for(int i = 1; i<A.length; i++){
            for(int j = 1; j< max+1; j++){
                // do not use the ith coin at all
                s[i][j]=s[i-1][j];
                if(j-A[i]>=0){
                    // use one ith coin at least
                    s[i][j] += s[i][j-A[i]];
                    s[i][j] %= MOD;
                }
            }
        }
          
        for(int j = 0; j< T.length; j++){
            result[j] = s[A.length-1][T[j]]; 
        }
        
        return result;
       
    
        
    }
}