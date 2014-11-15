package sortAndSearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CircusTower {
	List<HtWt> items;
	List<HtWt> lastFoundSeq;
	List<HtWt> maxSequence;

	public static void main(String[] args) {

	}

	public int fillSequence(int startIndex,List<HtWt> seq){
		int firstUnfitItem = startIndex;
		if(startIndex<items.size()){
				for(int i=0; i<items.size(); i++){
						HtWt h = items.get(i);
						if(i==0|| h.compareHtWt(items.get(i-1))==-1)
								seq.add(h);
						else{
								firstUnfitItem = i;
								break;
						}
				}
		}
		return firstUnfitItem;
	}
	
	public void findMaxSequence(){
			Collections.sort(items);
			int currentUnfit = 0;
			while(currentUnfit < items.size()){
					List<HtWt> nextSeq = new ArrayList<HtWt>();
					int nextUnfit = fillSequence(currentUnfit, nextSeq);
					maxSequence = nextSeq.size()>maxSequence.size()? nextSeq:maxSequence;
					if(nextUnfit==currentUnfit) break;
					else	currentUnfit = nextUnfit;
			}
	}
}

class HtWt implements Comparable<HtWt>{
	int height, weight;
	public HtWt(int height, int weight) {
		this.height = height;
		this.weight = weight;
	}
	
	public int compareHtWt(HtWt h){
		if(h.height==this.height && h.weight==this.weight) return 0;
		else if(h.height>this.height && h.weight>this.weight) return 1;
		else if(h.height<this.height && h.weight<this.weight) return -1;
		else return -2;
	}

	
	@Override
	public int compareTo(HtWt h) {
		if(h.height==this.height && h.weight==this.weight) return 0;
		else if(h.height>this.height && h.weight>this.weight) return 1;
		else if(h.height<this.height && h.weight<this.weight) return -1;
		else return -2;
	}
	
}