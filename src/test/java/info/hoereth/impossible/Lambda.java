package info.hoereth.impossible;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.Test;

public class Lambda {
	/**
	 * This test effectively measures the addition of two numbers. Why is it
	 * taking longer than 10 ms?
	 * 
	 * @see LambdaSolution#performance()
	 */
	@Test
	public void performance() {
		List<Integer> numbers = new ArrayList<>();
		numbers.add(1);
		numbers.add(2);

		long start = System.currentTimeMillis();
		add(numbers.stream());
		long stop = System.currentTimeMillis();
		long millis = stop - start;

		Assert.assertTrue("Duration was not taking longer than 10 ms: " + millis + "ms", millis >= 10);
	}

	private Integer add(Stream<Integer> stream) {
		return stream.reduce(0, (x, y) -> x + y);
	}
}
