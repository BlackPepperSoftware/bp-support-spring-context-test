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
