package com.puppycrawl.tools.checkstyle.grammars.java8;

public interface InputDefaultMethodsTest {
	
	default public void doSomething(){
		System.out.println("Something done.");
	}
	
	public void doOneMoreThing();

	public static void doStatic(String foo){
		System.out.println(foo);
	}
	
}
