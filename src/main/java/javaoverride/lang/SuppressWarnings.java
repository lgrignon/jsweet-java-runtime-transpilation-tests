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
package javaoverride.lang;

import java.lang.String;

import javaoverride.lang.annotation.ElementType;
import javaoverride.lang.annotation.Retention;
import javaoverride.lang.annotation.RetentionPolicy;
import javaoverride.lang.annotation.Target;

/**
 * Indicates that the named compiler warnings should be suppressed in the
 * annotated element (and in all program elements contained in the annotated
 * element). <a
 * href="http://javaoverride.sun.com/j2se/1.5.0/docs/api/java/lang/SuppressWarnings.html">[Sun
 * docs]</a>
 */
@Target({
    ElementType.TYPE, ElementType.FIELD, ElementType.METHOD,
    ElementType.PARAMETER, ElementType.CONSTRUCTOR, ElementType.LOCAL_VARIABLE})
@Retention(RetentionPolicy.SOURCE)
public @interface SuppressWarnings {
  String[] value();
}
