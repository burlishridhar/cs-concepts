package sortAndSearch;

public class FindElementInSortMat {

	public static void main(String[] args) {
		FindElementInSortMat f =new FindElementInSortMat();
		int[][] arr = {{1,2,3},
						{4,5,6},
						{7,8,9}};
		
		System.out.println(f.find(arr, 8, 3, 3));
	}
	
	public boolean find(int[][] arr, int elem, int m, int n){
			int row = 0, col = n-1;
			while(row<m && col>=0){
					if(arr[row][col]==elem) return true;
					else if(elem>arr[row][col]) row++;
					else col--;
			}
			return false;
	}

}
