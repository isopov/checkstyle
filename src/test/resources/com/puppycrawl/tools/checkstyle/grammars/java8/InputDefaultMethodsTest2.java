package com.puppycrawl.tools.checkstyle.grammars.java8;

public interface InputDefaultMethodsTest2 {
	
	public default void doSomething(){
		int a = 0;
        switch (a)
        {
        case 0:
            break;
        
        default:
            break;
        
        }
	}

}
