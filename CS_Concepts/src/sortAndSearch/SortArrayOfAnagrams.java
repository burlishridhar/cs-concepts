package sortAndSearch;

import java.util.Arrays;

public class SortArrayOfAnagrams {

	public static void main(String[] args) {
			SortArrayOfAnagrams s = new SortArrayOfAnagrams();
			String [] arr = {"abc", "xyz", "bacd" ,"pqr", "bcad", "cab"};
			
			System.out.println("Original Array:");
			s.printArray(arr);
			
			s.stringQuickSort(arr, 0, arr.length-1);
			
			System.out.println("Sorted Array:");
			s.printArray(arr);
	}

	/*
	 * Print the Array
	 * */
	public void printArray(String[] arr){
			for(String s:arr)
					System.out.println(s);
	}
	
	
	/*
	 * Method to compare two strings and check if they are Anagrams
	 * */
	public int compareStrings(String str1, String str2){
			char[] con1 = str1.toCharArray(), con2 = str2.toCharArray();
			Arrays.sort(con1); Arrays.sort(con2);
			return new String(con1).compareTo(new String(con2));
	}
	

	/*
	 * Modified QuickSort for an array of strings
	 * */
	public void stringQuickSort(String[] arr, int left, int right){
			if(left>=right) return;
			int pivot = right, pIndex = left;
			for(int cIndex=left; cIndex<right; cIndex++){
					if(compareStrings(arr[cIndex], arr[pivot]) <=0){
							swap(arr, cIndex, pIndex); pIndex ++;
					}
			}
			swap(arr, pIndex, pivot);
			
			stringQuickSort(arr, left, pIndex-1);
			stringQuickSort(arr, pIndex+1, right);
			
	}
	

	private void swap(String[] arr, int pos1, int pos2) {
			String temp = arr[pos1];
			arr[pos1] = arr[pos2];
			arr[pos2] = temp;
	}
}
