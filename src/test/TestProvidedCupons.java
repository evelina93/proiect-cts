package test;

import static org.junit.Assert.*;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import classes.ProvidedCupons;

public class TestProvidedCupons {

	ProvidedCupons u;
	
	@Before
	public void setUp() throws Exception {
		u = new ProvidedCupons();
	}


	@Test
	public void testIllegaleArgumentException() {
		try {
			u.polutateListsWithprovidedCupons("Bo|ds|sd|32");
			fail("Exception expected");
		} catch (Exception e) {
			System.out.println("Illegale argument exception caught!");
		}
	}
	
	
	@Test
	public void testContainsSeparator() {
		try {
			u.polutateListsWithprovidedCupons("Bosasas");
			fail("Exception expected");
		} catch (Exception e) {
			System.out.println("Contains separator exception caught!");
		}
	}
	
	@Test
	public void testContainsTheNecessaryNumberOfParameters() {
		try {
			u.polutateListsWithprovidedCupons("Bon|ROSD|2");
			fail("Exception expected");
		} catch (Exception e) {
			System.out.println("Contains the necessary number of parameters exception caught!");
		}
	}
	
	@Test
	public void testLimitaSuperioaraValoare() {
		try {
			u.limita_superioara_valoare("8992");
			fail("Exception expected");
		} catch (Exception e) {
			System.out.println("Contains the necessary number of parameters exception caught!");
		}
	}
	
	@Test
	public void testLimitaInferioaraValoare() {
		try {
			u.limita_inferioara_valoare("0");
			fail("Exception expected");
		} catch (Exception e) {
			System.out.println("Contains the necessary number of parameters exception caught!");
		}
	}
	
	

	@After
	public void tearDown() throws Exception {
		System.out.println("down!");
	}
}
