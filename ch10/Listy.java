 
public class Listy {
	public int[] array;
	
	Listy(int[] array){
		this.array = array;
	}
	
	public int elementAt(int i){
		if(i < array.length){
			return array[i];
		}
		return -1;
	}
}
