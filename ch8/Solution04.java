import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution04 {
/*
 * Complete the function below
 */
    static long[] s = new long[30005];
    static long heightest = 0;
    
    static class Box{
        int index;
        int width;
        int length;
        int height;
        
        Box(int index, int width, int length, int height){
            this.index = index;
            this.width = width;
            this.length = length;
            this.height = height;
        }
        
    }
   
     // Compare the width
   static class WidthComparator implements Comparator<Box>{
        public int compare(Box b1, Box b2) {  
            return b1.width - b2.width;
        }
    }
         
   static long highestStack(int[][] boxes) {       
       Box[] boxArray = new Box[boxes.length];
       for(int i = 0; i< boxes.length; i++){
           boxArray[i] = new Box(i,boxes[i][0], boxes[i][1],boxes[i][2]);
       }
       
       // Sort the boxArray by width
       Arrays.sort(boxArray, new WidthComparator());
    
       s[0] = boxArray[0].height;
     
       for(int i = 1; i< boxArray.length; i++){
           for(int j = 0; j< i; j++){
               // check whether the length is fit the request
               if (boxArray[j].length < boxArray[i].length && boxArray[j].width < boxArray[i].width){
                   s[i]= Math.max(s[i],s[j]);
               }
           }
       
           s[i] += boxArray[i].height;
           heightest = Math.max(heightest, s[i]); 
       }
           return heightest;
      
   }
   
   public static void main(String[] args) throws IOException{
		Scanner in = new Scanner(System.in);
		int N = Integer.parseInt(in.nextLine().trim());
		int[][] boxes = new int[N][3];
		for (int i = 0; i < N; i++) {
			String[] split = in.nextLine().split(" ");
			for (int j = 0; j < split.length; j++) {
				boxes[i][j] = Integer.parseInt(split[j]);
			}
		}
		System.out.println(highestStack(boxes));
		in.close();
   }
}
 
    
    
   

  
