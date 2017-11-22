package it.home.project;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HandlerDBTest {
	HandlerDB myHandler;

	@Before
	public void setUp() {
		myHandler = new HandlerDB();
	}

	@After
	public void tearDown() {
	}

	@Test
	public void testGetLastId() {
		assertFalse(myHandler.getLastId() == 0);
	}
}
