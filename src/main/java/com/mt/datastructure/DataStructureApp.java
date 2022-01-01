package com.mt.datastructure;

import java.util.List;

/**
 * DataStructure App
 */
public class DataStructureApp {
	public static void main(String[] args) {
		DataStructureUtil.reverseString("hello");

		String palindrome = "akadaka";

		System.out.println("=============== Palindrome by reversing");
		String reversed = DataStructureUtil.reverseStringImproved(palindrome);
		if (palindrome.equals(reversed)) {
			System.out.println("The string " + palindrome + " is palindrome");
		} else {
			System.out.println("The string " + palindrome + " is not palindrome");
		}

		System.out.println("=============== Palindrome by checking first to the last");
		boolean palindromeStatus = DataStructureUtil.checkPalindrome(palindrome);
		if (palindromeStatus) {
			System.out.println("The string " + palindrome + " is palindrome");
		} else {
			System.out.println("The string " + palindrome + " is not palindrome");
		}

		System.out.println("=============== Reversing Integer");
		System.out.println("Reversed int : " + DataStructureUtil.reverseInt(-500));

		System.out.println("=============== Maximum Used Character");
		DataStructureUtil.findTheMostUsedCharInString("Hello giggilly are my man");

		System.out.println("=============== FizzBuZZ");
		List<String> fizzBuzz = DataStructureUtil.fizzBuzz(30);
		fizzBuzz.forEach((number) -> System.out.println(number));

		System.out.println("=============== Chunk the given array");
		int[] array = {1, 2, 3, 4, 5, 1, 2, 34, 6, 7, 6, 5, 4};
		int[][] answer = DataStructureUtil.chunk(array, 5);
		for (int[] arr : answer) {
			for (int n : arr) {
				System.out.println(n + " ");
			}
			System.out.println();
		}

	}
}
