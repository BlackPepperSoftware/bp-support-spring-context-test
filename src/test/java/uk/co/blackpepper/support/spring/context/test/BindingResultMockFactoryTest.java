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
