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
import javaoverride.lang.RuntimeException;
/**
 * See <a
 * href="http://javaoverride.sun.com/j2se/1.5.0/docs/api/java/util/NoSuchElementException.html">the
 * official Java API doc</a> for details.
 */
public class NoSuchElementException extends RuntimeException {

  public NoSuchElementException() {
  }

  public NoSuchElementException(String s) {
    super(s);
  }
}