package com.intuit.assignment.util;

import java.util.Scanner;

public class ScannerUtil {

	private static final Scanner SC = new Scanner(System.in);
	private static final ScannerUtil SCU = new ScannerUtil();

	private ScannerUtil() {
	}

	public static ScannerUtil getInstance() {
		return SCU;
	}

	public String getNextString() {
		String next = SC.next();
		return next;
	}

	public char getFirstChar() {
		String next = SC.next();
		char ch;
		ch = next.toCharArray()[0];
		return ch;
	}

	public int getNextInt() {
		int nextInt = SC.nextInt();
		return nextInt;
	}

	public long getNextLong() {
		long nextInt = SC.nextLong();
		return nextInt;
	}

}
