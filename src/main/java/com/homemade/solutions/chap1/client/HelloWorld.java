package com.homemade.solutions.chap1.client;

import javax.inject.Inject;

import org.slf4j.Logger;

public class HelloWorld {

	@Inject
	private Logger logger;

	public void say() {
		logger.info("Saying hello on console");
	}
}
