package bitmanipulation;

import java.util.ArrayList;

public class FindMissingNumber {

	public static void main(String[] args) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			list.add(1);
			list.add(2);
			list.add(3);
			list.add(5);
			
			FindMissingNumber f = new FindMissingNumber();
			System.out.print("Missing Number : ");
			System.out.println(f.findMissing(list));

	}

	public int findMissing(ArrayList<Integer> list){
			return findMissing(list, Integer.SIZE-1);
	}
	
	public int findMissing(ArrayList<Integer> list, int column){
			if(column<0) return 0;
			ArrayList<Integer> oddIndices = new ArrayList<Integer>();
			ArrayList<Integer> evenIndices = new ArrayList<Integer>();
			for(Integer t:list){
					if(Integer.toBinaryString(t).charAt(column)=='0')
							evenIndices.add(t);
					else
							oddIndices.add(t);
			}
			
			if(oddIndices.size()>evenIndices.size())
					return findMissing(evenIndices, column -1) <<1|0;
			else
					return findMissing(oddIndices, column-1) <<1|1;
	}
}
