package uk.co.blackpepper.support.spring.context.test;

import org.hamcrest.StringDescription;
import org.junit.Test;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import static uk.co.blackpepper.support.spring.context.test.GlobalErrorCodeMatcher.globalErrorCode;

public class GlobalErrorCodeMatcherTest {

	@Test
	public void globalErrorCodeReturnsMatcherWithProperties() {
		GlobalErrorCodeMatcher actual = globalErrorCode("x");
		
		assertThat("errorCodeMatcher", actual.getErrorCodeMatcher().matches("x"), is(true));
	}

	@Test
	public void describeToWritesDescription() {
		StringDescription description = new StringDescription();
		
		globalErrorCode("x").describeTo(description);
		
		assertThat(description.toString(), is("Error code: is \"x\""));
	}
	
	@Test
	public void matchesSafelyWhenErrorCodeMatchesReturnsTrue() {
		GlobalErrorCodeMatcher matcher = globalErrorCode("x");
		BindingResult errors = mock(BindingResult.class);
		when(errors.getGlobalError()).thenReturn(newObjectError("x"));
		
		boolean actual = matcher.matchesSafely(errors);
		
		assertThat(actual, is(true));
	}
	
	@Test
	public void matchesSafelyWhenErrorCodeDoesNotMatchReturnsFalse() {
		GlobalErrorCodeMatcher matcher = globalErrorCode("x");
		BindingResult errors = mock(BindingResult.class);
		when(errors.getGlobalError()).thenReturn(newObjectError("y"));
		
		boolean actual = matcher.matchesSafely(errors);
		
		assertThat(actual, is(false));
	}

	private static ObjectError newObjectError(String code) {
		return new ObjectError("", new String[] {code}, null, null);
	}
}
