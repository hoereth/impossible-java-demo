package info.hoereth.impossible;

import java.util.Locale;

import org.junit.Assert;
import org.junit.Test;

public class StringsSolution {
	/**
	 * There is not much you can do about it. Upper case transformation cannot
	 * always be reversed by lower case transformation.
	 */
	@Test
	public void upper_case() {
		Assert.assertEquals("WEISS", "weiß".toUpperCase());
		Assert.assertEquals("weiss", "WEISS".toLowerCase());
	}

	/**
	 * Some locales can produce unexpected outputs. In this case, we get an "ı"
	 * without the dot.
	 */
	@Test
	public void lower_case() {
		Assert.assertEquals("tıtle", "TITLE".toLowerCase(new Locale("tr", "TR")));
	}
}
