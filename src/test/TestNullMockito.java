package test;

import static org.junit.Assert.*;
import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;
import classes.Extragere;
import classes.OutcomeEvent;
import classes.ProvidedResults;

public class TestNullMockito extends TestCase{

	ProvidedResults providedResults;
	
	@Before
	public void setUp() throws Exception {
		Extragere extragere = mock(Extragere.class);
		
		when(extragere.getLuna()).thenReturn("1");
		when(extragere.getZi()).thenReturn("19");
		when(extragere.getValoare()).thenReturn("34");
		
		providedResults = new ProvidedResults();
		providedResults.setExtragere(extragere);
		
	}


	@Test
	public void testExtragereNotNull() {
		assertNotNull(providedResults.getExtragere());
	}

	
	@Test
	public void testOutcomeNotNull() {
		OutcomeEvent outcome = mock(OutcomeEvent.class);
		when(outcome.getEventId()).thenReturn("43242");
		when(outcome.getOutcome()).thenReturn("x");
		providedResults.setOutcome(outcome);
		assertNotNull(providedResults.getOutcome());
	}
	
}

