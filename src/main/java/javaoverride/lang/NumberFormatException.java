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
package javaoverride.lang;

import javaoverride.lang.IllegalArgumentException;
import javaoverride.lang.NumberFormatException;

/**
 * See <a
 * href="http://javaoverride.sun.com/j2se/1.5.0/docs/api/java/lang/NumberFormatException.html">the
 * official Java API doc</a> for details.
 */
public class NumberFormatException extends IllegalArgumentException {

  public static NumberFormatException forInputString(String s) {
    return new NumberFormatException("For input string: \"" + s + "\"");
  }

  public static NumberFormatException forNullInputString() {
    return new NumberFormatException("null");
  }

  public static NumberFormatException forRadix(int radix) {
    return new NumberFormatException("radix " + radix + " out of range");
  }

  public NumberFormatException() {
  }

  public NumberFormatException(String message) {
    super(message);
  }
}
