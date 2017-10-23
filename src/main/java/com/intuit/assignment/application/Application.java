package com.intuit.assignment.application;

import java.text.ParseException;

import com.intuit.assignment.daolayer.exception.AppException;
import com.intuit.assignment.macroservices.LoginService;
import com.intuit.assignment.util.DisplayUtil;

public class Application {

	public static void main(String[] args) {

		DisplayUtil.printDelimitedStart("Online Reservation System");
		System.out.println("Initializing the System with dummy values for Master Data");

		try {
			init();
		} catch (AppException appEx) {
			System.err.println("Uncaught Applicaton Exception occured.");
		} catch (Exception e) {
			System.err.println("Uncaught Exception occurred.");
		}

		while (true) {
			try {
				new LoginService().action(null);
			} catch (Exception ex) {
				System.err.println("An error occurred. Please try again");
			}
		}
	}

	private static void init() throws ParseException, AppException {
		DummyMasterDataInitializer.init();
	}
}
