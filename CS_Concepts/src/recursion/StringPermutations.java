package recursion;

import java.util.ArrayList;
import java.util.List;

public class StringPermutations {

	public static void main(String[] args) {
			StringPermutations s = new StringPermutations();
			List<String> list = s.getPerms("abc");
			s.printPermutations(list);
	}
	
	public void printPermutations(List<String> list){
		for(String word:list)
				System.out.println(word);
	}
	
	public List<String> getPerms(StringBuffer sb, int startIndex){
			if(sb==null) return null;
			List<String> perms = new ArrayList<String>();
			if(sb.length()==startIndex) {perms.add(" ");return perms; }
			char first = sb.charAt(startIndex); 
			startIndex++;
			List<String> words = getPerms(sb, startIndex);
			for(String word:words){
					for(int i=0; i<word.length(); i++)
						perms.add(insertCharAt(word, first, i));
			}
			return perms;
	}

	public List<String> getPerms(String s){
		return getPerms(new StringBuffer(s), 0);
	}

	public String insertCharAt(String word, char c, int position){
		if(word.length()==0) return c+"";
		return word.substring(0, position) + c + word.substring(position);
	}

}
