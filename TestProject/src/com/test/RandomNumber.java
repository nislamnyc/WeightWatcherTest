/**
 * 
 */
package com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author Md Islam
 *  Purpose: Generate 500 random numbers and print the nth smallest number
 *  in console.
 */
public class RandomNumber {
		static List<Integer> list_smallest(int randoms, int nth){
		
		ArrayList<Integer> n = new ArrayList<Integer>();
		for (int i = 0; i < randoms; i++) {
			int s = (int) Math.round(Math.random() * randoms);
			n.add(s);
		}
		List<Integer> d = n.stream()
			.sorted((k1, k2) -> k1.compareTo(k2))
			.limit(nth)
			.collect(Collectors.toList());
		return d;
	}
	
		public static void main(String...abc){
			List<Integer> d;
			d =  list_smallest(500, 10);
			System.out.println(d);
		}
		
}
