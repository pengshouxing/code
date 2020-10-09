package com.test.cligb;

public class DogTest {

	public static void main(String[] args) {
          Dog dog = DogProxyFactory.getAuthInstance();
          dog.run();
	}

}
