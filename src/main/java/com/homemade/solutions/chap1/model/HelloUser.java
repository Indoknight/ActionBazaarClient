package com.homemade.solutions.chap1.model;

import javax.ejb.Remote;


@Remote
public interface HelloUser {
	public String sayHello(String name);
}