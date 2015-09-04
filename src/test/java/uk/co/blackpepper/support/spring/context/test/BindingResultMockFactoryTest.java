package uk.co.blackpepper.support.spring.context.test;

import org.junit.Test;
import org.springframework.validation.BindingResult;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;

import static uk.co.blackpepper.support.spring.context.test.BindingResultMockFactory.mockBindingResult;
import static uk.co.blackpepper.support.spring.context.test.BindingResultMockFactory.mockBindingResultWithErrors;

public class BindingResultMockFactoryTest {

	@Test
	public void mockBindingResultSetsProperties() {
		BindingResult actual = mockBindingResult();
		
		assertThat("objectName", actual.getObjectName(), not(isEmptyOrNullString()));
		assertThat("errors", actual.hasErrors(), is(false));
	}

	@Test
	public void mockBindingResultWithObjectNameSetsProperties() {
		BindingResult actual = mockBindingResult("x");
		
		assertThat("objectName", actual.getObjectName(), is("x"));
		assertThat("errors", actual.hasErrors(), is(false));
	}
	
	@Test
	public void mockBindingResultWithErrorsSetsProperties() {
		BindingResult actual = mockBindingResultWithErrors();
		
		assertThat("objectName", actual.getObjectName(), not(isEmptyOrNullString()));
		assertThat("errors", actual.hasErrors(), is(true));
	}
	
	@Test
	public void mockBindingResultWithErrorsWithObjectNameSetsProperties() {
		BindingResult actual = mockBindingResultWithErrors("x");
		
		assertThat("objectName", actual.getObjectName(), is("x"));
		assertThat("errors", actual.hasErrors(), is(true));
	}
}
