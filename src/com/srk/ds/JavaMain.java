package com.srk.ds;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class JavaMain {

	public static void main(String[] args) {
		System.out.println("Hello****");
		Boolean.parseBoolean("FalSe");
		
		String[] arr= {"abc", "xxx",	};
		List<String> asList = Arrays.asList(arr);
		Collections.sort(asList);
		System.out.println(asList);
		
		throw new Error();

	}
}
