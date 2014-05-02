package com.puppycrawl.tools.checkstyle.grammars.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

public class InputMethodReferencesTest {

	public static void main(String[] args) {

		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

		numbers.forEach(System.out::println);
		Collection<String> tl = new ArrayList<String>();
		Collection<String> tl2 = new ArrayList<>();

		Set<Integer> rosterSet = applyFunction(numbers, HashSet<Integer>::new);

	}

	private static <F, T> T applyFunction(F from, Function<F, T> function) {
		return function.apply(from);
	}


	private static class Foo {
		public void println(String str) {
			System.out.println(str);
		}
	}

	private static class Bar extends Foo {
		@Override
		public void println(String str) {
			super.println(str);
		}

		public void foobar(List<String> strs) {
			strs.forEach(this::println);
			strs.forEach(super::println);
		}

	}

}
