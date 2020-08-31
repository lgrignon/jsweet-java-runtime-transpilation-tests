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

import javaoverride.lang.annotation.Documented;
import javaoverride.lang.annotation.ElementType;
import javaoverride.lang.annotation.Retention;
import javaoverride.lang.annotation.RetentionPolicy;
import javaoverride.lang.annotation.Target;

/**
 * Claims to the compiler that the annotation target does nothing potentially unsafe
 * to its varargs argument.
 */
@Documented
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = {ElementType.CONSTRUCTOR, ElementType.METHOD})
public @interface SafeVarargs {
}

