/*
 * Copyright 2007 Google Inc.
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
package javaoverride.util;

import static def.js.Globals.undefined;
import static javaemul.internal.InternalPreconditions.checkNotNull;
import static jsweet.util.Lang.object;

import javaoverride.lang.Comparable;
import java.lang.Object;
import javaoverride.lang.Override;
import javaoverride.util.Comparator;

class Comparators {
	/*
	 * This is a utility class that provides a default Comparator. This class
	 * exists so Arrays and Collections can share the natural comparator without
	 * having to know internals of each other.
	 *
	 * This class is package protected since it is not in the JRE.
	 */

	// extracted anonymous class
	static class NaturalComparator implements Comparator<Object> {
		@Override
		public int compare(Object o1, Object o2) {
			checkNotNull(o1);
			checkNotNull(o2);
			if (object(o1).$get("compareTo") == undefined) {
				return o1.toString().compareTo(o2.toString());
			}
			return ((Comparable<Object>) o1).compareTo(o2);
		}
	}
	
	/**
	 * Compares two Objects according to their <i>natural ordering</i>.
	 *
	 * @see javaoverride.lang.Comparable
	 */
	private static final Comparator<Object> NATURAL = new NaturalComparator();

	/**
	 * Returns the natural Comparator.
	 * <p>
	 * Example:
	 *
	 * <pre>Comparator&lt;String&gt; compareString = Comparators.natural()</pre>
	 *
	 * @return the natural Comparator
	 */
	public static <T> Comparator<T> natural() {
		return (Comparator<T>) NATURAL;
	}
}
