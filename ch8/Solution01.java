import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution01 {
/*
 * Complete the function below.
 */
    public static final int MAXN = 100005;
    
    // Store the paths for the values from 0 to MAXN
    static long [] R = new long[MAXN];
    
    static long MOD = 1000000007;
    static long find(int [] A, int N){
        long result = 0;

        if(N==0){
            return 1;
        }
        
        // If the R[N] has been calculated, return it directly
        if(R[N]>=0) return R[N];
        
        for(int i = 0; i<A.length;i++){
            if(N - A[i] >= 0){ 
                R[N-A[i]] = find(A, N - A[i]) % MOD; 
                result += R[N-A[i]];
            }
        }
        result %= MOD; 
        return result;
    }

    static long[] countPaths(int[] A, int[] T) {
        
        // Initalize the R with -1s in order to avoid repetitive calculation
        for(int j = 0; j<MAXN; j++){
            R[j] = -1;
        } 
            
        
        long [] ans = new long[T.length];
        
        for(int i = 0;i<MAXN ; i++) {
            R[i] = find(A, i);
        }
        
        for(int i = 0;i<T.length;i++){
            ans[i] = R[T[i]];
        }
        
        return ans;
    }
    
    public static void main(String[] args) throws IOException{
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
}

