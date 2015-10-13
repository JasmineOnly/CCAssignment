import java.io.*;
import java.util.*;
import java.math.*;
public class Solution02 {

    static long [][] map; // store the number of optimum paths to arrive map[i][j]
    static int [][] step;  // store the number of minimun steps to arrive map[i][j]
    
    static int L;
    static int C;
    
    /// Queue
    static class Position{
        public int x;
        public int y;
        
        Position(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    static Position [] queue = new Position [90005];
    static int head = 0;
    static int tail = 0;
    
    static Position pop(){
        return queue[head++];
    }
    static boolean empty(){
        return head == tail;
    }
    static void push(Position p){
        queue[tail++] = p;
    }
    ///
    
    public static final long MOD = 1000000007;
    
    // This mothod is used to calculate the "map" and "step"
    public static void check(int x, int y, long last_count, int last_step){
        // check the boundary condition
        if(x<0 || x>=L) return ;
        if(y<0 || y>=C) return ;
        
        // -2 indicates this is a impasse
        if(map[x][y] == -2) return ;
        
        // -1 indicates this location has not been calculate
        if(map[x][y] == -1) {
            map[x][y] = last_count;
            step[x][y] = last_step + 1;
            push(new Position(x,y));
        }
        else {
            if(last_step + 1 == step[x][y]){
                map[x][y] += last_count;
                map[x][y] %= MOD;
            }
        }

    }
    
    public static void solve(){
        // check the special cases
        if(map[0][0] == -2) return;
        if(map[L-1][C-1] == -2) return;
       
        push(new Position(0,0));
        map[0][0] = 1;
        step[0][0] = 0;     
        
        while(!empty()){
            Position node = pop();
            
            int x = node.x;
            int y = node.y;
            
            if((node.x == L-1)  && (node.y == C-1) ) return ;
            
            long last_count = map[x][y];
            int last_step = step[x][y];
            
            //check the four neighboring grid squares
            check(x+1,y, last_count, last_step);
            check(x-1,y, last_count, last_step);
            check(x,y+1, last_count, last_step);
            check(x,y-1, last_count, last_step);
            
        }
        
    }
    
public static void main(String args[] ) throws Exception {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner in = new Scanner(System.in);
		String[] split = in.nextLine().split(" ");
        L = Integer.parseInt(split[0]);
        C = Integer.parseInt(split[1]);
    
        map = new long[L][C];
        step = new int[L][C];
    
        for(int i = 0;i<L;i++){
            String line = in.nextLine();
            for(int j = 0;j<line.length();j++){
                if(line.charAt(j)=='o'){
                    
                    map[i][j] = -1;
                }
                else{
                    map[i][j] = -2;
                }
                step[i][j] = -1; 
            }
        }
        
		in.close();
    
    
        solve();
        if(map[L-1][C-1]<0)map[L-1][C-1] = 0;
        System.out.println(map[L-1][C-1]+ "\n" + step[L-1][C-1]);
}
    
}