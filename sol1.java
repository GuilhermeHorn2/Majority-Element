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
		
		
		//System.out.println(maj_element(new ArrayList<>(Arrays.asList(1,2,5,9,5,9,5,5,5))));
		System.out.println(maj_element(new ArrayList<>(Arrays.asList(1,5,5,1,3,3,5,5,1,5,5))));
		
	}
	
	private static int maj_element(List<Integer> arr){
		
		
		/*search for repeated numbers in sequence the largest is the candidate to be a maj element,if there is 2 seq of diferent
		 * element but equal size both are candidates,if there is more its impossible to have a maj element
		 */
		
		int curr = 1;
		int max = 1;
		int cand_1 = -1;
		for(int i = 1;i < arr.size();i++){
			
			int a = arr.get(i);
			int b = arr.get(i-1);
			
			if(a == b) {
				curr++;
			}
			if(a != b || i+1 == arr.size()){
				if(curr > max){
					max = curr;
					cand_1 = b;
				}
				curr = 1;
			}
			
		}
		curr = 0;
		int cand_2 = -1;
		for(int i = 1;i < arr.size();i++) {
			
			int a = arr.get(i);
			int b = arr.get(i-1);
			
			if(a == b){
				curr++;
			}
			if(a != b || i+1 == arr.size()){
				if(curr == max && b != cand_1) {
					if(cand_2 != -1 && b != cand_2) {
						//more than 2 groups with the same number of elements
						return -1;
					}
					cand_2 = b;
				}
			}
		}
		
		//check candidates :
		int count_1 = 0;
		int count_2 = 0;
		for(int i = 0;i < arr.size();i++){
			
			int x = arr.get(i);
			
			if(x == cand_1){
				count_1++;
			}
			if(x == cand_2){
				count_2++;
			}
		}
		
		
		if(count_1 >= (arr.size()/2)+1){
			return cand_1;
		}
		if(count_2 >= (arr.size()/2)+1){
			return cand_2;
		}
		return -1;
		
	}
	
	
}
