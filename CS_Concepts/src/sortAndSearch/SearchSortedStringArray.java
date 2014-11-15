package sortAndSearch;

public class SearchSortedStringArray {

	public static void main(String[] args) {
		SearchSortedStringArray s = new SearchSortedStringArray();
		String[] arr = {"at","","","","ball","","","car","",""};
		
		System.out.println(s.search(arr, "ball"));
	}
	
	public int search(String[] arr, String str, int first, int last){
			while(first<=last){
					while(first<=last && arr[last].equals("")) last--;
					if(last<first) return -1;
					int mid = (first+last)/2;
					while(arr[mid].equals("")) mid++;
					int r = arr[mid].compareTo(str);
					if(r==0) return mid;
					else if(r<0) first=mid+1;
					else last=mid-1;
			}
			return -1;
	}
	
	public int search(String[] arr, String str){
			return search(arr, str, 0, arr.length-1);
	}

}
