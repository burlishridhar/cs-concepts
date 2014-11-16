package recursion;

import java.util.ArrayList;
import java.util.List;

public class AllSubSets {

	public static void main(String[] args) {
		AllSubSets a = new AllSubSets();
		List<Integer> list = new ArrayList<Integer>();
		list.add(1); list.add(2); list.add(3); list.add(4);
		List<List<Integer>> lists = a.getSubSets(list, 0);
		a.printSubSets(lists);
	}
	
	public void printSubSets(List<List<Integer>> lists){
		for(List<Integer> list:lists){
			System.out.print("Subset : ");
			for(Integer i:list)
					System.out.print(i+" ");
			System.out.println();
		}
	}
	
	
	public List<List<Integer>> getSubSets(List<Integer> set, int index){
		List<List<Integer>> allSubSets;
		if(set.size()==index){
			allSubSets = new ArrayList<List<Integer>>();
			allSubSets.add(new ArrayList<Integer>());
		}else{
			allSubSets = getSubSets(set, index+1);
			int item = set.get(index);
			List<List<Integer>> moreSubSets = new ArrayList<List<Integer>>();
			for(List<Integer> subSet: allSubSets){
					List<Integer> newSubSet = new ArrayList<Integer>();
					newSubSet.addAll(subSet); newSubSet.add(item);
					moreSubSets.add(newSubSet);
			}
			allSubSets.addAll(moreSubSets);
		}
		return allSubSets;
	}

}
