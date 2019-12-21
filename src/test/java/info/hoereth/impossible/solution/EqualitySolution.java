package info.hoereth.impossible.solution;

import org.junit.Assert;
import org.junit.Test;

public class EqualitySolution {

	/**
	 * Number equality.
	 * 
	 * Two instances of {@link Integer} with the same value will only be
	 * represented by the same object instance "sometimes". Check the docs of
	 * {@link Integer} on caching if you want to know more.
	 * 
	 * Take away: always use {@link #equals(Object)} for comparing non-primitive
	 * data types.
	 */
	@Test
	public void compare_integers() {
		Integer i, j;

		i = 20;
		j = 20;

		System.out.println("integer identity has codes:");
		System.out.println("i: " + System.identityHashCode(i) + ", j: " + System.identityHashCode(j));

		Assert.assertTrue(i.equals(j));

		i = 2000;
		j = 2000;

		System.out.println("i: " + System.identityHashCode(i) + ", j: " + System.identityHashCode(j));

		Assert.assertTrue(i.equals(j));
	}
}
