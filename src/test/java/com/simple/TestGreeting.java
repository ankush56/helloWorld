package com.simple;

import org.junit.Assert;
import org.junit.Test;

import com.simple.Greeting;

public class TestGreeting {

	@Test
	public void testLengthOfTheUniqueKey() {

		Greeting msg = new Greeting();
		Assert.assertEquals("GOOD", msg.getStatus());
	}
}
