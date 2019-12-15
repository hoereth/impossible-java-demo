package info.hoereth.impossible;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.Test;

public class LambdaSolution {
	/**
	 * What actually takes so long is the virtual machine compiling the lambda
	 * code for the first time.
	 */
	@Test
	public void performance() {
		List<Integer> numbers = new ArrayList<>();
		numbers.add(1);
		numbers.add(2);

		// cold starting the lambda code
		add(numbers.stream());

		// once compiled, it cannot be measured by ms anymore
		long start = System.currentTimeMillis();
		add(numbers.stream());
		long stop = System.currentTimeMillis();
		long millis = stop - start;
		Assert.assertTrue("Duration was not 0: " + millis + "ms", millis == 0);
	}

	private Integer add(Stream<Integer> stream) {
		return stream.reduce(0, (x, y) -> x + y);
	}
}
