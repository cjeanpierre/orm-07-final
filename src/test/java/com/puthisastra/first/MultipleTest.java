package com.puthisastra.first;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MultipleTest {

	private MultipleUtil multipleUtil;
	
	@Before
	public void setup() {
		multipleUtil = new MultipleUtil();
	}
	
	@Test
	public void istrue() {
		assertTrue(multipleUtil.isMultipleOf3Or5(3));
	}
	
	@Test
	public void ise() {
		assertFalse(multipleUtil.isMultipleOf3Or5(4));
	}
	
}
