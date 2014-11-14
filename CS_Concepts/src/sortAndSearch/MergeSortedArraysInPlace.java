package sortAndSearch;

public class MergeSortedArraysInPlace {

	public static void main(String[] args) {
			MergeSortedArraysInPlace m = new MergeSortedArraysInPlace();
			int[] A = {1,2,3,4,0,0,0,0};
			int[] B = {5,6,7,8};
			
			System.out.println("Array 1:");
			m.printArray(A);
			
			System.out.println("Array 2:");
			m.printArray(B);
			
			m.merge(A, B, 3);
			System.out.println("Final Array:");
			m.printArray(A);
			
	}

	public void printArray(int [] arr){
		for(int n:arr)
				System.out.print(n+" ");
		System.out.println();
	}
	
	public void merge(int[] A, int[] B, int pos){
			int k = A.length - 1;
			int i = pos, j = B.length - 1;
			while(i>=0 && j>=0){
					if(A[i]>B[j]) A[k--] = A[i--];
					else		  A[k--] = B[j--];
			}
			while(j>=0) A[k--] = B[j--];
	}
}
