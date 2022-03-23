package com.java.advancedjava.concepts;

import java.util.ArrayList;
import java.util.stream.Stream;

import org.testng.annotations.Test;

public class StreamConcepts {

	//@Test
	public void streamConcepts() {

		ArrayList<String> names = new ArrayList<>();
		names.add("sharath");
		names.add("Bharath");
		names.add("Banesh");
		names.add("Bagashree");
		names.add("Pranitha");
		names.add("Pooja");

		// How to use the stream ? , , looping ,printing
		// To print the elements in the collections we have to go for the loops but we
		// can do the same using streams
		names.stream().filter(s -> s.startsWith("N")).forEach(s -> System.out.println(s));

		// startsWith is a Case sensitive method
		long l = names.stream().filter(s -> s.startsWith("P")).count();
		System.out.println(l);

		// Own stream creation
		Long d = Stream.of("Sharath", "Khara", "Kharad", "Sanjeev").filter(s -> s.contains("K")).count();
		System.out.println(d);

		// filter-intermediate
		// foreach is terminal operation
		// if the intermediate is false then terminal won't get execute
		// if there is no terminal then intermediate has no life
		Long n = Stream.of("Sharath", "Khara", "Kharad", "Sanjeev").filter(s -> {
			s.contains("K");
			return false;// observe here its false so count won't give the expected

		}).count();
		System.out.println(n);

		// Limit the number of elements to get printed, Only "Khara" will get printed
		Stream.of("Sharath", "Khara", "Kharad", "Sanjeev").filter(s -> s.startsWith("K")).limit(1)
				.forEach(s -> System.out.println(s));

	}
	
	@Test
	public void streamMap(){
		Stream.of("Sharath", "Khara", "Kharad", "Sanjeev").filter(s->s.length()>0).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
	}

}
