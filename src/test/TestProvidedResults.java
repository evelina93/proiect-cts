package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import classes.Extragere;
import classes.OutcomeEvent;
import classes.ProvidedResults;

public class TestProvidedResults {

	ProvidedResults providedResult;
	Extragere e;
	OutcomeEvent o;
	
	@Before
	public void setUp() throws Exception {
		
		providedResult = new ProvidedResults();
		e = new Extragere();
		o = new OutcomeEvent();
	}

	@Test
	public void testIllegaleArgumentException() {
		try {
			providedResult.polutateListsWithProvidedResults("Extr|2|2");
			fail("Exception expected");
		} catch (Exception e) {
			System.out.println("Illegale argument exception caught!");
		}
	}
	
	@Test
	public void testContainsSeparator() {
		try {
			providedResult.polutateListsWithProvidedResults("Extragere12");
			fail("Exception expected");
		} catch (Exception e) {
			System.out.println("Contains separator exception caught!");
		}
	}
	
	@Test
	public void testContainsTheNecessaryNumberOfParameters() {
		try {
			providedResult.polutateListsWithProvidedResults("Bilet|e");
			fail("Exception expected");
		} catch (Exception e) {
			System.out.println("Contains the necessary number of parameters exception caught!");
		}
	}
	
	
	@Test
	public void test_luna_valida() {
		Boolean result = providedResult.luna_valida("1");
		assertTrue("dsad", result);
	}
	

	@Test
	public void test_luna_fail() {
		
		try {
			providedResult.luna_valida("21");
			fail("Exception expected");
		} catch (Exception e) {
			System.out.println("<>Exception caught! (luna)");		
		}
	}
	
	
	@Test
	public void test_zi_valida()  {
		Boolean result = providedResult.zi_valida("3","1");
		assertTrue("ssssssssss", result);
	}
	
	
	@Test
	public void test_zi_fail() {
		try {
			providedResult.zi_valida("2", "30");
			fail("Exception expected");
		} catch (Exception e) {
			System.out.println("<>Exception caught! (zi)");
		}
	}
	
	@Test
	public void test_extragere_correct() throws Exception {
		String[] params={"E","2","12","56"};
		e = new Extragere("2", "12", "56");
		assertEquals(e, providedResult.createExtragere(params));
	}
	
	@Test
	public void test_extragere_fail() {
		try {
			String[] params={"Evcx","2d","12","56"};
			providedResult.createExtragere(params);
			fail("Exception expected");
		} catch (Exception e) {
			System.out.println("<>Exception caught! (extragere)");
		}
	}
	
	
	@Test
	public void test_outcome_correct() throws Exception {
		String[] params={"O","222","x"};
		o = new OutcomeEvent("222","x");
		assertEquals(o, providedResult.createOutcome(params));
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("down!");
	}

}
