package info.hoereth.impossible;

import org.junit.Assert;
import org.junit.Test;

import info.hoereth.impossible.solution.EqualitySolution;

public class Equality {

	/**
	 * Number equality. Shouldn't i and j be equal?
	 * 
	 * @see EqualitySolution#compare_integers()
	 */
	@Test
	public void compare_integers() {
		Integer i, j;

		i = 20;
		j = 20;

		Assert.assertTrue(i == j);

		i = 2000;
		j = 2000;

		// FIXME: should be equal
		Assert.assertFalse(i == j);
	}
}
