package com.puppycrawl.tools.checkstyle.grammars.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;

import static java.util.Arrays.asList;

public class InputMethodReferencesTest2 {

	public static void main(String[] args) {
		// instance method
		Function<String, Integer> ref1 = String::length;
		// static method
		Producer<Long> ref2 = System::currentTimeMillis;
		// explicit type arguments for generic type
		Function<List<String>, Integer> ref3 = List<String>::size;
		// inferred type arguments for generic type
		Function<List, Integer> ref4 = List::size;
		Function<int[], int[]> ref5 = int[]::clone;

		Consumer<?> ref6 = System.out::println;
		Producer<Integer> ref7 = "abc"::length;
		String[] array = new String[]{"foo", "bar"};
		Producer<Integer> ref8 = array[1]::length;
		List<String> list = new ArrayList<>(asList("foo", "bar "));
		Producer<Iterator<String>> ref9 = (2 == 5 - 3 ? replaceAndReturn(list, String::trim) : list)::iterator;


		// overload resolution needed
		Function<String, String> ref11 = String::valueOf;
		UnaryOperator<String> ref12 = String::valueOf;
		Function<Integer, String> ref13 = String::valueOf;

		// type arguments inferred from context
		Consumer<int[]> ref14 = Arrays::sort;
		Consumer<Integer[]> ref15 = Arrays::sort;
		// explicit type arguments
		Consumer<String[]> ref16 = Arrays::<String>sort;

		// constructor for parameterized type
		Producer<List<String>> ref17 = ArrayList<String>::new;
		// inferred type arguments
		Producer<List<String>> ref18 = ArrayList::new;

//		TODO - what does this mean?
//		// for generic class
//		Foo::<Integer>new;          // explicit type arguments
//		// for generic constructor
//		Bar<String>::<Integer > new;  // generic class, generic constructor
//		Outer.Inner::new;           // inner class constructor

		Function<Integer, int[]> ref22 = int[]::new;                 // array creation

	}


	private static <L extends List<T>, T> L replaceAndReturn(L list, UnaryOperator<T> operator) {
		list.replaceAll(operator);
		return list;
	}

	public <T extends CharSequence> void method() {
		Function<T, Integer> ref1 = T::length;
		Producer<String> ref2 = super::toString;
	}


	private interface Producer<T> {
		public T produce();
	}


}
