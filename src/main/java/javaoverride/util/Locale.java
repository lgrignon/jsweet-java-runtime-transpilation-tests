/*
 * Copyright 2014 Google Inc.
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

import javaoverride.util.Locale;

/**
 * A very simple emulation of Locale for shared-code patterns like
 * {@code String.toUpperCase(Locale.US)}.
 * <p>
 * Note: Any changes to this class should put into account the assumption that
 * was made in rest of the JRE emulation.
 */
public class Locale {

	static class RootLocale extends Locale {
		@Override
		public String toString() {
			return "";
		}
	}

	static class EnglishLocale extends Locale {
		@Override
		public String toString() {
			return "en";
		}
	}
	static class FrenchLocale extends Locale {
		@Override
		public String toString() {
			return "fr";
		}
	}

	static class USLocale extends Locale {
		@Override
		public String toString() {
			return "en_US";
		}
	}

	static class UKLocale extends Locale {
		@Override
		public String toString() {
			return "en-gb";
		}
	}



	static class DefaultLocale extends Locale {
		@Override
		public String toString() {
			return "fr";
		}
	}

	public static final Locale ROOT = new RootLocale();

	public static final Locale ENGLISH = new EnglishLocale();

	public static final Locale US = new USLocale();

	public static final Locale FRANCE = new FrenchLocale();

	public static final Locale UK = new UKLocale();

	private static Locale defaultLocale = new DefaultLocale();

	/**
	 * Returns an instance that represents the browser's default locale (not
	 * necessarily the one defined by 'gwt.locale').
	 */
	public static Locale getDefault() {
		return defaultLocale;
	}

	// Hidden as we don't support manual creation of Locales.
	private Locale() {
	}
}
