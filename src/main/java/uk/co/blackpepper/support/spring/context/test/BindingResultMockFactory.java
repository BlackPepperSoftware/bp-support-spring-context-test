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
