
public class Solution08 {
	
	public void draw(byte[] screen, int width, int x1, int x2, int y){
		/* We consider the pixels that can full in one byte */
		int r1 = x1 % 8;
		int start = x1/8;// the index of the first full byte
		if (r1 > 0){
			start++;
		}
		
		int r2 = x2 % 8;
		int end = x2/8;// the index of the last full byte
		if (r2 != 7){
			end--;
		}
		
		// Set full byte
		// Use 0xFF can set one at a time 
		for (int i = start; i <= end; i++){
			screen[(width/8) * y + i] = (byte) 0xFF; 
		}
		
		/* Now we consider the rest of the pixels */
		// create the masks
		byte start_mask = (byte) (0xFF >> r1);
		byte end_mask = (byte) ~(0xFF >> (r2 +1));
		
		// Set the rest of pixels
		if ((x1/8) == (x2/8)){// deal with the special case that the x1 and x2 are the same byte
			byte mask = (byte) (start_mask & end_mask);
			screen[(width/8) * y + (x1/8)] = mask;
		}else{
			// set the start of the line
			if(r1 != 0){
				screen[(width/8) * y + start -1] = start_mask;
			}
			// set the end of the line
			if(r2 != 7){
				screen[(width/8) * y + end +1] = end_mask;
			}
		}
		
	}

}
