package misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class main_misc {
	
	
	public static final int MAX = 1_000_000;
	
	
	
	
	public static void main(String[] args) {
		
		
	System.out.println(maj_element(new ArrayList<>(Arrays.asList(1,2,5,9,5,9,5,5,5))));
	System.out.println(maj_element(new ArrayList<>(Arrays.asList(1,5,5,1,3,3,5,5,1,5,5))));	
	
	}
	private static int maj_element(List<Integer> arr){
		
		//no sub array can have a different majority element,so if i find one that has a maj element this is the maj element
		//of the full array

		int l = arr.size();
		int c = 1;
		int guess = arr.get(0);
		int stop_l = l/2;
		for(int i = 1;i < l;i++){
			
			if(i > stop_l && c < 1 + (l-i)/2){
				//System.out.println(i+"---->"+stop_l);
				guess = arr.get(i);
				c = 0;
				stop_l = i + (l-i-1)/2;
				
			}
			
			if(guess == arr.get(i)){
				c++;
			}
			
			if(c >= 1+ (l-i)/2){
				return guess;
			}
			
		}
		
		return -1;
	}
	
}
