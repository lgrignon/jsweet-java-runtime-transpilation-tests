/*
 * Copyright 2008 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package javaemul.internal;

import javaoverride.lang.Iterable;
import javaoverride.util.Iterator;

public class IterableHelper {
	public static <T> Iterable<T> castToOverride(java.lang.Iterable<T> instance) {
		return (Iterable) (java.lang.Object) instance;
	}

	public static <T> java.lang.Iterable<T> castToLang(Iterable<T> instance) {
		return (java.lang.Iterable) (java.lang.Object) instance;
	}

	public static <T> Iterator<T> castIteratorToOverride(java.util.Iterator<T> instance) {
		return (Iterator) (java.lang.Object) instance;
	}

	public static <T> java.util.Iterator<T> castIteratorToLang(Iterator<T> instance) {
		return (java.util.Iterator) (java.lang.Object) instance;
	}
}