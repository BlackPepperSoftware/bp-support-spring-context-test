package uk.co.blackpepper.support.spring.context.test;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.springframework.validation.BindingResult;

import static org.hamcrest.CoreMatchers.is;

public final class GlobalErrorCodeMatcher extends TypeSafeMatcher<BindingResult> {

	private final Matcher<String> errorCodeMatcher;
	
	private GlobalErrorCodeMatcher(Matcher<String> errorCodeMatcher) {
		this.errorCodeMatcher = errorCodeMatcher;
	}
	
	public static GlobalErrorCodeMatcher globalErrorCode(String expectedErrorCode) {
		return new GlobalErrorCodeMatcher(is(expectedErrorCode));
	}

	@Override
	public void describeTo(Description description) {
		description.appendText("Error code: ");
		description.appendDescriptionOf(errorCodeMatcher);
	}

	@Override
	protected boolean matchesSafely(BindingResult bindingResult) {
		return errorCodeMatcher.matches(bindingResult.getGlobalError().getCode());
	}

	public Matcher<String> getErrorCodeMatcher() {
		return errorCodeMatcher;
	}
}
