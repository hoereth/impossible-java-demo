package info.hoereth.impossible;

import java.util.Locale;

import org.junit.Assert;
import org.junit.Test;

public class Strings {

	/**
	 * Why is toUpperCase + toLowerCase not producing the original input?
	 * 
	 * @see StringsSolution#upper_case()
	 */
	@Test
	public void upper_case() {
		String s = "weiß";
		String upper = s.toUpperCase();
		String lower = upper.toLowerCase();

		// FIXME: what happened?
		Assert.assertNotEquals(s, lower);
		Assert.assertNotEquals(s.length(), lower.length());
	}

	/**
	 * How can a turkish locale affect the toLowerCase?
	 */
	@Test
	public void lower_case() {
		String s = "TITLE";
		String lower = s.toLowerCase(new Locale("tr", "TR"));

		// FIXME: what happened?
		Assert.assertNotEquals("title", lower);
	}
}
