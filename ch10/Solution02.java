import java.util.*;

public class Solution02 {
	public static void main(String[] args){
		Solution02 s = new Solution02();
		String[] sArr = {"abc", "asdf", "werq","cba", "fdsa", "hjkl","qwer"};
		String[] result = s.sort(sArr);
		for(String ss: result){
			System.out.print(ss + " ");
		}
	}

	public String[] sort(String[] sArr) {
		HashMap<String, ArrayList<String>> hm = new HashMap<String, ArrayList<String>>();

		for (String s : sArr) {
			char[] c = s.toCharArray();
			Arrays.sort(c);
			String k = new String(c);
			if (hm.containsKey(k)) {
				ArrayList<String> list = hm.get(k);
				list.add(s);
				hm.put(k, list);
			} else {
				ArrayList<String> list = new ArrayList<String>();
				list.add(s);
				hm.put(new String(c), list);
			}
		}

		int index = 0;
		String[] result = new String[sArr.length];

		Iterator iter = hm.keySet().iterator();
		while (iter.hasNext()) {
			String key = (String) iter.next();
			ArrayList<String> as = hm.get(key);
			for (String s : as){
				result[index] = s;
				index++;
			}
		}
		
		return result;
	}

}
