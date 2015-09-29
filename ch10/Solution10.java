 
public class Solution10 {
	public static void main(String[] args){
		Solution10 s = new Solution10();
		
		s.track(5);
		s.track(1);
		s.track(4);
		s.track(4);
		s.track(5);
		s.track(9);
		s.track(7);
		s.track(13);
		s.track(3);
		
		System.out.println(s.getRankNum(1));
		System.out.println(s.getRankNum(3));
		System.out.println(s.getRankNum(4));
	}
	
	RankNode root = null;
	
	public void track(int num){
		if (root == null){
			root = new RankNode(num);
		}else{
			root.insert(num);
		}	
	}
	
	public int getRankNum(int d){
		return root.getRank(d);
	}
	

}
