package uk.co.blackpepper.support.spring.context.test;

import org.springframework.validation.BindingResult;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public final class BindingResultMockFactory {
	
	private static final String DEFAULT_OBJECT_NAME = "_objectName";
	
	private BindingResultMockFactory() {
		throw new AssertionError();
	}
	
	public static BindingResult mockBindingResult() {
		return mockBindingResult(DEFAULT_OBJECT_NAME);
	}
	
	public static BindingResult mockBindingResult(String objectName) {
		return mockBindingResult(objectName, false);
	}

	public static BindingResult mockBindingResultWithErrors() {
		return mockBindingResultWithErrors(DEFAULT_OBJECT_NAME);
	}
	
	public static BindingResult mockBindingResultWithErrors(String objectName) {
		return mockBindingResult(objectName, true);
	}
	
	private static BindingResult mockBindingResult(String objectName, boolean errors) {
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.getObjectName()).thenReturn(objectName);
		when(bindingResult.hasErrors()).thenReturn(errors);
		return bindingResult;
	}
}
