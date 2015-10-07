import java.util.ArrayList;

public class Solution10_FollowUp {
	/* find the bottle having poisoned content */
	public static  int findPoisonBottle (ArrayList<Strip> stripList, ArrayList<Bottle> bottleList){
		runTest(bottleList, stripList);
		int[] bit = new int[10];
		for(Strip strip : stripList){
			if (strip.hasPoison()){
				bit[strip.getID()] = 1;
			}
			
		}
		
		int result = 0;
		for(int i= 0; i< bit.length; i++){
			if (bit[i] == 1){
			result += Math.pow(2, i);
			}
		}
		
		return result;
	}

	/* add bottle contents to test trips */
	public static void runTest(ArrayList<Bottle> bottleList, ArrayList<Strip> stripList) {
		for (Bottle bottle : bottleList) {
			int id = bottle.getID();
			int index = 0;
			while (id > 0) {
				if ((id & 1) == 1) {
					stripList.get(index).addDrop(bottle);
				}
				index++;
				id >>= 1;
			}
		}
	}
	
}

// build a class for bottle
class Bottle {
	private int id;
	private boolean poisoned = false;

	// constructor
	public Bottle(int id) {
		this.id = id;
	}

	// Getter for id
	public int getID() {
		return id;
	}

	// Setter for poisoned
	public void setPoisoned() {
		this.poisoned = true;
	}

	// return whether the bottle's content is poisoned or not
	public boolean isPoisoned() {
		return poisoned;
	}

}

// built a class for test strip
class Strip {
	public static final int DAYS_FOR_RESULT = 7;
	private int id;
	public ArrayList<Bottle> drops = new ArrayList<Bottle>();

	// constructor
	public Strip(int id) {
		this.id = id;
	}

	// Getter for id
	public int getID() {
		return id;
	}

	/* add drops from bottle */
	public void addDrop(Bottle bottle) {
		drops.add(bottle);
	}

	/* check if any the bottles in the set are poisoned */
	public boolean hasPoison() {
		for (Bottle bottle : drops) {
			if (bottle.isPoisoned()) {
				return true;
			}
		}
		return false;
	}
}
