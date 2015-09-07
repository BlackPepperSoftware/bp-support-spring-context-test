/*
 * Copyright 2014 Black Pepper Software
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
