/**
 * 
 * @author Brendan Ewing
 * email: EwingBrendan32@gmail.com
 * Date: 2/8/22
 *  purpose: major project (eclipse)
 */
package com.mThree.AssessmentBasicProgrammingConcepts;


public class SummativeSums {
	/*
	 * basically string main method pass arrays to an adder that is a for loop return result
	 * 
	 */
	//main 
	public static void main(String[] args) {
		//composed of really 2 parts
		//Initializations 
		int[] arr1={ 1, 90, -33, -55, 67, -16, 28, -55, 15 };
		int[] arr2={ 999, -60, -77, 14, 160, 301 };
		int[] arr3={ 10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130, 
				140, 150, 160, 170, 180, 190, 200, -99 };
		//Outputs
		System.out.println("#1 Array Sum: "+SumDaArrays(arr1));
		System.out.println("#2 Array Sum: "+SumDaArrays(arr2));
		System.out.println("#3 Array Sum: "+SumDaArrays(arr3));
		
	}
	
	//adder
	public static int SumDaArrays(int[] arr) {
		//2 parts
		int result = 0;//Initializing result for return
		
		//for-loop
		for(int n=0;n<arr.length;n++) {
			result+=arr[n];
		}
		//return statement
		return result;
	}
	
}
